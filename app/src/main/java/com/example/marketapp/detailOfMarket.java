package com.example.marketapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class detailOfMarket extends AppCompatActivity {

    TextView detailNameMk,detailRules;
    ImageView detailImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_of_market);

        detailNameMk = findViewById(R.id.detailNameMk);
        detailRules = findViewById(R.id.detailInform);
        detailImage = findViewById(R.id.detailImage);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            detailRules.setText(bundle.getString("LocationMk"));
            detailNameMk.setText(bundle.getString("NameMk"));
            Glide.with(this).load(bundle.getString("image")).into(detailImage);

        }
    }
}