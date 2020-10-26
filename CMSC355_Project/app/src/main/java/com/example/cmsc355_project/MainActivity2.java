package com.example.cmsc355_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * App's Main Workout Layout Screen
 * --------------------------------
 * IN-CODE LIST
 * ------------
 * Needs to include a scrollable list of workout create -Palancapg
 *
 * Needs to take in values/information made from the Create New Workout Screen -Palancapg
 *
 * IF TIME Possible Categories Box View that might bring to new activity -Palancapg
 *
 * Basically Prints out list in a need format from given information from CREATE NEW workout
 *
 */

public class MainActivity2 extends AppCompatActivity {
    private Button addWorkoutBttn;
    private Button settingsBttn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        addWorkoutBttn = findViewById(R.id.addWorkoutBttn);
        settingsBttn = findViewById(R.id.settingsBttn);

        addWorkoutBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            //when button is clicked, opens Create Workout using openCreateWorkoutActivity() method
            public void onClick(View view) {
                openCreateWorkoutActivity();
            }
        });
    }

    public void openCreateWorkoutActivity() {
        //intent object, parameters passed are context and class we want to open (context,class)
        Intent intent = new Intent(this, CreateWorkoutActivity.class);
        startActivity(intent); //pass intent created in line above
    }
}