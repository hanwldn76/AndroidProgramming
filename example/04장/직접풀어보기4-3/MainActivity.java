package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnAdd, btnSub, btnMul, btnDiv, btnRest;
    EditText edit1, edit2;
    TextView text1;
    String num1, num2;
    Double result;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("초간단 계산기");

        edit1 = (EditText) findViewById(R.id.edit1);
        edit2 = (EditText) findViewById(R.id.edit2);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnSub = (Button) findViewById(R.id.btnSub);
        btnMul = (Button) findViewById(R.id.btnMul);
        btnDiv = (Button) findViewById(R.id.btnDiv);
        btnRest = (Button) findViewById(R.id.btnRest);
        text1 = (TextView) findViewById(R.id.text1);
        text1.setTextColor(Color.RED);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                if(num1.trim().equals("")||num2.trim().equals("")){
                    Toast.makeText(getApplicationContext(), "입력 값이 비었습니다.", Toast.LENGTH_SHORT).show();
                } else{
                    result = Double.parseDouble(num1) + Double.parseDouble(num2);
                    text1.setText("계산 결과 : "+result.toString());
                }
            }
        });

        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                if(num1.trim().equals("")||num2.trim().equals("")){
                    Toast.makeText(getApplicationContext(), "입력 값이 비었습니다.", Toast.LENGTH_SHORT).show();
                } else{
                    result = Double.parseDouble(num1) - Double.parseDouble(num2);
                    text1.setText("계산 결과 : "+result.toString());
                }
            }
        });

        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                if(num1.trim().equals("")||num2.trim().equals("")){
                    Toast.makeText(getApplicationContext(), "입력 값이 비었습니다.", Toast.LENGTH_SHORT).show();
                } else{
                    result = Double.parseDouble(num1) * Double.parseDouble(num2);
                    text1.setText("계산 결과 : "+result.toString());
                }
            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                if(num1.trim().equals("")||num2.trim().equals("")){
                    Toast.makeText(getApplicationContext(), "입력 값이 비었습니다.", Toast.LENGTH_SHORT).show();
                } else if(num2.trim().equals("0")){
                    Toast.makeText(getApplicationContext(), "0으로 나누면 안됩니다!.", Toast.LENGTH_SHORT).show();
                } else{
                    result = Double.parseDouble(num1) / Double.parseDouble(num2);
                    result = (int) (result / 10) * 10.0;
                    text1.setText("계산 결과 : "+result.toString());
                }
            }
        });

        btnRest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                if(num1.trim().equals("")||num2.trim().equals("")){
                    Toast.makeText(getApplicationContext(), "입력 값이 비었습니다.", Toast.LENGTH_SHORT).show();
                } else if(num2.trim().equals("0")){
                    Toast.makeText(getApplicationContext(), "0으로 나머지 값 안됩니다!.", Toast.LENGTH_SHORT).show();
                } else{
                    result = Double.parseDouble(num1) % Double.parseDouble(num2);
                    text1.setText("계산 결과 : "+result.toString());
                }
            }
        });
    }
}