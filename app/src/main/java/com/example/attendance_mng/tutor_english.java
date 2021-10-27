package com.example.attendance_mng;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class tutor_english extends AppCompatActivity {

    private Button tutor_english_btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide(); // Hide the Action Bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN); // Hide the Status Bar
        setContentView(R.layout.activity_tutor_english);

        tutor_english_btn2 = findViewById(R.id.tutor_english_btn2);
        tutor_english_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(tutor_english.this, tutor_dashboard.class);
                startActivity(intent);
            }
        });
    }

    public void goHistory(View view){
        SharedPreferences sharePref= PreferenceManager.getDefaultSharedPreferences(tutor_english.this);
        SharedPreferences.Editor editor = sharePref.edit();
        editor.putString("Subject","English");
        editor.apply();

        Intent intent = new Intent(tutor_english.this, History.class);
        startActivity(intent);
    }
}