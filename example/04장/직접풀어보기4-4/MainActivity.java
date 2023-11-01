package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Switch switch1;
    RadioGroup rGroup1;
    RadioButton [] radioArray = new RadioButton[3];
    Button btnQuit, btnReturn;
    ImageView imgAndroid;
    TextView text1, text2;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("안드로이드 사진보기");

        switch1 = (Switch) findViewById(R.id.switch1);
        rGroup1 = (RadioGroup) findViewById(R.id.rGroup1);
        radioArray[0] = (RadioButton) findViewById(R.id.rbtn11);
        radioArray[1] = (RadioButton) findViewById(R.id.rbtn12);
        radioArray[2] = (RadioButton) findViewById(R.id.rbtn13);
        btnQuit = (Button) findViewById(R.id.btnQuit);
        btnReturn = (Button) findViewById(R.id.btnReturn);
        imgAndroid = (ImageView) findViewById(R.id.imgAndroid);
        text1 = (TextView) findViewById(R.id.text1);
        text2 = (TextView) findViewById(R.id.text2);


        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(switch1.isChecked() == true){
                    text2.setVisibility(View.VISIBLE);
                    rGroup1.setVisibility(View.VISIBLE);
                    imgAndroid.setVisibility(View.VISIBLE);
                    btnQuit.setVisibility(View.VISIBLE);
                    btnReturn.setVisibility(View.VISIBLE);
                } else{
                    text2.setVisibility(View.INVISIBLE);
                    rGroup1.setVisibility(View.INVISIBLE);
                    imgAndroid.setVisibility(View.INVISIBLE);
                    btnQuit.setVisibility(View.INVISIBLE);
                    btnReturn.setVisibility(View.INVISIBLE);
                }
            }
        });

        final int draw[] = {R.drawable.r11, R.drawable.s12, R.drawable.t13};

        for(int i = 0; i<radioArray.length; i++){
            final int index;
            index = i;
            radioArray[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    imgAndroid.setImageResource(draw[index]);
                }
            });
        }

        btnQuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text2.setVisibility(View.INVISIBLE);
                rGroup1.setVisibility(View.INVISIBLE);
                imgAndroid.setVisibility(View.INVISIBLE);
                btnQuit.setVisibility(View.INVISIBLE);
                btnReturn.setVisibility(View.INVISIBLE);

                rGroup1.clearCheck();
                switch1.setChecked(false);
            }
        });

    }
}