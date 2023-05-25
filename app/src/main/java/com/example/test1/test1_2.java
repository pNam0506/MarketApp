package com.example.test1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class test1_2 extends AppCompatActivity {

    Button Singup;

    String SUser,Spass;

    EditText Username,Password,rePassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test12);
        Username = (EditText) findViewById(R.id.Username);
        Password = (EditText) findViewById(R.id.Password);
        rePassword = (EditText) findViewById(R.id.rePassword);


        Singup = (Button) findViewById(R.id.Singup);


        Singup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Password.getText().toString().equals("")||Username.getText().toString().equals("")){
                    Toast.makeText(test1_2.this,"โปรดกรอกข้อมูล",Toast.LENGTH_SHORT).show();
                }
                else if(Password.getText().toString().equals(rePassword.getText().toString())){
                   SUser = Username.getText().toString();
                   Spass = Password.getText().toString();
                    Toast.makeText(test1_2.this,"สร้างบัญชีเรียบร้อย",Toast.LENGTH_SHORT).show();
                    openinfo();
                }
                else{
                    Toast.makeText(test1_2.this,"รหัสผ่านไม่เหมือนกัน",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void openinfo(){
        Intent intent = new Intent(this, info.class);
        startActivity(intent);
    }


}