package com.example.cmsc355_project;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ExerciseUnitTest {
    Exercise test;

    @Test //Test to see if the PrintFormat() comes out in correct format and wanted result
    public void exercisePrintFormat_isCorrect(){
        test = new Exercise("Push-Up", 3 ,2 );
        assertEquals("The workout: Push-Up should be done for 3 sets and in each set should be 2 reps.", test.printFormat());
    }
}
