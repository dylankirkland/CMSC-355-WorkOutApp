package com.example.workoutapp3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button confirmBttn = (Button) findViewById(R.id.confirmBttn);
        confirmBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editTextWeight = (EditText) findViewById(R.id.editTextWeight);
                EditText ageEditText = (EditText) findViewById(R.id.ageEditText);

            }
        });

    }
}