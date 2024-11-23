/*
* Time Flow version 1.0
*
*
*
* */

package com.example.timeflow;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void launchTimer(View v) {

        // launches a new activity
        Intent i = new Intent(this, Timer.class);
        startActivity(i);

    }

    public void launchCalendar(View v) {

        // launches a new activity
        Intent i = new Intent(this, Calendar.class);
        startActivity(i);

    }

    public void launchSummary(View v) {

        // launches a new activity
        Intent i = new Intent(this, Summary.class);
        startActivity(i);

    }


//    public void handleText(View v) {
//
//        TextView t = findViewById(R.id.source);
//        String input = t.getText().toString();
//
//        TextView tO = findViewById(R.id.sourceOutput);
//        tO.setText(input);
//
//        ((TextView)findViewById(R.id.sourceOutput)).setText(input);
//
//    }


    /*
    public void disable(View v) {

        View myView = findViewById(R.id.button4);
        myView.setEnabled(false);
        Button button = (Button) myView;
        button.setText("disabled");

        v.setEnabled(false);
        Button button = (Button) v;
        button.setText("disabled");

    }
    */

}
