package com.example.p;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class SecondActivity extends AppCompatActivity {
    Button btnReturn;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        setTitle("Scecond 액티비티");

        Intent inIntent = getIntent();
        String calc = (inIntent.getStringExtra("Calc"));

        int calValue = 0;
        if(calc.equals("+")){
            calValue = inIntent.getIntExtra("Num1", 0) + inIntent.getIntExtra("Num2", 0);
        }else if(calc.equals("-")){
            calValue = inIntent.getIntExtra("Num1", 0) - inIntent.getIntExtra("Num2", 0);
        }else if(calc.equals("*")){
            calValue = inIntent.getIntExtra("Num1", 0) * inIntent.getIntExtra("Num2", 0);
        }else {
            calValue = inIntent.getIntExtra("Num1", 0) / inIntent.getIntExtra("Num2", 0);
        }

        final int retValue = calValue;

        btnReturn = (Button) findViewById(R.id.btnReturn);

        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent outIntent = new Intent(getApplicationContext(), MainActivity.class);
                outIntent.putExtra("result", retValue);
                setResult(0, outIntent);
                finish();
            }
        });
    }
}