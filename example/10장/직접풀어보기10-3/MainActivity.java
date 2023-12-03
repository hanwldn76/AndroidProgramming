package com.example.p;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edtNum1, edtNum2;
    RadioGroup rdoGroup;
    Button btnNewActivity;
    RadioButton add, sub, mul, div;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("메인 액티비티");

        ActivityResultLauncher<Intent> startActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == 0) {
                            int res = result.getData().getIntExtra("result", 0);
                            Toast.makeText(getApplicationContext(), "결과 :" + res, Toast.LENGTH_SHORT).show();
                        }
                    }
                });

        edtNum1 = (EditText) findViewById(R.id.edtNum1);
        edtNum2 = (EditText) findViewById(R.id.edtNum2);
        rdoGroup = (RadioGroup) findViewById(R.id.rdoGroup1);
        btnNewActivity = (Button) findViewById(R.id.btnNewActivity);

        btnNewActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                switch (rdoGroup.getCheckedRadioButtonId()) {
                    case R.id.add:
                        intent.putExtra("Calc", "+");
                        break;
                    case R.id.sub:
                        intent.putExtra("Calc", "-");
                        break;
                    case R.id.mul:
                        intent.putExtra("Calc", "*");
                        break;
                    case R.id.div:
                        intent.putExtra("Calc", "/");
                        break;
                    default:
                        break;
                }

                intent.putExtra("Num1", Integer.parseInt(edtNum1.getText().toString()));
                intent.putExtra("Num2", Integer.parseInt(edtNum1.getText().toString()));
                startActivityResult.launch(intent);
            }
        });
    }
}