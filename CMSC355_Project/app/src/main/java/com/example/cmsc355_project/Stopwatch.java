package com.example.cmsc355_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.app.Activity;
import android.os.Handler;
import android.view.View;
import android.os.Bundle;
import java.util.Locale;
import android.widget.TextView;

//stopwatch button to be on home screen
public class Stopwatch extends Activity {

    // Seconds shown on stopwatch
    private int seconds = 0;

    // Whether stopwatch is running
    private boolean running;

    private boolean wasRunning;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stopwatch);
        if (savedInstanceState != null) {

            // Gets previous time on stopwatch if stopped
            seconds
                    = savedInstanceState
                    .getInt("seconds");
            running
                    = savedInstanceState
                    .getBoolean("running");
            wasRunning
                    = savedInstanceState
                    .getBoolean("wasRunning");
        }
        runTimer();
    }

    // Saves time on stopwatch if about to be destroyed
    @Override
    public void onSaveInstanceState(
            Bundle savedInstanceState)
    {
        savedInstanceState
                .putInt("seconds", seconds);
        savedInstanceState
                .putBoolean("running", running);
        savedInstanceState
                .putBoolean("wasRunning", wasRunning);
    }

    // Stops time is paused
    @Override
    protected void onPause()
    {
        super.onPause();
        wasRunning = running;
        running = false;
    }

    // Starts stopwatch if played after pausing
    @Override
    protected void onResume()
    {
        super.onResume();
        if (wasRunning) {
            running = true;
        }
    }

    // Starts stopwatch on clicking start button
    public void onClickStart(View view)
    {
        running = true;
    }

    // Stops stopwatch on clicking stop button
    public void onClickStop(View view)
    {
        running = false;
    }

    // Reset the stopwatch on reset button
    public void onClickReset(View view)
    {
        running = false;
        seconds = 0;
    }

    // Sets the time value on stopwatch
    private void runTimer()
    {

        // Get the text view
        final TextView timeView
                = (TextView)findViewById(
                R.id.InfoBox1);

        // Creates a new Handler
        final Handler handler
                = new Handler();

        // Call the post() method to processes the code without delay
        handler.post(new Runnable() {
            @Override

            public void run()
            {
                int hours = seconds / 3600;
                int minutes = (seconds % 3600) / 60;
                int secs = seconds % 60;

                // Format the seconds into hours, minutes, seconds
                String time
                        = String
                        .format(Locale.getDefault(),
                                "%d:%02d:%02d", hours,
                                minutes, secs);

                // Set the text view text
                timeView.setText(time);

                // Increase the seconds if stopwatch is running
                if (running) {
                    seconds++;
                }

                // Post the code with a 1 sec delay
                handler.postDelayed(this, 1000);
            }
        });
    }
}