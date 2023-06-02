package com.example.marketapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class night_fairs extends AppCompatActivity {

    Button success;

    EditText log_selected;

    private int log;


   FirebaseDatabase mDatabase;

   DatabaseReference mRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.night_fairs_booking);

        success = findViewById((int)R.id.Success2);
        log_selected = findViewById((int)R.id.log_night_fair);

        mDatabase = FirebaseDatabase.getInstance();
        mRef = mDatabase.getReference().child("Log");


        success.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                setData();

            }
        });




    }

    public void setData(){


        log = Integer.parseInt(log_selected.getText().toString().trim());

        Intent intent = new Intent(night_fairs.this,slip.class);

        intent.putExtra(slip.LOG,log);

        startActivity(intent);




    }

}
