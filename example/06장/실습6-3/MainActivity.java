package com.cookandroid.project6_3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar); // 액티비트의 앱바로 지정
    }

    // 메뉴 리소스 XML의 내용을 앱바에 적용
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_toolbar, menu);
        return true;
    }

    // 메뉴가 선택되면 onOptionsItemSelected() 메서드 호출됨
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu1:
                Intent NewActivity = new Intent(getApplicationContext(), SecondActivity.class);
                startActivity(NewActivity);
                break;
            case R.id.menu2:
                Intent NewActivity2 = new Intent(getApplicationContext(), SecondActivity.class);
                startActivity(NewActivity2);
                break;
        }
        return true;
    }
}