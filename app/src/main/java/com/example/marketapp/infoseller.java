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
                Sname = nameS.getText().toString();
                Sboot = bootS.getText().toString();
                Semail = emailS.getText().toString();
                Sphone = phoneS.getText().toString();
                Sproduct = productS.getText().toString();

                Toast.makeText(infoseller.this,"บันทึกข้อมูลเรียบร้อย",Toast.LENGTH_SHORT)
                        .show();
                Intent intent = new Intent(infoseller.this,offerMarketFragment.class);
                startActivity(intent);




            }
        });

    }
}