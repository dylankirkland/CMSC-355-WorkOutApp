package com.example.cmsc355_project;

/**
 *
 * The Workout class represents a workout it will contain the information of the workout's name,
 * how many sets the user wants to do, and how many reps of the certain workout. It will also implement
 * methods to set these variables. -Palancapg
 *
 * This is a class so that it's function are not on the main activity.  - Palancapg
 *
 */

public class Workout{
    String name;
    int reps;
    int sets;

    /**
     *    Default Constructor -Palancapg
     */
    public Workout(){
        name = "N/A";
        reps = 0;
        sets = 0;
    }

    /**
     *    Parametrized Constructor -Palancapg
     */
    public Workout(String name,int reps,int sets){
    }

    /**
     * Setter Methods -Palancapg
     */
    public void setName(String name){
    }

    public void setReps(int reps) {
    }

    public void setSets(int sets) {
    }
    /**
     * Getter Methods -Palancapg
     */
    public String getName() {
        return name;
    }

    public int getReps() {
        return reps;
    }

    public int getSets() {
        return sets;
    }

    /**
     *  Print Format Method - Palancapg
     */


}
