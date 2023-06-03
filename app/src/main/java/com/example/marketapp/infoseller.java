package com.example.marketapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class infoseller extends AppCompatActivity {

    private Button saveS;
    private EditText nameS,bootS,emailS,phoneS,productS;

    private String Sname,Sboot,Semail,Sphone,Sproduct;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infoseller);
        nameS = (EditText) findViewById((int)R.id.nameinfoSeller);
        bootS = (EditText) findViewById(R.id.boot);
        emailS = (EditText) findViewById(R.id.email);
        phoneS = (EditText) findViewById(R.id.phone);
        productS = (EditText) findViewById(R.id.product);
        saveS = (Button) findViewById(R.id.save);


        saveS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
                Toast.makeText(infoseller.this,"บันทึกข้อมูลเรียบร้อย",Toast.LENGTH_SHORT).show();


            }
        });

    }
    public void saveData(){

        Sname = nameS.getText().toString().trim();
        Sboot = bootS.getText().toString().trim();
        Semail = emailS.getText().toString().trim();
        Sphone = phoneS.getText().toString().trim();
        Sproduct = productS.getText().toString().trim();

        Intent intent = new Intent(infoseller.this,offerMarketFragment.class);
        intent.putExtra(offerMarketFragment.NAME_SELLER,Sname);
        intent.putExtra(offerMarketFragment.NAME_BOOT,Sboot);
        startActivity(intent);


    }
}