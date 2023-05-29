package com.example.marketapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class detailOfMarket extends AppCompatActivity {

    TextView detailNameMk;
    TextView detailRules;
    ImageView detailImage;

    Button Map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_of_market);

        detailNameMk = findViewById(R.id.detailNameMk);
        detailRules = findViewById(R.id.detailInform);
        detailImage = findViewById(R.id.detailImage);
        Map = findViewById((int)R.id.map);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            detailRules.setText(bundle.getString("LocationMk"));
            detailNameMk.setText(bundle.getString("NameMk"));
            Glide.with(this).load(bundle.getString("image")).into(detailImage);

        }
        if(bundle.getString("NameMk").equals("Night Fair")){

            Map.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(detailOfMarket.this,night_fairs.class);
                    startActivity(intent);
                }
            });

        }
        else if(bundle.getString("NameMk").equals("Free Feel")){

            Map.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(detailOfMarket.this,freeFeel.class);
                    startActivity(intent);
                }
            });

        }




        }
    }
