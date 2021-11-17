package com.example.attendance_mng;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.google.android.material.navigation.NavigationView;

import org.jetbrains.annotations.NotNull;

public class stu_computing extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    //Variables
    DrawerLayout drawerLayoutsc;
    NavigationView navigationViewsc;
    androidx.appcompat.widget.Toolbar stu_computing_toolbar;

    private Button stu_computing_btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide(); // Hide the Action Bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN); // Hide the Status Bar
        setContentView(R.layout.activity_stu_computing);

        stu_computing_btn2 = findViewById(R.id.stu_computing_btn2);
        stu_computing_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(stu_computing.this, stu_dashboard.class);
                startActivity(intent);
            }
        });

        /*----------------------Hooks----------------------*/

        drawerLayoutsc = findViewById(R.id.drawerlayout_sm);
        navigationViewsc = findViewById(R.id.nav_view_sm);
        stu_computing_toolbar = findViewById(R.id.stu_computing_toolbar);



        /*----------------------Tool Bar----------------------*/

        //setSupportActionBar(toolbar);


        /*----------------------Navigation Drawer Menu----------------------*/

        navigationViewsc.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayoutsc,stu_computing_toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayoutsc.addDrawerListener(toggle);
        toggle.syncState();

        navigationViewsc.setNavigationItemSelectedListener(this);


    }

    @Override
    public void onBackPressed() {

        if(drawerLayoutsc.isDrawerOpen(GravityCompat.START)){

            drawerLayoutsc.closeDrawer(GravityCompat.START);
        }

        else{
            super.onBackPressed();
        }


    }

    public void goFaceCam(View view){
        SharedPreferences sharePref= PreferenceManager.getDefaultSharedPreferences(stu_computing.this);
        SharedPreferences.Editor editor = sharePref.edit();
        editor.putString("Subject","Computing");
        editor.apply();

        Intent intent = new Intent(stu_computing.this, FaceLogin.class);
        startActivity(intent);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {

        switch (item.getItemId()) {

            case R.id.nav_view:
                break;

            case R.id.nav_maths:
                Intent intent = new Intent(stu_computing.this, stu_mathematics.class);
                startActivity(intent);
                break;

            case R.id.nav_science:
                Intent intent1 = new Intent(stu_computing.this, stu_science.class);
                startActivity(intent1);
                break;

            case R.id.nav_computing:
                Intent intent2 = new Intent(stu_computing.this, stu_computing.class);
                startActivity(intent2);
                break;

            case R.id.nav_english:
                Intent intent3 = new Intent(stu_computing.this, stu_english.class);
                startActivity(intent3);
                break;

            case R.id.nav_logout:
                Intent intent4 = new Intent(stu_computing.this, login_cp.class);
                startActivity(intent4);
                break;

        }
        return true;
    }

}