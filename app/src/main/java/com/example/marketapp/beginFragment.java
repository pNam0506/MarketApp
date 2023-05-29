package com.example.marketapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class beginFragment extends AppCompatActivity {

    // number of selected tab, we have 4 tabs so value must lie between 1-4


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_begin);

        Thread thread = new Thread(){

            public void run(){
               try{
                   sleep(3000);

               }
                catch (Exception e){
                   e.printStackTrace();

                }
               finally {
                   Intent intent = new Intent(beginFragment.this, informationMarketFragment.class);
                   startActivity(intent);
               }
            }

        };thread.start();
    }
}