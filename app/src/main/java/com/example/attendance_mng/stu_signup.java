package com.example.attendance_mng;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class stu_signup extends AppCompatActivity {

    private Button stu_signup_btn2;
    private Button stu_signup_btn1;
    public FirebaseFirestore db;
    public String TAG="SRA";
    public com.google.android.material.textfield.TextInputEditText name;
    public com.google.android.material.textfield.TextInputEditText userName;
    public com.google.android.material.textfield.TextInputEditText password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide(); // Hide the Action Bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN); // Hide the Status Bar
        setContentView(R.layout.activity_stu_signup);
        db = FirebaseFirestore.getInstance();
        userName =findViewById(R.id.tu_username);
        name =findViewById(R.id.tu_name);
        password =findViewById(R.id.tu_password);


        stu_signup_btn2 = findViewById(R.id.stu_signup_btn2);
        stu_signup_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(stu_signup.this, login.class);
                startActivity(intent);
            }
        });

        stu_signup_btn1 = findViewById(R.id.stu_signup_btn1);
        stu_signup_btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signUp();
            }
        });
    }

    public void signUp(){

        String Name=name.getText().toString();
        String UserName=userName.getText().toString();
        String Password=password.getText().toString();
        Map<String, Object> user = new HashMap<>();
        user.put("name", Name);
        user.put("username", UserName);
        user.put("password", Password);

        if(Name.isEmpty()){
            name.setError(" Name is empty" );
            name.requestFocus();
            return;
        }

        if(UserName.isEmpty()){
            userName.setError(" User Name is empty" );
            userName.requestFocus();
            return;
        }

        if(Password.isEmpty()){
            password.setError("Password is empty" );
            password.requestFocus();
            return;
        }

        if(Password.length() < 5){
            password.setError("Min password length should be 5 characters ");
            password.requestFocus();
            return;

        }

        if(Password.length() > 10){
            password.setError("Max password length should be 10 characters ");
            password.requestFocus();
            return;

        }


        // Add a new document with a generated ID
        db.collection("users")
                .add(user)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());

                        SharedPreferences sharePref= PreferenceManager.getDefaultSharedPreferences(stu_signup.this);
                        SharedPreferences.Editor editor = sharePref.edit();
                        editor.putString("user",Name);
                        editor.apply();

                        Intent intent = new Intent(stu_signup.this, FaceRecActivity.class);
                        startActivity(intent);
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error adding document", e);
                    }
                });
    }
}