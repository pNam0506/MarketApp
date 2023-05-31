package com.example.marketapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class infoseller extends AppCompatActivity {

    private Button save;
    private EditText name,boot,email,phone,product;

    private String Sname,Sboot,Semail,Sphone,Sproduct;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infoseller);
        name = (EditText) findViewById(R.id.name);
        boot = (EditText) findViewById(R.id.boot);
        email = (EditText) findViewById(R.id.email);
        phone = (EditText) findViewById(R.id.phone);
        product = (EditText) findViewById(R.id.product);
        save = (Button) findViewById(R.id.save);
        Intent intent = new Intent(this, profile.class);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Sname = name.getText().toString();
                Sboot = boot.getText().toString();
                Semail = email.getText().toString();
                Sphone = phone.getText().toString();
                Sproduct = product.getText().toString();
                Toast.makeText(infoseller.this,"บันทึกข้อมูลเรียบร้อย",Toast.LENGTH_SHORT).show();
                startActivity(intent);

            }
        });

    }
}