package com.example.shahalam.bigmodcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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



        Calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String baseString = baseInput.getText().toString();
                final int base = Integer.parseInt(baseString);

                String powerString = powerInput.getText().toString();
                final int power = Integer.parseInt(powerString);

                String modularString = modularInput.getText().toString();
                final int modular = Integer.parseInt(modularString);

                int result;
                result = bigMod(base, power, modular);
                displayResult.setText("Result = "+result);
            }
        });
    }
    int bigMod(int base, int power, int modular)
    {
        if(power==0) return 1;
        else if(power%2==0)
        {
            int temp = bigMod(base, power/2, modular);
            return ((temp%modular)*(temp%modular))%modular;
        }
        else
            return ((base%modular)*bigMod(base, power-1, modular))%modular;
    }
}
