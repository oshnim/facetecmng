package com.example.attendance_mng;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class tutor_maths extends AppCompatActivity {

    private Button tutor_maths_btn2;
    private Button tutor_maths_btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide(); // Hide the Action Bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN); // Hide the Status Bar
        setContentView(R.layout.activity_tutor_maths);

//        tutor_maths_btn1 = findViewById(R.id.tutor_maths_btn1);
//        tutor_maths_btn1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(tutor_maths.this, tutor_maths_view_atte.class);
//                startActivity(intent);
//            }
//        });

        tutor_maths_btn2 = findViewById(R.id.tutor_maths_btn2);
        tutor_maths_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(tutor_maths.this, tutor_dashboard.class);
                startActivity(intent);
            }
        });

    }

    public void goHistory(View view){
        SharedPreferences sharePref= PreferenceManager.getDefaultSharedPreferences(tutor_maths.this);
        SharedPreferences.Editor editor = sharePref.edit();
        editor.putString("Subject","Maths");
        editor.apply();

        Intent intent = new Intent(tutor_maths.this, History.class);
        startActivity(intent);
    }
}