package com.example.exercise;

import android.content.Intent;
import android.os.Bundle;
import android.widget.*; 
import android.view.View; 

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class NewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_new);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.activity_new), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            
            Button button = findViewById(R.id.button2);
            button.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){

                    Intent myCallerIntent = getIntent(); //여기부터
                    Bundle myBundle = myCallerIntent.getExtras();
                    int val1 = myBundle.getInt("val1");

                    myBundle.putInt("val1", 456);
                    myCallerIntent.putExtras(myBundle);
                    setResult(NewActivity.RESULT_OK, myCallerIntent); //여기까지

                    Toast.makeText(getApplicationContext(), "돌아가기버튼이 눌렸어요", Toast.LENGTH_LONG).show();
                    finish();
                }
            });
            
            return insets;
        });
    }
}