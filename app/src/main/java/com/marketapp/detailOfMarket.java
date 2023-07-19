package com.marketapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.marketapp.R;

public class detailOfMarket extends AppCompatActivity {

    TextView detailNameMk;
    TextView detailRules,detailLocation,detailTimeM,detailTimeB,detailphon,detailemail,detailOrder;
    ImageView detailImage;

    Button Map,direc,list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_of_market);

        detailNameMk = findViewById(R.id.detailNameMk);
        detailLocation = findViewById(R.id.detailInform);
        detailImage = findViewById(R.id.detailImage);
        Map = findViewById((int)R.id.map);
        direc = findViewById((int)R.id.direction);
        detailRules = findViewById((int)R.id.rules);
        detailTimeM = findViewById((int)R.id.timeM);
        detailTimeB = findViewById((int)R.id.timeB);
        detailphon = findViewById((int)R.id.phone);
        detailemail = findViewById((int)R.id.EmailM);
        detailOrder = findViewById((int)R.id.order);
        list = findViewById(R.id.storelist);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            detailLocation.setText(bundle.getString("LocationMk"));
            detailNameMk.setText(bundle.getString("NameMk"));
            detailRules.setText(bundle.getString("Rules"));
            detailTimeM.setText(bundle.getString("timeM"));
            detailTimeB.setText(bundle.getString("timeB"));
            detailphon.setText(bundle.getString("phone"));
            detailemail.setText(bundle.getString("email"));
            detailOrder.setText(bundle.getString("order"));

            Glide.with(this).load(bundle.getString("image")).into(detailImage);

        }
        if(bundle.getString("NameMk").equals("Night Fair")) {

            Map.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(detailOfMarket.this, night_fairs.class);
                    startActivity(intent);
                }

            });

            direc.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Uri uri = Uri.parse("https://www.google.co.th/maps/dir/13.9084904,100.5059896/%E0%B8%96.+%E0%B8%9E%E0%B8%A3%E0%B8%B0%E0%B8%A3%E0%B8%B2%E0%B8%A1+9+%E0%B9%80%E0%B8%82%E0%B8%95%E0%B8%AB%E0%B9%89%E0%B8%A7%E0%B8%A2%E0%B8%82%E0%B8%A7%E0%B8%B2%E0%B8%87+%E0%B8%81%E0%B8%A3%E0%B8%B8%E0%B8%87%E0%B9%80%E0%B8%97%E0%B8%9E%E0%B8%A1%E0%B8%AB%E0%B8%B2%E0%B8%99%E0%B8%84%E0%B8%A3/@13.8309344,100.4642671,12z/data=!3m1!4b1!4m9!4m8!1m1!4e1!1m5!1m1!1s0x30e29e3f19a81f03:0xbf2e74f9fb8ae289!2m2!1d100.5843957!2d13.7542289?hl=th&entry=ttu");
                    Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                    intent.setPackage("com.google.android.apps.maps");
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);

                }
            });

            list.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(detailOfMarket.this,StorelistNightFairs.class);
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

            direc.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Uri uri = Uri.parse("https://www.google.co.th/maps/dir/13.9084904,100.5059896/%E0%B8%96.+%E0%B9%80%E0%B8%88%E0%B8%A3%E0%B8%B4%E0%B8%8D%E0%B8%81%E0%B8%A3%E0%B8%B8%E0%B8%87+%E0%B9%81%E0%B8%82%E0%B8%A7%E0%B8%87%E0%B8%9A%E0%B8%B2%E0%B8%87%E0%B8%A3%E0%B8%B1%E0%B8%81+%E0%B9%80%E0%B8%82%E0%B8%95%E0%B8%9A%E0%B8%B2%E0%B8%87%E0%B8%A3%E0%B8%B1%E0%B8%81+%E0%B8%81%E0%B8%A3%E0%B8%B8%E0%B8%87%E0%B9%80%E0%B8%97%E0%B8%9E%E0%B8%A1%E0%B8%AB%E0%B8%B2%E0%B8%99%E0%B8%84%E0%B8%A3/@13.8196875,100.4142343,12z/data=!3m1!4b1!4m9!4m8!1m1!4e1!1m5!1m1!1s0x30e298e9a642599f:0x13c101faaa9a3b4c!2m2!1d100.5162628!2d13.7251332?hl=th&entry=ttu");
                    Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                    intent.setPackage("com.google.android.apps.maps");
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);

                }
            });

            list.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(detailOfMarket.this,StorelistFreeFeel.class);
                    startActivity(intent);
                }
            });




        }


        if(bundle.getString("NameMk").equals("Tuo Mom")) {

            Map.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(detailOfMarket.this, tuomom.class);
                    startActivity(intent);
                }

            });

            direc.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Uri uri = Uri.parse("https://www.google.co.th/maps/dir/13.9077343,100.4958685/%E0%B9%80%E0%B8%82%E0%B8%95%E0%B8%AA%E0%B8%B2%E0%B8%97%E0%B8%A3+%E0%B8%81%E0%B8%A3%E0%B8%B8%E0%B8%87%E0%B9%80%E0%B8%97%E0%B8%9E%E0%B8%A1%E0%B8%AB%E0%B8%B2%E0%B8%99%E0%B8%84%E0%B8%A3+10120/@13.8034193,100.358,11z/data=!3m1!4b1!4m10!4m9!1m1!4e1!1m5!1m1!1s0x30e29f353eff01d1:0x30100b25de24f40!2m2!1d100.5335358!2d13.7150398!3e0?hl=th&entry=ttu");
                    Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                    intent.setPackage("com.google.android.apps.maps");
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);

                }
            });

            list.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(detailOfMarket.this,StorelistToumom.class);
                    startActivity(intent);
                }
            });







        }

        if(bundle.getString("NameMk").equals("Nama")) {

            Map.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(detailOfMarket.this, nama.class);
                    startActivity(intent);
                }

            });

            direc.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Uri uri = Uri.parse("https://www.google.co.th/maps/dir/13.9077343,100.4958685/%E0%B9%81%E0%B8%82%E0%B8%A7%E0%B8%87%E0%B8%95%E0%B8%A5%E0%B8%B2%E0%B8%94%E0%B8%9E%E0%B8%A5%E0%B8%B9+%E0%B9%80%E0%B8%82%E0%B8%95%E0%B8%98%E0%B8%99%E0%B8%9A%E0%B8%B8%E0%B8%A3%E0%B8%B5+%E0%B8%81%E0%B8%A3%E0%B8%B8%E0%B8%87%E0%B9%80%E0%B8%97%E0%B8%9E%E0%B8%A1%E0%B8%AB%E0%B8%B2%E0%B8%99%E0%B8%84%E0%B8%A3+10600/@13.8212847,100.2996624,11z/data=!3m1!4b1!4m10!4m9!1m1!4e1!1m5!1m1!1s0x30e2985d2e50261d:0x40100b25de28b50!2m2!1d100.4747843!2d13.7184591!3e0?hl=th&entry=ttu");
                    Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                    intent.setPackage("com.google.android.apps.maps");
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);

                }
            });

            list.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(detailOfMarket.this,Storelistnama.class);
                    startActivity(intent);
                }
            });







        }

        if(bundle.getString("NameMk").equals("Lingko")) {

            Map.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(detailOfMarket.this, lingko.class);
                    startActivity(intent);
                }

            });

            direc.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Uri uri = Uri.parse("https://www.google.co.th/maps/dir/13.9077343,100.4958685/17+%E0%B8%8B%E0%B8%AD%E0%B8%A2+%E0%B9%80%E0%B8%9E%E0%B8%8A%E0%B8%A3%E0%B9%80%E0%B8%81%E0%B8%A9%E0%B8%A1+39%2F1+%E0%B9%81%E0%B8%82%E0%B8%A7%E0%B8%87%E0%B8%9A%E0%B8%B2%E0%B8%87%E0%B9%81%E0%B8%84+%E0%B9%80%E0%B8%82%E0%B8%95%E0%B8%9A%E0%B8%B2%E0%B8%87%E0%B9%81%E0%B8%84+%E0%B8%81%E0%B8%A3%E0%B8%B8%E0%B8%87%E0%B9%80%E0%B8%97%E0%B8%9E%E0%B8%A1%E0%B8%AB%E0%B8%B2%E0%B8%99%E0%B8%84%E0%B8%A3+10160/@13.8203797,100.2990005,11z/data=!3m1!4b1!4m10!4m9!1m1!4e1!1m5!1m1!1s0x30e297ec158c04c5:0xca94c272b26fe939!2m2!1d100.4241695!2d13.7117866!3e0?hl=th&entry=ttu");
                    Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                    intent.setPackage("com.google.android.apps.maps");
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);

                }
            });

            list.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(detailOfMarket.this,Storelistlingko.class);
                    startActivity(intent);
                }
            });







        }


        }
    }
