package com.example.timeflow;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.util.ArrayList;

public class Summary extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        ListView summaryListView = findViewById(R.id.summaryListView);
        File filePath = new File("/data/user/0/com.example.timeflow/files");
        ArrayList<String> summaryFiles = new ArrayList<>();
        fetchFiles(summaryFiles, filePath);
        ArrayAdapter<String> summaryStringArrayToListView = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, summaryFiles);
        summaryListView.setAdapter(summaryStringArrayToListView);

    }

    public void fetchFiles(ArrayList<String> summaryFiles, File filePath) {

        File[] filesArray = filePath.listFiles();
        assert filesArray != null;
        for(File f : filesArray) {

            if(f.isFile() && f.getPath().endsWith(".txt") && f.getName().startsWith("sumedit")) {  //  && f.getPath().startsWith("sumedit")

                summaryFiles.add(f.getName().replaceAll(".txt", "").replaceAll("sumedit", ""));

            }

        }

    }

    public void launchSummaryEdit(View v) {

        // launches a new activity
        Intent i = new Intent(this, SummaryEdit.class);
        startActivity(i);

    }

    public void exitSummary(View v) {

        finish();

    }

}