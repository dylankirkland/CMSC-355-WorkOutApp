package com.example.cmsc355_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Settings extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);

        //Button settingsBtn =(Button) findViewById(R.id.submitBtn);

        Button buttonHome;
        buttonHome = findViewById(R.id.buttonHome); //xml id for this button
        buttonHome.setOnClickListener(new View.OnClickListener() {
            @Override
            //when button is clicked, opens activity 2 using openMainActivity2() method
            public void onClick(View view) {
                openHomeActivity();
            }
        });
        Button profile = findViewById(R.id.Profile);
        Button goals = findViewById(R.id.Goals);
        Button nutriention = findViewById(R.id.Nutrition);
        Button preferences = findViewById(R.id.Preferences);
        Button agreement = findViewById(R.id.Agreement);
        Button submitBtn = findViewById(R.id.submitBtn);


    }
    public void openHomeActivity() {
        //intent object, parameters passed are context and class we want to open (context,class)
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent); //pass intent created in line above

    }


}
