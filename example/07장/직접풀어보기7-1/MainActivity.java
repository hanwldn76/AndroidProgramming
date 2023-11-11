package com.example.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.project.R;

public class MainActivity extends AppCompatActivity {

    EditText edtAngle;
    ImageView imgV1, imgV2, imgV3;
    float degree = 0;
    float scale = 1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("제주도 풍경");

        edtAngle = (EditText) findViewById(R.id.edtAngle);
        imgV1 = (ImageView) findViewById(R.id.img1);
        imgV2 = (ImageView) findViewById(R.id.img2);
        imgV3 = (ImageView) findViewById(R.id.img3);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater mInflater = getMenuInflater();
        mInflater.inflate(R.menu.menu1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.itemRotate:
                imgV1.setRotation(Float.parseFloat((edtAngle.getText().toString())));
                return true;
            case R.id.item1:
                imgV1.setImageResource(R.drawable.jeju14);
                return true;
            case R.id.item2:
                imgV1.setImageResource(R.drawable.jeju1);
                return true;
            case R.id.item3:
                imgV1.setImageResource(R.drawable.jeju6);
                return true;
        }
        return true;
    }
}
