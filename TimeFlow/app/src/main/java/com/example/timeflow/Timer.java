package com.example.timeflow;

import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class Timer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

    }

    int intervals = 0;
    boolean intervalsFlag = false;

    public void updateTimer(View v) {

        TextView timerCountdown = findViewById(R.id.timerCountdown);
        TextView timerDirectionsMessage = findViewById(R.id.timerDirections);
        View timerInput = findViewById(R.id.timerInputDuration);
        String timerInputString = ((TextView)timerInput).getText().toString();
        int timerInputDuration = 0;

        try {

            timerInputDuration = Integer.parseInt(timerInputString);
            timerDirectionsMessage.setText("Timer Duration (min)");
            timerDirectionsMessage.setTextColor(Color.parseColor("#7AACAC"));


        } catch(NumberFormatException e) {

            timerDirectionsMessage.setText("Invalid Input. Try Again.");
            timerDirectionsMessage.setTextColor(Color.RED);
            return;

        }

        TextView timerIntervalDirections = findViewById(R.id.timerIntervalDirections);
        View timerInputInterval = findViewById(R.id.timerInputInterval);
        String timerInputIntervalString = ((TextView)timerInputInterval).getText().toString();

        try {

            if(intervalsFlag != true) {
                intervals = Integer.parseInt(timerInputIntervalString);
                intervalsFlag = true;
                timerIntervalDirections.setText("Number of Breaks (5 min)");
                timerIntervalDirections.setTextColor(Color.parseColor("#7AACAC"));
            }


        } catch(NumberFormatException e) {

            timerIntervalDirections.setText("Invalid Input. Try Again.");
            timerIntervalDirections.setTextColor(Color.RED);
            return;

        }

        // normal timer duration standard
        long timerDuration = TimeUnit.MINUTES.toMillis(timerInputDuration);
        long timerTickInterval = 10;

        new CountDownTimer(timerDuration, timerTickInterval) {

            @Override
            public void onTick(long timerMillisRemaining) {

                String timerCountdownString =  String.format(Locale.getDefault(), "%02d:%02d:%02d",
                        TimeUnit.MILLISECONDS.toHours(timerMillisRemaining),
                        TimeUnit.MILLISECONDS.toMinutes(timerMillisRemaining) -
                                TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(timerMillisRemaining)),
                        TimeUnit.MILLISECONDS.toSeconds(timerMillisRemaining) -
                                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(timerMillisRemaining))
                );

                timerCountdown.setText(timerCountdownString);

            }

            @Override
            public void onFinish() {

                if(intervals != 0) {

                    intervals--;
                    startBreak(null);

                }
                else {

                    intervalsFlag = false;
                    timerCountdown.setText("Done!");

                }

            }
        }.start();

    }



    public void startBreak(View v) {

        TextView timerMain = findViewById(R.id.timerMain);
        timerMain.setText("BREAK");
        TextView timerCountdown = findViewById(R.id.timerCountdown);

        // normal timer duration standard
        long timerDuration = TimeUnit.MINUTES.toMillis(1);
        long timerTickInterval = 10;

        new CountDownTimer(timerDuration, timerTickInterval) {

            @Override
            public void onTick(long timerMillisRemaining) {

                String timerCountdownString =  String.format(Locale.getDefault(), "%02d:%02d:%02d",
                        TimeUnit.MILLISECONDS.toHours(timerMillisRemaining),
                        TimeUnit.MILLISECONDS.toMinutes(timerMillisRemaining) -
                                TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(timerMillisRemaining)),
                        TimeUnit.MILLISECONDS.toSeconds(timerMillisRemaining) -
                                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(timerMillisRemaining))
                );

                timerCountdown.setText(timerCountdownString);

            }

            @Override
            public void onFinish() {

                timerMain.setText("TIMER");
                updateTimer(null);

            }
        }.start();

    }

    public void exitTimer(View v) {

        finish();

    }

}