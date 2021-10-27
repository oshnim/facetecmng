package com.example.attendance_mng;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class stu_mathematics extends AppCompatActivity {

    private Button stu_maths_btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide(); // Hide the Action Bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN); // Hide the Status Bar
        setContentView(R.layout.activity_stu_mathematics);

        stu_maths_btn2 = findViewById(R.id.stu_maths_btn2);
        stu_maths_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(stu_mathematics.this, stu_dashboard.class);
                startActivity(intent);
            }
        });
    }

    public void goFaceCam(View view){
        SharedPreferences sharePref= PreferenceManager.getDefaultSharedPreferences(stu_mathematics.this);
        SharedPreferences.Editor editor = sharePref.edit();
        editor.putString("Subject","Maths");
        editor.apply();

        Intent intent = new Intent(stu_mathematics.this, FaceLogin.class);
        startActivity(intent);
    }
}