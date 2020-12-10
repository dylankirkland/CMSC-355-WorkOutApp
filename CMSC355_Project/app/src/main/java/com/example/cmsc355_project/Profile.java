package com.example.cmsc355_project;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Profile extends AppCompatActivity {
    private EditText editTextWeight = findViewById(R.id.editTextWeight);
    private EditText ageEditText = findViewById(R.id.ageEditText);
    private Button confirm = findViewById(R.id.confirmBttn);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);
    }
}
