package com.example.exercise;

import android.content.Context; //추가됨
import android.os.Bundle;
import android.view.LayoutInflater; //추가됨
import android.view.View; //추가됨
import android.widget.*; //추가됨

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    LinearLayout container; //추가됨

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.activity_main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);

            container=(LinearLayout)findViewById(R.id.container); // 여기부터

            Button button = (Button) findViewById(R.id.button);
            button.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    inflater.inflate(R.layout.sub1, container, true);

                    CheckBox checkBox = (CheckBox) container.findViewById(R.id.checkBox);
                    checkBox.setText("로딩되었어요.");
                }
            }); //여기까지 추가됨

            return insets;
        });
    }
}