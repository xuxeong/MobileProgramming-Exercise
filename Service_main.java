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

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.activity_main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);

            Button btnStart = findViewById(R.id.btnStartService); //여기부터
            btnStart.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    startService(new Intent(getApplicationContext(), MyService.class));
                }
            });

            Button btnStop = findViewById(R.id.btnStopService);
            btnStop.setOnClickListener(new View.OnClickListener(){
               @Override
               public void onClick(View v){
                   stopService(new Intent(getApplicationContext(), MyService.class));
               }
            }); //여기까지

            return insets;
        });
    }
}