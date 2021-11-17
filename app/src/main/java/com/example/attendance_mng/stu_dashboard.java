package com.example.attendance_mng;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toolbar;



import com.google.android.material.navigation.NavigationView;

public class stu_dashboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    //Variables
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    androidx.appcompat.widget.Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide(); // Hide the Action Bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN); // Hide the Status Bar
        setContentView(R.layout.activity_stu_dashboard);


        /*----------------------Hooks----------------------*/

        drawerLayout = findViewById(R.id.drawerlayout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);



        /*----------------------Tool Bar----------------------*/

        //setSupportActionBar(toolbar);


        /*----------------------Navigation Drawer Menu----------------------*/

        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);


    }

    @Override
    public void onBackPressed() {

       if(drawerLayout.isDrawerOpen(GravityCompat.START)){

           drawerLayout.closeDrawer(GravityCompat.START);
       }

       else{
           super.onBackPressed();
       }


    }

    public void goScience(View view){
        Intent intent = new Intent(this,stu_science.class);
        startActivity(intent);
    }

    public void goMaths(View view){
        Intent intent = new Intent(this,stu_mathematics.class);
        startActivity(intent);
    }

    public void goEnglish(View view){
        Intent intent = new Intent(this,stu_english.class);
        startActivity(intent);
    }

    public void goComputing(View view){
        Intent intent = new Intent(this,stu_computing.class);
        startActivity(intent);
    }



    @Override
    public boolean onNavigationItemSelected(@NonNull @org.jetbrains.annotations.NotNull MenuItem item) {

        switch (item.getItemId()){

            case R.id.nav_view:
                break;

            case R.id.nav_maths:
                Intent intent = new Intent(stu_dashboard.this,stu_mathematics.class);
                startActivity(intent);
                break;

            case R.id.nav_science:
                Intent intent1 = new Intent(stu_dashboard.this,stu_science.class);
                startActivity(intent1);
                break;

            case R.id.nav_computing:
                Intent intent2 = new Intent(stu_dashboard.this,stu_computing.class);
                startActivity(intent2);
                break;

            case R.id.nav_english:
                Intent intent3 = new Intent(stu_dashboard.this,stu_english.class);
                startActivity(intent3);
                break;

            case R.id.nav_logout:
                Intent intent4 = new Intent(stu_dashboard.this,login_cp.class);
                startActivity(intent4);
                break;

        }

        return true;
    }
}
