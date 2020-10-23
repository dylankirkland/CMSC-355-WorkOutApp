package com.example.cmsc355_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity3 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        buttonNext = findViewById(R.id.buttonNext); //xml id for this button
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            //when button is clicked, opens activity 2 using openMainActivity2() method
            public void onClick(View view) {
                openMainActivity3();
            }
        });
    }
    private Button buttonNext; //variable for button

    public void openMainActivity3() {
        //intent object, parameters passed are context and class we want to open (context,class)
        Intent intent = new Intent(this, MainActivity3.class);
        startActivity(intent); //pass intent created in line above
    }
}
