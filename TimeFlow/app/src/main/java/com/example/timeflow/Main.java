package com.example.timeflow;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileInputStream;

public class Main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initializing all output fields, and displays user's name
        TextView welcome = findViewById(R.id.mainWelcome);
        String fileName = "timeflowName.txt";
        File filePath = getApplicationContext().getFilesDir();
        File nameFile = new File(filePath, fileName);
        byte[] nameByteArray = new byte[(int) nameFile.length()];

        // Checks that user's name is saved, else shows basic "Welcome!" message
        try {

            FileInputStream nameReadFile = new FileInputStream(nameFile);
            nameReadFile.read(nameByteArray);
            String nameByteArrayToString = new String(nameByteArray);
            welcome.setText("Hello " + nameByteArrayToString + "!");

        } catch (Exception e) {

            return;

        }

    }

    // Changes activity to timer screen
    public void launchTimer(View v) {

        // launches a new activity
        Intent i = new Intent(this, Timer.class);
        startActivity(i);

    }

    // Changes activity to calendar screen
    public void launchCalendar(View v) {

        // launches a new activity
        Intent i = new Intent(this, Calendar.class);
        startActivity(i);

    }

    // Changes activity to summary screen
    public void launchSummary(View v) {

        // launches a new activity
        Intent i = new Intent(this, Summary.class);
        startActivity(i);

    }

}
