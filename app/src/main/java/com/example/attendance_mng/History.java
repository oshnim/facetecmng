package com.example.attendance_mng;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class History extends AppCompatActivity {

    private String name;
    public String TAG="SRA";
    private LinearLayout LL;
    private FirebaseFirestore db;
    private Button search;
    public EditText SearchTxt;
    private String Subject;
    private TextView label;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide(); // Hide the Action Bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN); // Hide the Status Bar
        setContentView(R.layout.activity_history);

        LL=(LinearLayout) this.findViewById(R.id.ll);
        List<String> vehicles = new ArrayList<>();
        SearchTxt = findViewById(R.id.reg);
        search = findViewById(R.id.button1);
        search = findViewById(R.id.button1);
        label=findViewById(R.id.text);

        SharedPreferences sharePref= PreferenceManager.getDefaultSharedPreferences(this);
        Subject=sharePref.getString("Subject",null);

        label.setText("History of "+Subject);

        db = FirebaseFirestore.getInstance();
        db.collection("history")
                .whereEqualTo("subject", Subject)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {

                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d(TAG, document.getId() + " => " + document.getData());
                                LinearLayout.LayoutParams lparams = new LinearLayout.LayoutParams(
                                        LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                                TextView tv = new TextView(History.this);
                                lparams.gravity = Gravity.CENTER;
                                lparams.setMargins(10, 40, 10, 10);
                                //tv.setCompoundDrawablesWithIntrinsicBounds(R.drawable.vehicle, 0, 0, 0);
                                tv.setTextSize(15);
                                tv.setLayoutParams(lparams);
                                tv.setBackgroundColor(Color.GRAY);
                                Log.d(TAG, "DocumentSnapshot data: " + document.getData());
                                Timestamp timestamp=(Timestamp)document.get("time");
                                Date date = timestamp.toDate();
                                SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm");
                                String strDate = formatter.format(date);

                                tv.setText("@ "+document.get("name").toString()+ " at  "+strDate);
                                LL.addView(tv);

                            }

                        } else {
                            Log.d(TAG, "Error getting documents: ", task.getException());
                        }
                    }
                });

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LL.removeAllViews();
                name=SearchTxt.getText().toString();
                db.collection("history")
                        .whereEqualTo("subject", Subject)
                        .whereEqualTo("name", name)
                        .get()
                        .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<QuerySnapshot> task) {

                                if (task.isSuccessful()) {
                                    for (QueryDocumentSnapshot document : task.getResult()) {
                                        Log.d(TAG, document.getId() + " => " + document.getData());
                                        LinearLayout.LayoutParams lparams = new LinearLayout.LayoutParams(
                                                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                                        TextView tv = new TextView(History.this);
                                        lparams.gravity = Gravity.CENTER;
                                        lparams.setMargins(10, 40, 10, 10);
                                        //tv.setCompoundDrawablesWithIntrinsicBounds(R.drawable.vehicle, 0, 0, 0);
                                        tv.setTextSize(15);
                                        tv.setLayoutParams(lparams);
                                        tv.setBackgroundColor(Color.GRAY);
                                        Log.d(TAG, "DocumentSnapshot data: " + document.getData());
                                        Timestamp timestamp=(Timestamp)document.get("time");
                                        Date date = timestamp.toDate();
                                        SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm");
                                        String strDate = formatter.format(date);

                                        tv.setText("@ "+document.get("name").toString()+ " at  "+strDate);
                                        LL.addView(tv);

                                    }

                                } else {
                                    Log.d(TAG, "Error getting documents: ", task.getException());
                                }
                            }
                        });
            }
        });
    }


}