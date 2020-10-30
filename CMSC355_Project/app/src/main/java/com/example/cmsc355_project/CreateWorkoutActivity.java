package com.example.cmsc355_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CreateWorkoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Toolbar toolbar;
        Button submitButton;
        Button submitButton2;
        Button buttonHome;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_workout);

        submitButton = (Button) findViewById(R.id.submitExercise);
        submitButton2 = (Button) findViewById(R.id.submitExercise2);

        buttonHome = findViewById(R.id.buttonHome);
        buttonHome.setOnClickListener(new View.OnClickListener() {
            @Override
            //when button is clicked, opens activity 2 using openMainActivity2() method
            public void onClick(View view) {
                openMainActivity2();
            }
        });

        //causes runtime error, can't click create workout button or transition to create workout.xml
        /*toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Create New Workout");
         */

        final Workout workoutList = new Workout();

        //Takes a input from app and sets the name of workout list
        submitButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText workoutName = (EditText) findViewById(R.id.nameOfWorkout);

                String name = workoutName.getText().toString();

                workoutList.setName(name);

            }
        });

        //Takes a input from app and sets input to a new exercise. Then it adds it to a workout list
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText workName = (EditText) findViewById(R.id.nameOfExercise);
                EditText numberSets = (EditText) findViewById(R.id.numberOfSets);
                EditText numberReps = (EditText) findViewById(R.id.numberOfReps);

                String name = workName.getText().toString();
                int sets = Integer.parseInt(numberSets.getText().toString());
                int reps = Integer.parseInt(numberReps.getText().toString());

                Exercise newExercise = new Exercise(name,sets,reps);
                workoutList.addExercise(newExercise);

            }
        });

    }
    public void openMainActivity2() {
        //intent object, parameters passed are context and class we want to open (context,class)
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent); //pass intent created in line above
    }
}