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

    public void calendarSave(View v) {

        EditText calendarInput = findViewById(R.id.calendarEditInOut);
        String calendarString = calendarInput.getText().toString();
        EditText calendarName = findViewById(R.id.calendarEditFileName);
        String fileName = "caledit" + calendarName.getText() + ".txt";
        File filePath = getApplicationContext().getFilesDir();
        try {

            FileOutputStream calendarWriteToFile = new FileOutputStream(new File(filePath, fileName));
            calendarWriteToFile.write(calendarString.getBytes());
            calendarWriteToFile.close();

        }catch (Exception e) {

            return;

        }

    }

    public void calendarRead(View v) {

        EditText calendarOutput = findViewById(R.id.calendarEditInOut);
        EditText calendarName = findViewById(R.id.calendarEditFileName);
        String fileName = "caledit" + calendarName.getText() + ".txt";
        File filePath = getApplicationContext().getFilesDir();
        File calendarFile = new File(filePath, fileName);
        byte[] calendarByteArray = new byte[(int) calendarFile.length()];
        try {

            FileInputStream calendarReadFile = new FileInputStream(calendarFile);
            calendarReadFile.read(calendarByteArray);
            String calendarByteArrayToString = new String(calendarByteArray);
            calendarOutput.setText(calendarByteArrayToString);

        } catch (Exception e) {

            return;

        }

    }

    public void calendarDelete(View v) {

        EditText calendarName = findViewById(R.id.calendarEditFileName);
        String fileName = "caledit" + calendarName.getText() + ".txt";
        File filePath = getApplicationContext().getFilesDir();
        File calendarFile = new File(filePath, fileName);

        try {

            if(calendarFile.exists()) {

                calendarFile.delete();
                calendarName.setText("");
                calendarName.setHint("File successfully deleted.");
                calendarName.setHintTextColor(Color.parseColor("#7AACAC"));

            }
            else
                throw new Exception();

        } catch(Exception e) {

            calendarName.setHint("File does not exist.");
            calendarName.setHintTextColor(Color.RED);

        }

    }

    public void exitCalendarEdit(View v) {

        finish();

    }

}