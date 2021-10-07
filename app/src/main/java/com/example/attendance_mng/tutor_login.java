package com.example.attendance_mng;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class tutor_login extends AppCompatActivity {

    private Button tutor_login_btn2;
    private Button tutor_login_btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide(); // Hide the Action Bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN); // Hide the Status Bar
        setContentView(R.layout.activity_tutor_login);

        tutor_login_btn3 = findViewById(R.id.tutor_login_btn3);
        tutor_login_btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tutor_login.this, tutor_signup.class);
                startActivity(intent);
            }
        });


        tutor_login_btn2 = findViewById(R.id.tutor_login_btn2);
        tutor_login_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(tutor_login.this, login.class);
                startActivity(intent);
            }
        });
    }
}