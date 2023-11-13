package com.example.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.example.project.R;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

	setTitle("직접풀어보기 6-3");

        TabHost tabHost = findViewById(R.id.TabHost);
        tabHost.setup();

        TabHost.TabSpec tabSpecDog = tabHost.newTabSpec("DOG").setIndicator("강아지");
        tabSpecDog.setContent(R.id.dog); // 탭스펙을 탭과 연결
        tabHost.addTab(tabSpecDog); // 탭을 호스트에 부착

        TabHost.TabSpec tabSpecCat = tabHost.newTabSpec("CAT").setIndicator("고양이");
        tabSpecCat.setContent(R.id.cat); // 탭스펙을 탭과 연결
        tabHost.addTab(tabSpecCat); // 탭을 호스트에 부착


        TabHost.TabSpec tabSpecRabbit = tabHost.newTabSpec("RABBIT").setIndicator("토끼");
        tabSpecRabbit.setContent(R.id.rabbit); // 탭스펙을 탭과 연결
        tabHost.addTab(tabSpecRabbit); // 탭을 호스트에 부착

        TabHost.TabSpec tabSpecHorse = tabHost.newTabSpec("HORSE").setIndicator("말");
        tabSpecHorse.setContent(R.id.horse); // 탭스펙을 탭과 연결
        tabHost.addTab(tabSpecHorse); // 탭을 호스트에 부착

        tabHost.setCurrentTab(0);
    }
}