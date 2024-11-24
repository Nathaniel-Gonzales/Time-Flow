package com.example.timeflow;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class SummaryEdit extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary_edit);

    }

    public void summarySave(View v) {

        EditText summaryInput = findViewById(R.id.summaryEditInOut);
        String summaryString = summaryInput.getText().toString();
        EditText summaryName = findViewById(R.id.summaryEditFileName);
        String fileName = "sumedit" + summaryName.getText() + ".txt";
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

        EditText summaryOutput = findViewById(R.id.summaryEditInOut);
        EditText summaryName = findViewById(R.id.summaryEditFileName);
        String fileName = "sumedit" + summaryName.getText() + ".txt";
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

    public void summaryDelete(View v) {

        EditText summaryName = findViewById(R.id.summaryEditFileName);
        String fileName = "sumedit" + summaryName.getText() + ".txt";
        File filePath = getApplicationContext().getFilesDir();
        File summaryFile = new File(filePath, fileName);

        try {

            if(summaryFile.exists()) {

                summaryFile.delete();
                summaryName.setText("");
                summaryName.setHint("File successfully deleted.");
                summaryName.setHintTextColor(Color.parseColor("#7AACAC"));

            }
            else
                throw new Exception();

        } catch(Exception e) {

            summaryName.setHint("File does not exist.");
            summaryName.setHintTextColor(Color.RED);

        }

    }

    public void exitSummaryEdit(View v) {

        finish();

    }

}