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
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class tutor_signup extends AppCompatActivity {

    private Button tu_signup_btn2;
    public FirebaseFirestore db;
    public String TAG="SRA";
    public com.google.android.material.textfield.TextInputEditText fname;
    public com.google.android.material.textfield.TextInputEditText lname;
    public com.google.android.material.textfield.TextInputEditText userName;
    public com.google.android.material.textfield.TextInputEditText password;
    public com.google.android.material.textfield.TextInputEditText confirmPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide(); // Hide the Action Bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN); // Hide the Status Bar
        setContentView(R.layout.activity_tutor_signup);

        db = FirebaseFirestore.getInstance();
        userName =findViewById(R.id.tu_username);
        fname =findViewById(R.id.tu_fname);
        lname =findViewById(R.id.tu_lname);
        password =findViewById(R.id.tu_password);
        confirmPassword =findViewById(R.id.tu_con_password);

        tu_signup_btn2 = findViewById(R.id.tu_signup_btn2);
        tu_signup_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(tutor_signup.this, tutor_login.class);
                startActivity(intent);
            }
        });
    }

    public void signup(View view) {
        String fName = fname.getText().toString();
        String lName = lname.getText().toString();
        String UserName = userName.getText().toString();
        String Password = password.getText().toString();
        String confirmPasswords = confirmPassword.getText().toString();


        if (fName.isEmpty()) {
            Toast.makeText(tutor_signup.this, "First Name Field Cannot be Empty", Toast.LENGTH_SHORT).show();

        } else if (lName.isEmpty()) {
            Toast.makeText(tutor_signup.this, "Last Name Field Cannot be Empty", Toast.LENGTH_SHORT).show();


        } else if (UserName.isEmpty()) {
            Toast.makeText(tutor_signup.this, "User Name Field Cannot be Empty", Toast.LENGTH_SHORT).show();

        }else if (Password.length()>=20) {
            Toast.makeText(tutor_signup.this, "Maximum 20 Characters", Toast.LENGTH_SHORT).show();

        } else {
            if (Password.equals(confirmPasswords)) {
                Map<String, Object> user = new HashMap<>();
                user.put("fname", fName);
                user.put("lname", lName);
                user.put("username", UserName);
                user.put("password", Password);

                // Add a new document with a generated ID
                db.collection("tutors")
                        .add(user)
                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference documentReference) {
                                Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());

                                SharedPreferences sharePref = PreferenceManager.getDefaultSharedPreferences(tutor_signup.this);
                                SharedPreferences.Editor editor = sharePref.edit();
                                editor.putString("user", fName + "" + lName);
                                editor.apply();

                                Intent intent = new Intent(tutor_signup.this, tutor_login.class);
                                startActivity(intent);
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Log.w(TAG, "Error adding document", e);
                            }
                        });
            } else {
                Toast.makeText(tutor_signup.this, "Wrong Username or Password", Toast.LENGTH_SHORT).show();
            }
        }
    }
}