package com.example.marketapp;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;

public class informationMarketFragment extends AppCompatActivity {

    EditText UploadMr_Ms, UploadName_Manager, UploadName_Market,Upload_Location_Market;
    Button save;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_information_market);

        UploadMr_Ms = findViewById(R.id.Mr_or_Ms);
        UploadName_Manager = findViewById(R.id.NameOfManager);
        UploadName_Market = findViewById(R.id.NameOfMarket);
        Upload_Location_Market = findViewById(R.id.LocationOfMarket);
        save = findViewById( R.id.saveBottom);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getMr_Ms = UploadMr_Ms.getText().toString();
                String getName_Manager = UploadName_Manager.getText().toString();
                String getName_Market = UploadName_Market.getText().toString();
                String getLocation_Market = Upload_Location_Market.getText().toString();

                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("Mr_Ms", getMr_Ms);
                hashMap.put("NameOfManager", getName_Manager);
                hashMap.put("NameOfMarket", getName_Market);
                hashMap.put("LocationOfMarket", getLocation_Market);


                FirebaseFirestore.getInstance().collection("Manager")
                        .document("ManagerData")
                        .set(hashMap)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                Toast.makeText(informationMarketFragment.this, "Data saved Successfully", Toast.LENGTH_SHORT).show();

                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(informationMarketFragment.this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });

            }
        });
    }
    }
