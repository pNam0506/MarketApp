package com.example.marketapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {

    Button button1,button2;
    EditText Password;
    TextView textView,username;

    String User,Userpass;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();
        textView = (TextView) findViewById(R.id.textView);
        Password = (EditText) findViewById(R.id.Password);
        button1 = (Button) findViewById(R.id.Singup);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openstatus();
            }
        });
        button2 = (Button) findViewById(R.id.Login);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Password.getText().toString().equals("admin")){
                    Toast.makeText(Login.this,"Login successful",Toast.LENGTH_SHORT).show();
                    openofferMarketFragment();



                }
                else
                    Toast.makeText(Login.this,"Login failed ",Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void openstatus(){
        Intent intent = new Intent(this, singup.class);
        startActivity(intent);
    }

    public void openofferMarketFragment(){
        Intent offer = new Intent(this, offerMarketFragment.class);
        startActivity(offer);
    }
}