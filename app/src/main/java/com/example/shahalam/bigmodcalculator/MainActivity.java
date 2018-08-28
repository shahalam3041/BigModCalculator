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
    TextView baseTV, powerTV, modularTV, resultTV;
    Button Calculate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        baseInput = findViewById(R.id.baseET);
        powerInput = findViewById(R.id.powerET);
        modularInput = findViewById(R.id.modularET);
        Calculate = findViewById(R.id.ButtonID);
        baseTV = findViewById(R.id.baseTV);
        powerTV = findViewById(R.id.powerTV);
        modularTV = findViewById(R.id.modularTV);
        resultTV = findViewById(R.id.resultTV);




        Calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String baseString = baseInput.getText().toString();
                base = Integer.parseInt(baseString);

                String powerString = powerInput.getText().toString();
                power = Integer.parseInt(powerString);

                String modularString = modularInput.getText().toString();
                modular = Integer.parseInt(modularString);

                int result;
                result = bigMod(base, power, modular);
                baseTV.setText(""+base);
                modularTV.setText(""+modular);
                powerTV.setText(""+power);
                resultTV.setText(""+result);

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
