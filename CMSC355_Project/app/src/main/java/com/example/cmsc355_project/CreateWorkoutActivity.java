package com.example.cmsc355_project;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

public class CreateWorkoutActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayAdapter<Exercise> arrayAdapter;
    private Workout workoutList;
    private TextView workout_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_workout);

        workoutList = new Workout();

        setListAdapter(workoutList);

        //When button it will save the user's created workout to the app's Shared Preference
        Button saveBttn = findViewById(R.id.saveWorkoutButton);
        saveBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(workoutList.getName() == null && workout_name == null){ //The workout has to have a name to save properly this will check that
                    Toast.makeText(CreateWorkoutActivity.this, "The workout trying to be saved is invalid! Please include a workout name.", Toast.LENGTH_SHORT).show();
                }
                else{
                    saveData(workoutList.getName());
                    Toast.makeText(CreateWorkoutActivity.this,workoutList.getName() + " has been saved! Load on Home Screen", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //When button is pressed will set the Workout's name to whatever user inputs
        Button submitWorkoutNameBttn = findViewById(R.id.submitWorkoutName);
        submitWorkoutNameBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setWorkoutName(workoutList);
            }
        });

        //Takes a input from app and sets input to a new exercise. Then it adds it to a workout list
        Button submitExerciseNameBttn = findViewById(R.id.submitExercise);
        submitExerciseNameBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createExercise();
            }
        });

        //When ListView Element is "PUSHED" it will ask to delete the exercise
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l){
                buildDeleteExercisePopup(i);
                return true;
            }
        });

        //When ListView Element is "PRESSED" it will give description of workout
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(CreateWorkoutActivity.this, workoutList.getWorkoutList().get(i).printFormat(), Toast.LENGTH_SHORT).show();

            }
        });



        Button buttonHome = findViewById(R.id.buttonHome);
        buttonHome.setOnClickListener(new View.OnClickListener() {
            @Override
            //when button is clicked, opens activity 2 using openMainActivity2() method
            public void onClick(View view) {
                openHomeActivity();
            }
        });


    }

    /**
     * The creates the list adapter for the workout list
     * @param workoutList the workout the user is working on creating or editing
     */
    private void setListAdapter(Workout workoutList){
        listView = findViewById(R.id.workList);

        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1, workoutList.getWorkoutList());
        listView.setAdapter(arrayAdapter); //Sets the workoutList as the adapter for the listView object
    }

    /**
     * This sets the name of the workout
     * @param workoutList the workout the user is working on creating or editing
     */
    private void setWorkoutName(Workout workoutList){
        workout_name = findViewById(R.id.workout_name);
        EditText workoutName = findViewById(R.id.nameOfWorkout);

        String name = workoutName.getText().toString(); //Grabs the user input and sets into a string variable

        workoutList.setName(name); //sets to the workList variable

        workout_name.setText(name); //sets to the textview element
    }

    /**
     * Creates an Object to be added to the list adapter and to the workout list
     */
    private void createExercise() {
        EditText workName = findViewById(R.id.nameOfExercise);
        EditText numberSets = findViewById(R.id.numberOfSets);
        EditText numberReps = findViewById(R.id.numberOfReps);

        //Grabs any input from the user and sets it so that it can create an exercise object
        String name = workName.getText().toString();
        int sets = Integer.parseInt(numberSets.getText().toString());
        int reps = Integer.parseInt(numberReps.getText().toString());

        //creates new exercise
        Exercise newExercise =  new Exercise(name,sets,reps);

        workoutList.addExercise(newExercise);
        arrayAdapter.notifyDataSetChanged();
    }
  
   /**
    * Saves the user created workout to the storage structure so that it can be accessed on home page
    * @param name  takes in the name of the workout so it can set as key in storage map
    */
    private void saveData(String name){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String workout = gson.toJson(workoutList);
        editor.putString(name, workout);
        editor.apply();

    }

    /**
     * This method will build a popup so that when a user presses an exercise it will give the user the option to delete it
     * @param unwantedExercise this refers to the exercise the user would like to delete
     */
    private void buildDeleteExercisePopup(final int unwantedExercise){
        //Creation of the alert dialog
        new AlertDialog.Builder(CreateWorkoutActivity.this)
                .setTitle("Are you sure?")
                .setMessage("Please confirm for deletion of: " + workoutList.getWorkoutList().get(unwantedExercise).getName())
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        workoutList.removeExercise(workoutList.getWorkoutList().get(unwantedExercise)); //Removes workout from the workoutlist
                        arrayAdapter.notifyDataSetChanged(); //updates the adapter
                    }
                })
                .setNegativeButton("No",null)
                .show();
    }

    /**
     * Method that when used opens the HomeActivity()
     */
    public void openHomeActivity() {
        //intent object, parameters passed are context and class we want to open (context,class)
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent); //pass intent created in line above
    }
}
//gdfsas