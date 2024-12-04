package com.example.timeflow;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class CalendarEdit extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar_edit);

    }

    // Saves user input as event
    public void calendarSave(View v) {

        // Initializing all input fields, output fields, and variables
        EditText calendarInput = findViewById(R.id.calendarEditInOut);
        String calendarString = calendarInput.getText().toString();
        EditText calendarName = findViewById(R.id.calendarEditFileName);
        String fileName = "caledit" + calendarName.getText() + ".txt";
        File filePath = getApplicationContext().getFilesDir();

        // Throws error message if file name is empty, else saves user input file name and description
        try {

            if(fileName.replaceAll("sumedit", "").replaceAll(".txt", "").isEmpty()) {

                throw new Exception();

            }

            FileOutputStream calendarWriteToFile = new FileOutputStream(new File(filePath, fileName));
            calendarWriteToFile.write(calendarString.getBytes());
            calendarWriteToFile.close();
            calendarName.setText("");
            calendarName.setHint("Event saved.");
            calendarName.setHintTextColor(Color.parseColor("#7AACAC"));

        }catch (Exception e) {

            calendarName.setHint("Error occured during event saving.");
            calendarName.setHintTextColor(Color.RED);
            return;

        }

    }

    // Displays contents of specified file
    public void calendarRead(View v) {

        // Initializing all input fields, output fields, and variables
        EditText calendarOutput = findViewById(R.id.calendarEditInOut);
        EditText calendarName = findViewById(R.id.calendarEditFileName);
        String fileName = "caledit" + calendarName.getText() + ".txt";
        File filePath = getApplicationContext().getFilesDir();
        File calendarFile = new File(filePath, fileName);
        byte[] calendarByteArray = new byte[(int) calendarFile.length()];

        // Throws error message if file does not exist or empty string input
        try {

            if(fileName.replaceAll("sumedit", "").replaceAll(".txt", "").isEmpty()) {

                throw new Exception();

            }

            FileInputStream calendarReadFile = new FileInputStream(calendarFile);
            calendarReadFile.read(calendarByteArray);
            String calendarByteArrayToString = new String(calendarByteArray);
            calendarOutput.setText(calendarByteArrayToString);
            calendarName.setHint("Enter event name");
            calendarName.setHintTextColor(Color.parseColor("#7AACAC"));

        } catch (Exception e) {

            calendarName.setHint("Event does not exist.");
            calendarName.setHintTextColor(Color.RED);
            return;

        }

    }

    // Deletes specified file
    public void calendarDelete(View v) {

        // Initializing all input fields, output fields, and variables
        EditText calendarName = findViewById(R.id.calendarEditFileName);
        String fileName = "caledit" + calendarName.getText() + ".txt";
        File filePath = getApplicationContext().getFilesDir();
        File calendarFile = new File(filePath, fileName);

        // Throws error message if specified file does not exist
        try {

            if(calendarFile.exists()) {

                calendarFile.delete();
                calendarName.setText("");
                calendarName.setHint("Event successfully deleted.");
                calendarName.setHintTextColor(Color.parseColor("#7AACAC"));

            }
            else
                throw new Exception();

        } catch(Exception e) {

            calendarName.setHint("Event does not exist.");
            calendarName.setHintTextColor(Color.RED);

        }

    }

    // Returns to calendar screen
    public void exitCalendarEdit(View v) {

        finish();

    }

}