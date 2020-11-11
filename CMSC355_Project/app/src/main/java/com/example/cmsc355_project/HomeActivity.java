package com.example.cmsc355_project;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;

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

public class HomeActivity extends AppCompatActivity {

    private ArrayList<String> workoutKeys;
    private Workout loadedWorkout;
    private Spinner workouts_saved;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        loadedWorkout = new Workout();
        workoutKeys = new ArrayList<>();

        accessSharedPreferences(); //Accesses SharedPreferences and the keys to all the items in it
        setDropdownAdapter(workoutKeys); //Sets the spinner items to the keys in SharedPreferences
        loadData(workouts_saved.getSelectedItem().toString()); //Loads a workout for selected workout to the List
        setListAdapter(loadedWorkout); //Sets it as the list adapter


        Button buttonHome = findViewById(R.id.buttonHome); //xml id for this button
        buttonHome.setOnClickListener(new View.OnClickListener() {
            @Override
            //when button is clicked, opens activity 2 using openMainActivity2() method
            public void onClick(View view) { openHomeActivity(); }
        });

        Button buttonCreateWorkout = findViewById(R.id.buttonCreateWorkout);
        buttonCreateWorkout.setOnClickListener(new View.OnClickListener() {
            @Override
            //when button is clicked, opens Create Workout using openCreateWorkoutActivity() method
            public void onClick(View view) {openCreateWorkoutActivity(); }
        });

        Button buttonSettings = findViewById(R.id.buttonSettings);
        buttonSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            //when button is clicked, opens Settings using openSettings() method
            public void onClick(View view) { openSettings(); }
        });

    }

    /**
     * Sets the drop menu that will be used to load any saved workouts -Palancapg
     *
     * @param keys list of all the workout names that when pressed will load the work out
     */
    public void setDropdownAdapter(ArrayList<String> keys){
        workouts_saved = findViewById(R.id.loadWorkoutDropdown);

        if(!keys.isEmpty()) {
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1, keys);
            workouts_saved.setAdapter(adapter);
        }
    }

    /**
     * Creates the our access to any of the keys of workouts in SharedPreferences -Palacnapg
     */
    private void accessSharedPreferences(){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        Map<String, ?> values = sharedPreferences.getAll();

        if (!values.isEmpty()) {
            for (Map.Entry<String, ?> entry : values.entrySet()) {
                workoutKeys.add(entry.getKey());
            }
        }
    }

    /**
     * Loads a workout list that is saved to shared preferences to the loadedWorkout variable for future use - Palanapg
     * @param name name of workout
     */
    private void loadData(String name){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        Gson gson = new Gson();
        String workout = sharedPreferences.getString(name,null);
        Type type = new TypeToken<Workout>() {}.getType();
        loadedWorkout = gson.fromJson(workout,type);
    }

    /**
     * Sets up the list adapter - Palancapg
     * @param workout the workout that is pulled from sharedPreferences
     */
    public void setListAdapter(Workout workout){
        ListView workoutList = findViewById(R.id.workList);

        ArrayAdapter<Exercise> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1, workout.getWorkoutList());
        workoutList.setAdapter(arrayAdapter);
    }


    public void openHomeActivity() {
        //intent object, parameters passed are context and class we want to open (context,class)
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent); //pass intent created in line above
    }
    public void openCreateWorkoutActivity() {
        //intent object, parameters passed are context and class we want to open (context,class)
        Intent intent = new Intent(this, CreateWorkoutActivity.class);
        startActivity(intent); //pass intent created in line above
    }
    public void openSettings() {
        //intent object, parameters passed are context and class we want to open (context,class)
        Intent intent = new Intent(this, Settings.class);
        startActivity(intent); //pass intent created in line above
    }
}