package com.example.cmsc355_project;

import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 *
 * The Workout object represents a list of exercises
 *
 * This is a class so that it's function are not on the main activity.  - Palancapg
 *
 */

public class Workout{
    ArrayList<Exercise> exercises;

    //Default Constructor
    public Workout(){
    }

    //Parameterized Constructor
    public Workout(ArrayList<Exercise> exercises){
        this.exercises = exercises;
    }

    //Method on Adding exercises to Workout and should update list and reprint the list
    public void addExercise(Exercise newExercise){
        this.exercises.add(newExercise);

        //reprint
    }

    //Method on Removing specific from list and should update list and reprint the list
    public void removeExercise(Exercise unwantedExercise, Boolean confirmation){

        if(exercises.contains(unwantedExercise) && confirmation){ //Checks to see if the exercise is in the workout and the user actually wants to remove it -Palancapg
            this.exercises.remove(unwantedExercise);
        }
        else{
            System.out.println("Exercise can not be removed at this time");
        }

        //reprint with print format

    }

    //Method will rearrange list
    public void rearrange(Exercise movingExercise){

    }

    //Printing the list out in a specific format
    public String print(){
        return null;
    }






}
