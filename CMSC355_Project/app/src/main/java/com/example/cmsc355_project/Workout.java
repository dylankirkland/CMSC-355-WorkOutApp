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
    ArrayList<Exercise> workoutList;

    //Default Constructor
    public Workout(){
    }

    //Parameterized Constructor
    public Workout(ArrayList<Exercise> workoutList){
       this.workoutList = workoutList;
    }

    //Method on Adding exercises to Workout and should update list and reprint the list
    public void addExercise(Exercise newExercise){
        this.workoutList.add(newExercise);

        //Reprint updated workout list
        printWorkout();
    }

    //Method on Removing specific from list and should update list and reprint the list
    public void removeExercise(Exercise unwantedExercise, Boolean confirmation){

        if(workoutList.contains(unwantedExercise) && confirmation){ //Checks to see if the exercise is in the workout and the user actually wants to remove it -Palancapg
            this.workoutList.remove(unwantedExercise);
        }
        else if(!workoutList.contains(unwantedExercise) && confirmation){
           System.out.println("Exercise: " + unwantedExercise.name + " looking to be removed is not found");
        }
        else if(workoutList.contains(unwantedExercise) && !confirmation){
           System.out.println("Removal Process Stopped");
        }
        else{
            System.out.println("Exercise and Confirmation can not be found :(");
        }

        //Reprint updated workout list
        printWorkout();

    }

    //Method will rearrange list if a user wants to
    public void rearrange(Exercise movingExercise){

    }

    //Printing the list out in a specific format
    public void printWorkout(){
        for(Exercise exercise:workoutList) {
            System.out.println(exercise.name + "   " + String.valueOf(exercise.sets) + " x " + String.valueOf(exercise.reps));
        }
    }






}
