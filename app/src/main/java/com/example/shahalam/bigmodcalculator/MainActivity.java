package com.example.shahalam.bigmodcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int base, power, modular;
    EditText baseInput, powerInput, modularInput;
    Button Calculate;
    TextView displayResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        baseInput = findViewById(R.id.input_base);
        powerInput = findViewById(R.id.input_power);
        modularInput = findViewById(R.id.input_modular);
        Calculate = findViewById(R.id.ButtonID);
        displayResult = findViewById(R.id.result_TextViewID);
    }
}
