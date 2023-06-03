package com.example.marketapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class infoseller extends AppCompatActivity {

    private Button saveS;
    private EditText nameS,bootS,emailS,phoneS,productS;

    private String Sname,Sboot,Semail,Sphone,Sproduct;

    FirebaseDatabase mDatabase;
    DatabaseReference mRef;


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

        mDatabase = FirebaseDatabase.getInstance();
        mRef = mDatabase.getReference("User");


        saveS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Sname = nameS.getText().toString();
                Sboot = bootS.getText().toString();
                Semail = emailS.getText().toString();
                Sphone = phoneS.getText().toString();
                Sproduct = productS.getText().toString();

                if(Sname.isEmpty()||Sboot.isEmpty()||Semail.isEmpty()||Sphone.isEmpty()||Sproduct.isEmpty()){

                    Toast.makeText(infoseller.this,"กรุณากรอกข้อมูลให้ครบถ้วน",Toast.LENGTH_SHORT).show();


                }
                else {


                    userClass userClass_s = new userClass();
                    userClass_s.setDataNameUser(Sname);
                    userClass_s.setDataNameBoot(Sboot);
                    userClass_s.setDataEmailUser(Semail);
                    userClass_s.setDataPhoneUser(Sphone);
                    userClass_s.setDataProduct(Sproduct);
                    mRef.child(Sboot).setValue(userClass_s, new DatabaseReference.CompletionListener() {
                        @Override
                        public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {

                            if(error == null){

                                Toast.makeText(infoseller.this,"บันทึกข้อมูลเรียบร้อย",Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(infoseller.this,offerMarketFragment.class);
                                startActivity(intent);

                            }else {

                                Toast.makeText(infoseller.this,"เกิดปัญหาในการบันทึก",Toast.LENGTH_SHORT).show();

                            }

                        }
                    });





                }



            }
        });

    }








}