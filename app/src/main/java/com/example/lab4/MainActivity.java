package com.example.lab4;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button btn;
    private TextView tv_meal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_meal = findViewById(R.id.tv_meal);
        btn = (Button) findViewById(R.id.btn_choice);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.setClass(MainActivity.this,Main2Activity.class);
                startActivityForResult(i,0);
            }

        });

    }

    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==0){
            if(resultCode==101){
                Bundle b = data.getExtras();
                String str1 = b.getString("drink_level");
                String str2 = b.getString("suger_level");
                String str3 = b.getString("ice_level");

                tv_meal.setText(String.format("飲料: %s\n\n甜度:%s\n\n冰塊:%s\n\n",str1,str2,str3));
            }
        }
    }



}
