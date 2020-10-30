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

        Button buttonHome;
        buttonHome = findViewById(R.id.buttonHome); //xml id for this button
        buttonHome.setOnClickListener(new View.OnClickListener() {
            @Override
            //when button is clicked, opens activity 2 using openMainActivity2() method
            public void onClick(View view) {
                openMainActivity2();
            }
        });
    }
    public void openMainActivity2() {
        //intent object, parameters passed are context and class we want to open (context,class)
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent); //pass intent created in line above
    }
}
