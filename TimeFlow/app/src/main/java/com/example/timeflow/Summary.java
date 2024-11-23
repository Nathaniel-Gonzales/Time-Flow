package com.example.timeflow;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Summary extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

    }

    public void summarySave(View v) {

        EditText summaryInput = findViewById(R.id.summaryInput);
        String summaryString = summaryInput.getText().toString();
        String fileName = "example.txt";
        File filePath = getApplicationContext().getFilesDir();
        try {

            FileOutputStream summaryWriteToFile = new FileOutputStream(new File(filePath, fileName));
            summaryWriteToFile.write(summaryString.getBytes());
            summaryWriteToFile.close();

        }catch (Exception e) {

            return;

        }

    }

    public void summaryRead(View v) {

        TextView summaryOutput = findViewById(R.id.summaryOutput);
        String fileName = "example.txt";
        File filePath = getApplicationContext().getFilesDir();
        File summaryFile = new File(filePath, fileName);
        byte[] summaryByteArray = new byte[(int) summaryFile.length()];
        try {

            FileInputStream summaryReadFile = new FileInputStream(summaryFile);
            summaryReadFile.read(summaryByteArray);
            String summaryByteArrayToString = new String(summaryByteArray);
            summaryOutput.setText(summaryByteArrayToString);

        } catch (Exception e) {

            return;

        }

    }

    public void exitSummary(View v) {

        finish();

    }

}