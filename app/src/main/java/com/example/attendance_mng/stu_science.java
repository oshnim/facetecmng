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

public class stu_science extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    //Variables
    DrawerLayout drawerLayoutss;
    NavigationView navigationViewss;
    androidx.appcompat.widget.Toolbar stu_science_toolbar;

    private Button stu_science_btn2;
    private Button stu_science_btn1;

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

        stu_science_btn1 = findViewById(R.id.stu_science_btn1);
        stu_science_btn1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                SharedPreferences sharePref= PreferenceManager.getDefaultSharedPreferences(stu_science.this);
                SharedPreferences.Editor editor = sharePref.edit();
                editor.putString("Subject","Science");
                editor.apply();

                Intent intent = new Intent(stu_science.this, FaceLogin.class);
                startActivity(intent);
            }
        });

        /*----------------------Hooks----------------------*/

        drawerLayoutss = findViewById(R.id.drawerlayout_ss);
        navigationViewss = findViewById(R.id.nav_view_ss);
        stu_science_toolbar = findViewById(R.id.stu_science_toolbar);



        /*----------------------Tool Bar----------------------*/

        //setSupportActionBar(toolbar);


        /*----------------------Navigation Drawer Menu----------------------*/

        navigationViewss.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayoutss,stu_science_toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayoutss.addDrawerListener(toggle);
        toggle.syncState();

        navigationViewss.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {

        if(drawerLayoutss.isDrawerOpen(GravityCompat.START)){

            drawerLayoutss.closeDrawer(GravityCompat.START);
        }

        else{
            super.onBackPressed();
        }


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {

        switch (item.getItemId()) {

            case R.id.nav_view:
                break;

            case R.id.nav_maths:
                Intent intent = new Intent(stu_science.this, stu_mathematics.class);
                startActivity(intent);
                break;

            case R.id.nav_science:
                Intent intent1 = new Intent(stu_science.this, stu_science.class);
                startActivity(intent1);
                break;

            case R.id.nav_computing:
                Intent intent2 = new Intent(stu_science.this, stu_computing.class);
                startActivity(intent2);
                break;

            case R.id.nav_english:
                Intent intent3 = new Intent(stu_science.this, stu_english.class);
                startActivity(intent3);
                break;

            case R.id.nav_logout:
                Intent intent4 = new Intent(stu_science.this, login_cp.class);
                startActivity(intent4);
                break;

        }
        return true;
    }
}