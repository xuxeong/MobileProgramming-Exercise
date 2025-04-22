package com.example.exercise;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.*;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MainActivity.MyView vw = new MainActivity.MyView(this);
        setContentView(vw);
    }
    protected class MyView extends View {
        public MyView(Context context){
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas){
            Paint Pnt = new Paint(Paint.ANTI_ALIAS_FLAG);

            Pnt.setStrokeWidth(8);
            Pnt.setColor(Color.RED);

            //채우기
            Pnt.setStyle(Paint.Style.FILL);
            canvas.drawCircle(50, 50, 40, Pnt);

            //외곽선 그리기
            Pnt.setStyle(Paint.Style.STROKE);
            canvas.drawCircle(150,50,40,Pnt);

            //외곽선 및 채우기
            Pnt.setStyle(Paint.Style.FILL_AND_STROKE);
            canvas.drawCircle(250,50,40,Pnt);

            //파란색으로 채우고 빨간색으로 외곽선 그리기
            Pnt.setColor(Color.BLUE);
            Pnt.setStyle(Paint.Style.FILL);
            canvas.drawCircle(50, 150, 40, Pnt);
            Pnt.setColor(Color.RED);
            Pnt.setStyle(Paint.Style.STROKE);
            canvas.drawCircle(50, 150, 40, Pnt);

            //빨간색으로 외곽선 그리고 파란색으로 채우기
            Pnt.setColor(Color.RED);
            Pnt.setStyle(Paint.Style.STROKE);
            canvas.drawCircle(150, 150, 40, Pnt);
            Pnt.setColor(Color.BLUE);
            Pnt.setStyle(Paint.Style.FILL);
            canvas.drawCircle(150, 150, 40, Pnt);
        }
    }


}