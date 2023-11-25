package com.example.project9_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        setContentView(new MyGraphicView(this));
    }

    private static class MyGraphicView extends View {
        public MyGraphicView(Context context){
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);

            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setColor(Color.GREEN);
            canvas.drawLine(20,20,600,20,paint);

            paint.setColor(Color.BLUE);
            paint.setStrokeWidth(10);
            canvas.drawLine(20,60, 600,60,paint);

            paint.setColor(Color.RED);
            paint.setStrokeWidth(0);

            paint.setStyle(Paint.Style.FILL);
            Rect rect1 = new Rect(20,100,20+200,100+200);
            canvas.drawRect(rect1, paint);

            paint.setStyle(Paint.Style.STROKE);
            Rect rect2 = new Rect(260,100,260+200,100+200);
            canvas.drawRect(rect2,paint);

            RectF rect3 = new RectF(500,100,500+200,100+200);
            canvas.drawRoundRect(rect3, 40,40,paint);
            canvas.drawCircle(120,440,100,paint);

            paint.setStyle(Paint.Style.FILL);
            rect3.set(260,120,260+200,580);
            canvas.drawArc(rect3, 0,50,true,paint);

            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(10);
            Path path1 = new Path();
            int x = 20, y = 580;
            path1.moveTo(x,y);
            path1.lineTo(x+100,y+100);
            path1.lineTo(x+200,y);
            path1.lineTo(x+300,y+100);
            path1.lineTo(x+400,y);
            canvas.drawPath(path1, paint);

            paint.setStyle(Paint.Style.FILL);
            paint.setStrokeWidth(0);
            paint.setTextSize(60);
            canvas.drawText("안드로이드",x,y+200,paint);
        }
    }
}