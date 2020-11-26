package com.example.cmsc355_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

/**
 * App's Main Welcome Screen
 * -------------------------
 * Use of Button to bring you to Main Workout Screen
 *
 * Possible Picture of Logo Implemented? - Palancapg
 *
 */

public class WelcomeActivity extends AppCompatActivity {
    public ImageView simplyLogo = findViewById(R.id.simplyLogo);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome); //set current screen to layout of activity_home.xml

        //variable for button
        Button buttonNext = findViewById(R.id.buttonNext); //xml id for this button
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            //when button is clicked, opens activity 2 using openMainActivity2() method
            public void onClick(View view) {
                openHomeActivity();
            }
        });
    }
    public void openHomeActivity() {
        //intent object, parameters passed are context and class we want to open (context,class)
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent); //pass intent created in line above
    }
}

