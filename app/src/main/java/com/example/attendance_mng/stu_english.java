package com.example.attendance_mng;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class stu_english extends AppCompatActivity {

    private Button stu_english_btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide(); // Hide the Action Bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN); // Hide the Status Bar
        setContentView(R.layout.activity_stu_english);

        stu_english_btn2 = findViewById(R.id.stu_english_btn2);
        stu_english_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(stu_english.this, stu_dashboard.class);
                startActivity(intent);
            }
        });

    }

    public void goFaceCam(View view){
        SharedPreferences sharePref= PreferenceManager.getDefaultSharedPreferences(stu_english.this);
        SharedPreferences.Editor editor = sharePref.edit();
        editor.putString("Subject","English");
        editor.apply();

        Intent intent = new Intent(stu_english.this, FaceLogin.class);
        startActivity(intent);
    }
}