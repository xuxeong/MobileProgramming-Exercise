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

            Button button1 = findViewById(R.id.button1);

            button1.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    Intent intent = new Intent(getApplicationContext(), NewActivity.class);

                    Bundle myBundle1 = new Bundle(); //여기부터
                    myBundle1.putInt("val1", 123);
                    intent.putExtras(myBundle1);

                    startActivityForResult(intent, 1); //여기까지
                }
            });

            return insets;
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        Bundle myBundle = data.getExtras(); //여기부터
        int val1 = myBundle.getInt("val1");
        Toast.makeText(this, "전달받은 value 값:"+val1, Toast.LENGTH_LONG).show(); //여기까지
    }

}