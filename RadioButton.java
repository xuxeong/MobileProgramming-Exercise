package com.example.exercise;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;//추가됨
import android.widget.RadioGroup;//추가됨
import android.widget.TextView;
import android.widget.Toast;
import android.widget.EditText;
import android.content.Context;
import android.widget.CheckBox;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    CheckBox chkCream;
    CheckBox chkSugar;
    Button btnPay;
    RadioGroup radCoffeeType; //여기부터
    RadioButton radDecaf;
    RadioButton radEspresso;
    RadioButton radColombian; //여기까지
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

        chkCream=findViewById(R.id.chkCream);
        chkSugar=findViewById(R.id.chkSugar);
        btnPay=findViewById(R.id.btnPay);

        radCoffeeType=findViewById(R.id.radGroupCoffeType); //여기부터
        radDecaf=findViewById(R.id.radDecaf);
        radEspresso=findViewById(R.id.radExpresso);
        radColombian=findViewById(R.id.radColombian); //여기까지

        btnPay.setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick(View v){
               String msg = "Coffee";
               if(chkCream.isChecked()){
                   msg+=" & cream ";
               }
               if(chkSugar.isChecked()){
                   msg+=" & Sugar";
               }
               int radioId = radCoffeeType.getCheckedRadioButtonId();
               if(radDecaf.getId()==radioId)
                   msg="Decaf "+msg;
               if(radColombian.getId()==radioId)
                   msg="Colombian "+msg;
               if(radEspresso.getId()==radioId)
                   msg="Espresso "+msg;
               Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
           }
        });

    }
}