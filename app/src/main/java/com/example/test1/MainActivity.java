package com.example.test1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ButtonBarLayout;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button1,button2;
    EditText Password;
    TextView textView,username;

    String User,Userpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textView);

        Password = (EditText) findViewById(R.id.Password);
        button1 = (Button) findViewById(R.id.Singup);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opentest1_2();
            }
        });
        button2 = (Button) findViewById(R.id.Login);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Password.getText().toString().equals("admin")){
                    Toast.makeText(MainActivity.this,"Login successful",Toast.LENGTH_SHORT).show();}
                else
                    Toast.makeText(MainActivity.this,"Login failed ",Toast.LENGTH_SHORT).show();

            }
        });
    }

    public void opentest1_2(){
        Intent intent = new Intent(this, test1_2.class);
        startActivity(intent);
    }



}