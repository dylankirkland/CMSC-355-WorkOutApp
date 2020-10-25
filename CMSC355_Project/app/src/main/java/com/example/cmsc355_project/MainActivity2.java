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
    private Button buttonHome;
    private Button buttonCreateWorkout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        buttonHome = findViewById(R.id.buttonHome); //xml id for this button
        buttonHome.setOnClickListener(new View.OnClickListener() {
            @Override
            //when button is clicked, opens activity 2 using openMainActivity2() method
            public void onClick(View view) {
                openMainActivity2();
            }
        });

        buttonCreateWorkout = findViewById(R.id.buttonCreateWorkout); //xml id for this button
        buttonCreateWorkout.setOnClickListener(new View.OnClickListener() {
            @Override
            //when button is clicked, opens activity 3 using openMainActivity3() method
            public void onClick(View view) {
                openMainActivity3();
            }
        });
    }
    public void openMainActivity2() {
        //intent object, parameters passed are context and class we want to open (context,class)
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent); //pass intent created in line above
    }
    public void openMainActivity3() {
        //intent object, parameters passed are context and class we want to open (context,class)
        Intent intent = new Intent(this, MainActivity3.class);
        startActivity(intent); //pass intent created in line above
    }
}