package com.example.timeflow;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.File;
import java.util.ArrayList;

public class Calendar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        ListView calendarListView = findViewById(R.id.calendarListView);
        File filePath = new File("/data/user/0/com.example.timeflow/files");
        ArrayList<String> calendarFiles = new ArrayList<>();
        fetchFiles(calendarFiles, filePath);
        ArrayAdapter<String> calendarStringArrayToListView = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, calendarFiles);
        calendarListView.setAdapter(calendarStringArrayToListView);

    }

    public void fetchFiles(ArrayList<String> calendarFiles, File filePath) {

        File[] filesArray = filePath.listFiles();
        assert filesArray != null;
        for(File f : filesArray) {

            if(f.isFile() && f.getPath().endsWith(".txt") && f.getName().startsWith("caledit")) {  //  && f.getPath().startsWith("sumedit")

                calendarFiles.add(f.getName().replaceAll(".txt", "").replaceAll("caledit", ""));

            }

        }

    }

    public void launchCalendarEdit(View v) {

        // launches a new activity
        Intent i = new Intent(this, CalendarEdit.class);
        startActivity(i);

    }

    public void exitCalendar(View v) {

        finish();

    }

}