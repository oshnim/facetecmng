package com.example.attendance_mng;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class stu_science extends AppCompatActivity {

    private Button stu_science_btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide(); // Hide the Action Bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN); // Hide the Status Bar
        setContentView(R.layout.activity_stu_science);

        stu_science_btn2 = findViewById(R.id.stu_science_btn2);
        stu_science_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(stu_science.this, stu_dashboard.class);
                startActivity(intent);
            }
        });
    }
}