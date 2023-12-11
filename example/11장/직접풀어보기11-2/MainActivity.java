package com.example.p;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("갤러리 영화 포스터");

        Gallery gallery = (Gallery) findViewById(R.id.gallery1);

        MyGalleryadapter galadapter = new MyGalleryadapter(this);
        gallery.setAdapter(galadapter);
    }

    public class MyGalleryadapter extends BaseAdapter{
        Context context;
        Integer[] posterID = {
                R.drawable.mov01, R.drawable.mov02, R.drawable.mov03, R.drawable.mov04, R.drawable.mov05,
                R.drawable.mov06, R.drawable.mov07, R.drawable.mov08, R.drawable.mov09, R.drawable.mov10,
                R.drawable.mov01, R.drawable.mov02, R.drawable.mov03, R.drawable.mov04, R.drawable.mov05,
                R.drawable.mov06, R.drawable.mov07, R.drawable.mov08, R.drawable.mov09, R.drawable.mov10,
                R.drawable.mov01, R.drawable.mov02, R.drawable.mov03, R.drawable.mov04, R.drawable.mov05,
                R.drawable.mov06, R.drawable.mov07, R.drawable.mov08, R.drawable.mov09, R.drawable.mov10
        };

        String[] posterTitle = {
                "토이스토리4", "호빗3", "제이슨 본", "반지의 제왕 3",
                "정직한 후보", "나쁜 녀석들", "겨울왕국 2", "알라딘",
                "극한직업", "스파이더맨","토이스토리4", "호빗3", "제이슨 본", "반지의 제왕 3",
                "정직한 후보", "나쁜 녀석들", "겨울왕국 2", "알라딘",
                "극한직업", "스파이더맨","토이스토리4", "호빗3", "제이슨 본", "반지의 제왕 3",
                "정직한 후보", "나쁜 녀석들", "겨울왕국 2", "알라딘",
                "극한직업", "스파이더맨"
        };

        public MyGalleryadapter(Context c){
            context = c;
        }

        public int getCount(){
            return posterID.length;
        }

        public Object getItem(int position){
            return null;
        }

        public long getItemId(int position){
            return 0;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView = new ImageView(context);

            imageView.setLayoutParams(new ViewGroup.LayoutParams(200, 300));
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setPadding(5, 5, 5, 5);
            imageView.setImageResource(posterID[position]);

            final int pos = position;

            imageView.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    ImageView ivPoster = (ImageView) findViewById(R.id.ivPoster);
                    ivPoster.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    ivPoster.setImageResource(posterID[pos]);

                    Toast toast = new Toast(getApplicationContext());

                    View toastView = (View) View.inflate(getApplicationContext(), R.layout.toast1, null);
                    TextView toastText1 = (TextView) toastView.findViewById(R.id.toastText1);
                    toastText1.setText(posterTitle[pos]);
                    toast.setView(toastView);
                    toast.show();

                    return false;
                }
            });

            return imageView;
        }

    }
}