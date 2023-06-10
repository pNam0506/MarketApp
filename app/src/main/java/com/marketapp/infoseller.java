package com.marketapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.marketapp.R;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.utilities.Constants;
import com.utilities.PreferenceManager;

import java.util.HashMap;

public class infoseller extends AppCompatActivity {

    private Button saveS;
    private EditText nameS,bootS,phoneS,productS;

    TextView emailS;
    private String Sname,Sboot,Semail,Sphone,Sproduct;

    FirebaseDatabase mDatabase;
    DatabaseReference mRef;

    private PreferenceManager preferenceManager;

    public static final String NAME_USER = "NAME_USER";
    public static final String NAME_BOOT = "NAME_BOOT";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infoseller);
        nameS =  findViewById((int)R.id.nameinfoSeller);
        bootS =  findViewById(R.id.boot);
        emailS = findViewById(R.id.email);
        phoneS =  findViewById(R.id.phone);
        productS =  findViewById(R.id.product);
        saveS =  findViewById(R.id.save);

        preferenceManager = new PreferenceManager(getApplicationContext());
        emailS.setText(preferenceManager.getString(Constants.KEY_EMAIL));



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

                    preferenceManager.putString(NAME_BOOT,Sboot);
                    preferenceManager.putString(NAME_USER,Sname);
                    
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