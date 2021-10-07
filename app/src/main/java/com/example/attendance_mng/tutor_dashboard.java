package com.example.attendance_mng;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

public class tutor_dashboard extends AppCompatActivity implements View.OnClickListener {

    public CardView tcard1, tcard2, tcard3, tcard4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide(); // Hide the Action Bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN); // Hide the Status Bar
        setContentView(R.layout.activity_tutor_dashboard);

        tcard1 = (CardView) findViewById(R.id.t_cv1);
        tcard2 = (CardView) findViewById(R.id.t_cv2);
        tcard3 = (CardView) findViewById(R.id.t_cv3);
        tcard4 = (CardView) findViewById(R.id.t_cv4);

        tcard1.setOnClickListener(this);
        tcard2.setOnClickListener(this);
        tcard3.setOnClickListener(this);
        tcard4.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {

        Intent i;

        switch (v.getId()){

            case R.id.t_cv1:
                i = new Intent(this,tutor_maths.class);
                startActivity(i);
                break;

            case R.id.t_cv2:
                i = new Intent(this,tutor_science.class);
                startActivity(i);
                break;

            case R.id.t_cv3:
                i = new Intent(this,tutor_computing.class);
                startActivity(i);
                break;

            case R.id.t_cv4:
                i = new Intent(this,tutor_english.class);
                startActivity(i);
                break;

        }

    }
}