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
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button btn;
    TextView textView;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT
        );

        LinearLayout baseLayout = new LinearLayout(this);
        baseLayout.setOrientation(LinearLayout.VERTICAL);
        baseLayout.setBackgroundColor(Color.rgb(255, 255, 255));
        setContentView(baseLayout, params);

        editText = new EditText(this);
        editText.setHint("여기에 입력하세요");
        editText.setTextColor(Color.BLACK);
        baseLayout.addView(editText);

        btn = new Button(this);
        btn.setText("버튼입니다.");
        btn.setBackgroundColor(Color.YELLOW);
        btn.setTextColor(Color.BLACK);
        baseLayout.addView(btn);

        textView = new TextView(this);
        textView.setText("텍스트뷰입니다.");
        textView.setTextSize(20);
        textView.setTextColor(Color.MAGENTA);
        baseLayout.addView(textView);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(editText.getText().toString());
            }
        });
    }
}
