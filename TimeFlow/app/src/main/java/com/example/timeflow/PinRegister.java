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

        // Registers user's name
        TextView pinRegisterNameDirections = findViewById(R.id.pinRegisterNameDirections);
        EditText pinRegisterName = findViewById(R.id.pinRegisterName);
        String pinRegisterNameString = pinRegisterName.getText().toString();
        String fileName = "timeflowName.txt";
        File filePath = getApplicationContext().getFilesDir();

        // Throws error message if user input is empty, else saves user's name to file
        try {

            if(pinRegisterNameString.isEmpty()) {

                throw new Exception();

            }

            FileOutputStream pinRegisterNameWriteToFile = new FileOutputStream(new File(filePath, fileName));
            pinRegisterNameWriteToFile.write(pinRegisterNameString.getBytes());
            pinRegisterNameWriteToFile.close();
            pinRegisterNameDirections.setText("Name Saved!");
            pinRegisterNameDirections.setTextColor(Color.parseColor("#7AACAC"));

        }catch (Exception e) {

            pinRegisterNameDirections.setText("Invalid Input.");
            pinRegisterNameDirections.setTextColor(Color.RED);
            return;

        }

        // Registers user's new pin
        TextView pinRegisterPinDirections = findViewById(R.id.pinRegisterPinDirections);
        EditText pinRegisterPin = findViewById(R.id.pinRegisterPin);
        String pinRegisterPinString = pinRegisterPin.getText().toString();
        String filePin = "timeflowPin.txt";
        File pinFile = new File(filePath, filePin);
        byte[] pinByteArray = new byte[(int) pinRegisterPinString.length()];

        // Throws error message if user input is empty, else saves user pin
        try {

            if(pinRegisterPinString.isEmpty()) {

                throw new Exception();

            }

            FileOutputStream pinRegisterPinWriteToFile = new FileOutputStream(pinFile);
            pinRegisterPinWriteToFile.write(pinRegisterPinString.getBytes());
            pinRegisterPinWriteToFile.close();
            pinRegisterPinDirections.setText("Pin Saved!");
            pinRegisterPinDirections.setTextColor(Color.parseColor("#7AACAC"));

        } catch(Exception e) {

            pinRegisterPinDirections.setText("Invalid Input");
            pinRegisterPinDirections.setTextColor(Color.RED);
            return;

        }

    }

    // Returns to pin entry screen
    public void exitPinRegister(View v) {

        finish();

    }

}