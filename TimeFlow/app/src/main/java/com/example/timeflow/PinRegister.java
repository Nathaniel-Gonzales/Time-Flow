package com.example.timeflow;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileOutputStream;

public class PinRegister extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pin_register);

    }

    public void registerUser(View v) {

        // timeflowPin.txt
        TextView pinRegisterNameDirections = findViewById(R.id.pinRegisterNameDirections);
        EditText pinRegisterName = findViewById(R.id.pinRegisterName);
        String pinRegisterNameString = pinRegisterName.getText().toString();
        String fileName = "timeflowName.txt";
        File filePath = getApplicationContext().getFilesDir();
        try {

            if(pinRegisterNameString == "") {

                throw new Exception();

            }

            FileOutputStream pinRegisterNameWriteToFile = new FileOutputStream(new File(filePath, fileName));
            pinRegisterNameWriteToFile.write(pinRegisterNameString.getBytes());
            pinRegisterNameWriteToFile.close();
            pinRegisterNameDirections.setTextColor(Color.parseColor("#7AACAC"));

        }catch (Exception e) {

            pinRegisterNameDirections.setText("Invalid Input.");
            pinRegisterNameDirections.setTextColor(Color.RED);
            return;

        }

        TextView pinRegisterPinDirections = findViewById(R.id.pinRegisterPinDirections);
        EditText pinRegisterPin = findViewById(R.id.pinRegisterPin);
        String pinRegisterPinString = pinRegisterPin.getText().toString();
        String filePin = "timeflowPin.txt";
        File pinFile = new File(filePath, filePin);
        byte[] pinByteArray = new byte[(int) pinRegisterPinString.length()];

        try {

            FileOutputStream pinRegisterPinWriteToFile = new FileOutputStream(pinFile);
            pinRegisterPinWriteToFile.write(pinRegisterPinString.getBytes());
            pinRegisterPinWriteToFile.close();
            pinRegisterPinDirections.setTextColor(Color.parseColor("#7AACAC"));

        } catch(Exception e) {

            pinRegisterPinDirections.setText("Invalid Input");
            pinRegisterPinDirections.setTextColor(Color.RED);
            return;

        }

    }

    public void exitPinRegister(View v) {

        finish();

    }

}