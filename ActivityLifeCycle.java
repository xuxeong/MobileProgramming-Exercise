package com.example.exercise;

import android.util.Log; //추가됨
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
    String tag = "LifeCycle"; // 추가됨

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        Log.d(tag, "In the onCreate() event"); //추가됨

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.activity_main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);

            Button button1 = findViewById(R.id.button1);

            button1.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    Intent intent = new Intent(getApplicationContext(), NewActivity.class);
                    startActivityForResult(intent,1);
                }
            });

            return insets;
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        String outName = data.getStringExtra("name");
        Toast.makeText(this, "전달받은 name 값:"+outName, Toast.LENGTH_LONG).show();
    }
    //이 아래 함수들이 추가됨
    public void onStart(){
        super.onStart();
        Log.d(tag, "In the onStart() event");
    }
    public void onRestart(){
        super.onRestart();
        Log.d(tag, "In the onRestart() event");
    }
    public void onResume(){
        super.onResume();
        Log.d(tag, "In the onResume() event");
    }
    public void onPause(){
        super.onPause();
        Log.d(tag, "In the onPause() event");
    }
    public void onStop(){
        super.onStop();
        Log.d(tag, "In the onStop() event");
    }
    public void onDestroy(){
        super.onDestroy();
        Log.d(tag, "In the onDestroy() event");
    }
}