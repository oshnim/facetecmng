package com.example.attendance_mng;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class login_cp extends AppCompatActivity {


    private Button cp_login_btn1;
    private Button cp_login_btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide(); // Hide the Action Bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN); // Hide the Status Bar
        setContentView(R.layout.activity_login_cp);

       cp_login_btn2 = findViewById(R.id.cp_login_btn2);
       cp_login_btn2.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               Intent intent = new Intent(login_cp.this,login.class);
               startActivity(intent);
           }
       });


        cp_login_btn1 = findViewById(R.id.cp_login_btn1);
        cp_login_btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(login_cp.this, tutor_login.class);
                startActivity(intent);


            }
        });


    }
}