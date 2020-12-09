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
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;

public class EditWorkoutActivity extends AppCompatActivity {

    private ArrayList<String> workoutKeys;
    private Workout loadedWorkout;
    private Spinner workouts_saved;
    private ListView workoutList;
    private ArrayAdapter<Exercise> workListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_workout);

        loadedWorkout = new Workout();
        workoutKeys = new ArrayList<>();

        setDropdownAdapter(); //Sets the spinner items to the keys in SharedPreferences

        //When element in spinner is click this will help pull up the needed information from that element
        workouts_saved.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                loadData(workouts_saved.getSelectedItem().toString()); //Loads a workout for selected workout to the List
                setListAdapter(loadedWorkout); //Sets it as the list adapter

                //When ListView Element is "PUSHED" it will ask to delete the exercise
                workoutList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                    @Override
                    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l){
                        buildDeleteExercisePopup(i);
                        return true;
                    }
                });


            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                //Left Blank due to the fact that when noting is selected isn't truly needed
            }
        });

        //When button is pressed a new exercise will be created and added to the loaded workout
        Button edit_submitNewExerciseBttn = findViewById(R.id.submitExercise);
        edit_submitNewExerciseBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createExercise();
            }
        });

        //When button it will save the user's created workout to the app's Shared Preference
        Button edit_saveBttn = findViewById(R.id.saveWorkoutButton);
        edit_saveBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveData(loadedWorkout.getName());
                Toast.makeText(EditWorkoutActivity.this,loadedWorkout.getName() + " edits has been saved! Load on Home Screen", Toast.LENGTH_SHORT).show();

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
     * Loads a workout list that is saved to shared preferences to the loadedWorkout variable for future use - Palanapg
     * @param name name of workout
     */
    private void loadData(String name){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        Gson gson = new Gson();
        String workout = sharedPreferences.getString(name,null);
        Type type = new TypeToken<Workout>() {}.getType();
        loadedWorkout = gson.fromJson(workout,type);
    }

    /**
     * Saves the user created workout to the storage structure so that it can be accessed on home page
     * @param name  takes in the name of the workout so it can set as key in storage map
     */
    private void saveData(String name){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String workout = gson.toJson(loadedWorkout);
        editor.putString(name, workout);
        editor.apply();

    }

    /**
     * Sets up the list adapter - Palancapg
     * @param workout the workout that is pulled from sharedPreferences
     */
    private void setListAdapter(Workout workout){
        workoutList = findViewById(R.id.workList);

        workListAdapter = new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1, workout.getWorkoutList());
        workoutList.setAdapter(workListAdapter);
    }

    /**
     * Sets the drop menu that will be used to load any saved workouts -Palancapg
     */
    private void setDropdownAdapter(){
        workouts_saved = findViewById(R.id.loadWorkoutDropdown);

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        Map<String, ?> values = sharedPreferences.getAll();

        if (!values.isEmpty()) { //checks to see if the value is not empty because if so it will skip this step
            for (Map.Entry<String, ?> entry : values.entrySet()) {
                workoutKeys.add(entry.getKey()); //adds all keys to an array list object
            }

            ArrayAdapter<String> dropdownAdapter = new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1, workoutKeys);
            workouts_saved.setAdapter(dropdownAdapter); //sets the spinner adapter with all the keys in saved on shared preferences
        }
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

        loadedWorkout.addExercise(newExercise);
        workListAdapter.notifyDataSetChanged();

    }

    /**
     * This method will build a popup so that when a user presses an exercise it will give the user the option to delete it
     * @param unwantedExercise this refers to the exercise the user would like to delete
     */
    private void buildDeleteExercisePopup(final int unwantedExercise){
        //Creation of the alert dialog
        new AlertDialog.Builder(EditWorkoutActivity.this)
                .setTitle("Are you sure?")
                .setMessage("Please confirm for deletion of: " + loadedWorkout.getWorkoutList().get(unwantedExercise).getName())
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        loadedWorkout.removeExercise(loadedWorkout.getWorkoutList().get(unwantedExercise)); //Removes workout from the workoutlist
                        workListAdapter.notifyDataSetChanged(); //updates the adapter
                    }
                })
                .setNegativeButton("No",null)
                .show();
    }

    /**
     * When method is called it leads user back to the Home screen
     */
    public void openHomeActivity() {
        //intent object, parameters passed are context and class we want to open (context,class)
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent); //pass intent created in line above
    }
}
