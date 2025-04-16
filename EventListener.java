package com.example.exercise;

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

import java.util.Date; //추가됨

public class MainActivity extends AppCompatActivity {
    Button button; //여기

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.activity_main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);

            button = findViewById(R.id.myButton); //여기부터
            button.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    updateTime();
                }
            });//여기까지
            return insets;
        });
    }
    //아래 함수도 추가됨
    void updateTime(){
        button.setText(new Date().toString());
    }
}