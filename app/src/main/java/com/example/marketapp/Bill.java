package com.example.marketapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

public class Bill extends AppCompatActivity {


    TextView log_rec,log_price;
    ImageView bill;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill);

        log_rec = findViewById(R.id.bill_log_rec);
        log_price = findViewById(R.id.bill_log_price);
        bill = findViewById(R.id.slip_bill);


        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            log_rec.setText(bundle.getString("Slip"));
            log_price.setText(bundle.getString("log_rec"));
            Glide.with(this).load(bundle.getString("log_price")).into(bill);
        }







    }
}