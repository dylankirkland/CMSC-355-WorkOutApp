package com.example.cmsc355_project;

/**
 *
 * The Exercise object represents a specific exercise it will contain the information of the exercise's name,
 * how many sets the user wants to do, and how many reps of the certain workout. It will also implement
 * methods to set these variables. -Palancapg
 *
 * This is a class so that it's function are not on the main activity.  - Palancapg
 *
 */

public class Exercise{
    String name;
    int reps;
    int sets;

    /**
     *    Parametrized Constructor -Palancapg
     *
     *    running checks?? however each parameter should be going in correctly.
     */
    public Exercise(String name,int sets,int reps){
        setName(name);
        setReps(reps);
        setSets(sets);
    }

    /**
     * Setter Methods -Palancapg
     */
    public void setName(String name){
        this.name = name;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    public void setSets(int sets) {
        this.sets = sets;
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

    public String printFormat(){
        return "The workout: " + getName() + " should be done for " + getSets() + " sets and in each set should be "
                + getReps() + " reps.";
    }

   // public String toString(){
   //     return getName() + " " + getSets() + " x " + getReps();
   // }


}
