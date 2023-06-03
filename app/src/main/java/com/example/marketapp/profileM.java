package com.example.marketapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class profileM extends AppCompatActivity {

    Button b1,b2,b3,b4;

    AlertDialog.Builder delete,prob;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_m);
        b1 = (Button) findViewById(R.id.profile);
        b2 = (Button) findViewById(R.id.safty);
        b3 = (Button) findViewById(R.id.delete);
        b4 = (Button) findViewById(R.id.probpo);

        delete = new AlertDialog.Builder(this);

        Intent Bp = new Intent(this, informationMarketFragment.class);
        Intent login = new Intent(this,Login.class);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(Bp);
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delete.setTitle("คุณต้องการจะลบบัญชี?")
                        .setMessage("บัญชีของคุณจะถูกลบอย่างถาวร")
                        .setCancelable(true)
                        .setPositiveButton("ใช่", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                startActivity(login);
                            }
                        })
                        .setNegativeButton("ไม่", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        })
                        .show();
            }
        });


        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prob.setTitle("เกี่ยวกับแอพลิเคชัน")
                        .setMessage("Build from Android studio for android 5.0 or more")
                        .setCancelable(true)
                        .setPositiveButton("back", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int i) {
                                dialog.cancel();
                            }
                        }).show();
            }
        });


        BottomNavigationView bottom = findViewById((int)R.id.bottomNavigationViewM);
        bottom.setSelectedItemId(R.id.profileBottom);

        bottom.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.homeBottom) {
                startActivity(new Intent(getApplicationContext(), mainMarketFragment.class));
                overridePendingTransition(0, 0);
                return true;
            } else if (item.getItemId() == R.id.orderBottom) {
                startActivity(new Intent(getApplicationContext(), orderManager.class));
                overridePendingTransition(0, 0);
                return true;
            }
            else if (item.getItemId() == R.id.profileBottom) {
                startActivity(new Intent(getApplicationContext(), profileM.class));
                overridePendingTransition(0, 0);
                return true;
            }


            return false;
        });

    }
}