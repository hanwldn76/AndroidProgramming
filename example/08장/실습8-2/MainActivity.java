package com.example.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.example.project.R;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    Button btnPrev, btnNext;
    myPictureView myPicture;
    int curNum = 0;
    File[] imageFils = new File[0];
    String imageFname;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("간단 이미지 뷰어");
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, MODE_PRIVATE);

        btnPrev = (Button) findViewById(R.id.btnPrev);
        btnNext = (Button) findViewById(R.id.btnNext);
        myPicture = (myPictureView) findViewById(R.id.myPictureView);

        File[] allFiles = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Pictures").listFiles();

        for(int i = 0; i<allFiles.length; i++){
            if(allFiles[i].isFile()){
                imageFils = Arrays.copyOf(imageFils, imageFils.length+1);
                imageFils[imageFils.length-1] = allFiles[i];
            }
        }

        imageFname = imageFils[curNum].toString();
        myPicture.imagePath = imageFname;

        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(curNum<=0){
                    Toast.makeText(getApplicationContext(), "첫번째 그림입니다.", Toast.LENGTH_SHORT).show();
                }else{
                    curNum--;
                    imageFname = imageFils[curNum].toString();
                    myPicture.imagePath = imageFname;
                    myPicture.invalidate();
                }
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(curNum>=imageFils.length-1){
                    Toast.makeText(getApplicationContext(), "마지막 그림입니다.", Toast.LENGTH_SHORT).show();
                }else{
                    curNum++;
                    imageFname = imageFils[curNum].toString();
                    myPicture.imagePath = imageFname;
                    myPicture.invalidate();
                }
            }
        });
    }
}