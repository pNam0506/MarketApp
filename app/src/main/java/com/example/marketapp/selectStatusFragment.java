package com.example.marketapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class selectStatusFragment extends AppCompatActivity {

    private String selected = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_select_status);

        final LinearLayout sellerLayout = findViewById((int)R.id.sellerLayout);
        final LinearLayout managerLayout = findViewById((int)R.id.managerLayout);

        final Button nextButton = findViewById((int)R.id.nextLayout);

        sellerLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                selected = "ผู้ขาย";

                sellerLayout.setBackgroundResource(R.drawable.selected);

                managerLayout.setBackgroundResource(R.drawable.border_corner);




            }
        });
        managerLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                selected = "ตลาด";

                    managerLayout.setBackgroundResource(R.drawable.selected);

                    sellerLayout.setBackgroundResource(R.drawable.border_corner);





            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(selected.isEmpty()){
                    Toast.makeText(selectStatusFragment.this,"กรุณาเลือกสถานะของคุณ", Toast.LENGTH_SHORT).show();

                }
                else if (selected =="ผู้ขาย") {
                    Intent intent = new Intent(selectStatusFragment.this, sellerFragment.class);

                    startActivity(intent);

                }
                else{
                    Intent intent = new Intent(selectStatusFragment.this, managerFragment.class);

                    startActivity(intent);

                }
            }
        });

// test Program by bombenten


    }
}