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

public class login extends AppCompatActivity {

    private Button login_btn2;
    private Button login_btn3;
    private Button login_btn1;
    public com.google.android.material.textfield.TextInputEditText name;
    public com.google.android.material.textfield.TextInputEditText password;
    public String TAG="SRA";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide(); // Hide the Action Bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN); // Hide the Status Bar
        setContentView(R.layout.activity_login);

        name =findViewById(R.id.username);
        password =findViewById(R.id.password);
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        login_btn3 = findViewById(R.id.login_btn3);
        login_btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(login.this,stu_signup.class);
                startActivity(intent);
            }
        });

        login_btn1 = findViewById(R.id.login_btn1);
        login_btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String UserName=name.getText().toString();
                String Password=password.getText().toString();
                db.collection("users")
                        .whereEqualTo("username", UserName)
                        .whereEqualTo("password", Password)
                        .get()
                        .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                if (task.isSuccessful()) {
                                    for (QueryDocumentSnapshot document : task.getResult()) {
                                        String User=document.get("username").toString();
                                        Toast.makeText(login.this, User+""+UserName, Toast.LENGTH_SHORT).show();
                                        if(User.equals(UserName)){
                                            Intent intent = new Intent(login.this,stu_dashboard.class);
                                            startActivity(intent);
                                        }else{
                                            //Toast.makeText(login.this, "Wrong Username or Password", Toast.LENGTH_SHORT).show();
                                        }

                                    }
                                } else {
                                    Log.w(TAG, "Error getting documents.", task.getException());
                                }
                            }
                        });
            }
        });



        login_btn2 = findViewById(R.id.login_btn2);
        login_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(login.this,tutor_login.class);
                startActivity(intent);
            }
        });



    }
}