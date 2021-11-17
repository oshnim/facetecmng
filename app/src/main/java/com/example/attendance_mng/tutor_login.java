package com.example.attendance_mng;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class tutor_login extends AppCompatActivity {

    private Button tutor_login_btn2;
    private Button tutor_login_btn3;
    public com.google.android.material.textfield.TextInputEditText userName;
    public FirebaseFirestore db;
    public com.google.android.material.textfield.TextInputEditText password;
    public String TAG="SRA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide(); // Hide the Action Bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN); // Hide the Status Bar
        setContentView(R.layout.activity_tutor_login);
        db = FirebaseFirestore.getInstance();
        userName =findViewById(R.id.tutor_username);
        password =findViewById(R.id.tutor_password);

        tutor_login_btn3 = findViewById(R.id.tutor_login_btn3);
        tutor_login_btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tutor_login.this, tutor_signup.class);
                startActivity(intent);
            }
        });


        tutor_login_btn2 = findViewById(R.id.tutor_login_btn2);
        tutor_login_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(tutor_login.this, login.class);
                startActivity(intent);
            }
        });
    }

    public void login(View view){
        String UserName=userName.getText().toString();
        String Password=password.getText().toString();
        int x =0;
        if(x == 0) {
            db.collection("tutors")
                    .whereEqualTo("username", UserName)
                    .whereEqualTo("password", Password)
                    .get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            if (task.isSuccessful()) {
                                for (QueryDocumentSnapshot document : task.getResult()) {

                                    String User = document.get("username").toString();
                                    Toast.makeText(tutor_login.this, User + "" + UserName, Toast.LENGTH_SHORT).show();
                                    if (User.equals(UserName)) {
                                        Intent intent = new Intent(tutor_login.this, tutor_dashboard.class);
                                        startActivity(intent);
                                        finish();
                                    } else {
                                        Toast.makeText(tutor_login.this, "Wrong Username or Password", Toast.LENGTH_SHORT).show();
                                    }

                                }
                            } else {
                                Log.w(TAG, "Error getting documents.", task.getException());
                            }
                        }
                    });
        }
    }
}