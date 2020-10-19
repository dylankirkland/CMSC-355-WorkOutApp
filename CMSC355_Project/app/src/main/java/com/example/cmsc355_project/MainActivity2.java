package com.example.cmsc355_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button addWorkoutBttn = (Button) findViewById(R.id.addWorkoutBttn);
        Button settingsBttn = (Button) findViewById(R.id.settingsBttn);




    }
}