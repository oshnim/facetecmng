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

public class stu_mathematics extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    //Variables
    DrawerLayout drawerLayoutsm;
    NavigationView navigationViewsm;
    androidx.appcompat.widget.Toolbar stu_maths_toolbar;

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

        /*----------------------Hooks----------------------*/

        drawerLayoutsm = findViewById(R.id.drawerlayout_sm);
        navigationViewsm = findViewById(R.id.nav_view_sm);
        stu_maths_toolbar = findViewById(R.id.stu_maths_toolbar);



        /*----------------------Tool Bar----------------------*/

        //setSupportActionBar(toolbar);


        /*----------------------Navigation Drawer Menu----------------------*/

        navigationViewsm.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayoutsm,stu_maths_toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayoutsm.addDrawerListener(toggle);
        toggle.syncState();

        navigationViewsm.setNavigationItemSelectedListener(this);
    }
    @Override
    public void onBackPressed() {

        if(drawerLayoutsm.isDrawerOpen(GravityCompat.START)){

            drawerLayoutsm.closeDrawer(GravityCompat.START);
        }

        else{
            super.onBackPressed();
        }


    }



    public void goFaceCam(View view){
        SharedPreferences sharePref= PreferenceManager.getDefaultSharedPreferences(stu_mathematics.this);
        SharedPreferences.Editor editor = sharePref.edit();
        editor.putString("Subject","Maths");
        editor.apply();

        Intent intent = new Intent(stu_mathematics.this, FaceLogin.class);
        startActivity(intent);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {
        switch (item.getItemId()) {

            case R.id.nav_view:
                break;

            case R.id.nav_maths:
                Intent intent = new Intent(stu_mathematics.this, stu_mathematics.class);
                startActivity(intent);
                break;

            case R.id.nav_science:
                Intent intent1 = new Intent(stu_mathematics.this, stu_science.class);
                startActivity(intent1);
                break;

            case R.id.nav_computing:
                Intent intent2 = new Intent(stu_mathematics.this, stu_computing.class);
                startActivity(intent2);
                break;

            case R.id.nav_english:
                Intent intent3 = new Intent(stu_mathematics.this, stu_english.class);
                startActivity(intent3);
                break;

            case R.id.nav_logout:
                Intent intent4 = new Intent(stu_mathematics.this, login_cp.class);
                startActivity(intent4);
                break;

        }
        return true;
    }
}