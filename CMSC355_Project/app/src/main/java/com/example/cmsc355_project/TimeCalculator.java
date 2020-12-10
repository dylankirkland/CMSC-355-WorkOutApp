package com.example.cmsc355_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;

public class TimeCalculator extends AppCompatActivity {

    /*result display TextView*/
    /*final TextView outputExercises = (TextView) findViewById(R.id.outputExercises);
    */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_calculator);
    }

    /*calculates number of exercises possible based on inputs
    * and displays on screen*/

    /*public void onCalcTime(View v)
    {


        int x = new Integer(String.valueOf((EditText)findViewById(R.id.inputHours)));
        int y = new Integer(String.valueOf((EditText)findViewById(R.id.inputMinutes)));
        int sub = ((x*60)+y)/390;
        outputExercises.setText(sub);//print answer
    }*/


}