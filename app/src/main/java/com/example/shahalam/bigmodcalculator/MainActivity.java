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


        displayResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int result;
                result = bigMod(base, power, modular);
               displayResult.setText(Integer.toString(result)); /// to print the result

            }
        });


    }
    public int bigMod(int x,int n, int M)
    {
       /// x=base;
        ///n=power;
        ///M=modular;
        if(n==0)  return 1;
        else if (n%2==0)        // if power is even
        {
            int y= bigMod(x,n/2,M);
            return (y*y)%M;
        }
        else                // if power is odd
            return (x%M)*bigMod(x,n-1,M);
    }
}
