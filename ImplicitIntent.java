package com.example.exercise;

import android.content.Context;
import android.content.Intent; //추가됨
import android.net.Uri; //추가됨
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
    LinearLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.activity_main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);

            Button button1 = findViewById(R.id.button1); //여기부터
            Button button2 = findViewById(R.id.button2);

            button1.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://m.naver.com"));
                    startActivity(intent);
                }
            });

            button2.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:01010001000"));
                    startActivity(intent);
                }
            });

            return insets;
        });
    }
}