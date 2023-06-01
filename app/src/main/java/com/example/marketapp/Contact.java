package com.example.marketapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Contact extends AppCompatActivity {

    Button nm;
    Button nf;
    Button ff;
    Button tm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        nm = findViewById(R.id.button1);
        nf = findViewById(R.id.button2);
        ff = findViewById(R.id.button3);
        tm = findViewById(R.id.button4);

        nm.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                gotoUrl("https://www.facebook.com/Liabduan.nightmarket?mibextid=LQQJ4d");
            }
        });
        nf.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                gotoUrl("https://www.facebook.com/saveonemarket?mibextid=LQQJ4d");
            }
        });
        ff.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                gotoUrl("https://www.facebook.com/taradrodfi?mibextid=LQQJ4d");
            }
        });
        tm.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                gotoUrl("https://www.facebook.com/DDMarche.market?mibextid=LQQJ4d");
            }
        });

    }

    private void gotoUrl(String s){
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }
}