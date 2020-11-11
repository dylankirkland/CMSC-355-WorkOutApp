package com.example.cmsc355_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CreateWorkoutActivity extends AppCompatActivity {

    Button submitButton;
    Button submitButton2;
    Button buttonHome;
    ListView listView;
    ArrayAdapter<Exercise> arrayAdapter;
    Workout workoutList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_workout);

        workoutList = new Workout();

        setListAdapter(workoutList);

        submitButton2 = findViewById(R.id.submitWorkoutName);
        submitButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setWorkoutName(workoutList);
            }
        });

        //Takes a input from app and sets input to a new exercise. Then it adds it to a workout list
        submitButton = findViewById(R.id.submitExercise);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createExercise();
            }
        });

        buttonHome = findViewById(R.id.buttonHome);
        buttonHome.setOnClickListener(new View.OnClickListener() {
            @Override
            //when button is clicked, opens activity 2 using openMainActivity2() method
            public void onClick(View view) {
                openHomeActivity();
            }
        });

       // listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
         //   @Override
         //   public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l){
           //     workoutList.removeExercise(workoutList.getWorkoutList().get(i), true);

              //  return true;
            //}

        //});



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(CreateWorkoutActivity.this, workoutList.getWorkoutList().get(i).printFormat(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    /**
     * The creates the list adapter for the workout list
     * @param workoutList the workout the user is working on creating or editing
     */
    public void setListAdapter(Workout workoutList){
        listView = findViewById(R.id.workList);

        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1, workoutList.getWorkoutList());
        listView.setAdapter(arrayAdapter);
    }

    /**
     * This sets the name of the workout
     * @param workoutList the workout the user is working on creating or editing
     */
    public void setWorkoutName(Workout workoutList){
        TextView workout_name = findViewById(R.id.workout_name);
        EditText workoutName = findViewById(R.id.nameOfWorkout);

        String name = workoutName.getText().toString();

        workoutList.setName(name);

        workout_name.setText(name);
    }

    /**
     * Creates an Object to be added to the list adapter and to the workout list
     */
    public void createExercise(){
        EditText workName = findViewById(R.id.nameOfExercise);
        EditText numberSets = findViewById(R.id.numberOfSets);
        EditText numberReps = findViewById(R.id.numberOfReps);

        String name = workName.getText().toString();
        int sets = Integer.parseInt(numberSets.getText().toString());
        int reps = Integer.parseInt(numberReps.getText().toString());

        //creates new exercise
        Exercise newExercise =  new Exercise(name,sets,reps);
        arrayAdapter.add(newExercise);

    }
    public void openHomeActivity() {
        //intent object, parameters passed are context and class we want to open (context,class)
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent); //pass intent created in line above
    }
}
