package com.example.hello;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.EditText;
import android.content.Context;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    TextView labelUserName;
    EditText txtUserName;
    Button btnBegin;
    private Context context;
    private int duration = Toast.LENGTH_SHORT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.activity_main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        context = getApplicationContext();

        labelUserName = findViewById(R.id.textView1);
        txtUserName=findViewById(R.id.txtUserName);
        btnBegin=findViewById(R.id.button1);

        btnBegin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String userName = txtUserName.getText().toString();
                if(userName.compareTo("Sujeong Choi")==0){
                    labelUserName.setText("OK, Please wait..");
                    Toast.makeText(context, "Hi!, 202334345, "+userName, duration).show();
                }
                else{
                    Toast.makeText(context, userName+ " is not a valid User", duration).show();
                }
            }
        });

    }
}