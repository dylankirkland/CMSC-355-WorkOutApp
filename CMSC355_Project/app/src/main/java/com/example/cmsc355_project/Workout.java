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
    String name;

    //Default Constructor
    public Workout(){
        this.workoutList = new ArrayList<Exercise>();
        this.name = null;
    }

    //Parameterized Constructor
    public Workout(ArrayList<Exercise> workoutList,String name){
       this.workoutList = workoutList;
       this.name = name;
    }

    public void setWorkoutList(ArrayList<Exercise> workoutList) {
        this.workoutList = workoutList;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Exercise> getWorkoutList() {
        return workoutList;
    }

    //Method on Adding exercises to Workout and should update list and reprint the list
    public void addExercise(Exercise newExercise){
        this.workoutList.add(newExercise);
    }

    //Method on Removing specific from list and should update list and reprint the list
    public void removeExercise(Exercise unwantedExercise){
        workoutList.remove(unwantedExercise);
    }

    //Method will rearrange list if a user wants to
    public void rearrange(Exercise movingExercise, int index){
        if(workoutList.get(index) == null) { //see if the index is filled with another exercise
            this.workoutList.add(index, movingExercise); // if so place it in the index and the arrayList will shift to the right
        }
        else{
            addExercise(movingExercise); // if not then it will add the exercise to the bottom of workout
        }
    }

    //Clears Workout and starts off with a fresh arrayList
    public void restartWorkout(){
        workoutList.clear();
    }

    //Printing the list out in a specific format
    public void printWorkout(){
        for(Exercise exercise:workoutList) {
            System.out.println(exercise.name + "   " + exercise.sets + " x " + exercise.reps);
        }
    }






}
