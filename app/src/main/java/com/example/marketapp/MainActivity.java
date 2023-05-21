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

public class MainActivity extends AppCompatActivity {

    // number of selected tab, we have 4 tabs so value must lie between 1-4
    private int selectedTab = 1;
    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final LinearLayout homeLayout = findViewById((int)R.id.homeLayout);
        final LinearLayout orderLayout = findViewById((int)R.id.orderLayout);
        final LinearLayout messageLayout = findViewById((int)R.id.messageLayout);
        final LinearLayout profileLayout = findViewById((int)R.id.profileLayout);

        final ImageView homeImage = findViewById((int)R.id.homeImage);
        final ImageView orderImage = findViewById((int)R.id.orderImage);
        final ImageView messageImage = findViewById((int)R.id.messageImage);
        final ImageView profileImage = findViewById((int)R.id.profileImage);

        final TextView homeText = findViewById((int)R.id.homeText);
        final TextView orderText= findViewById((int)R.id.orderText);
        final TextView messageText = findViewById((int)R.id.messageText);
        final TextView profileText = findViewById((int)R.id.profileText);


        homeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // check if home is already selected or not
                if(selectedTab != 1){
                    // set home fragment
                    getSupportFragmentManager().beginTransaction()
                            .setReorderingAllowed(true)
                            .replace(R.id.fragmentContainer, homeFragment.class, null)
                            .commit();

                    orderText.setVisibility(View.GONE);
                    messageText.setVisibility(View.GONE);
                    profileText.setVisibility(View.GONE);

                    orderImage.setImageResource(R.drawable.icons8_document_original_64);
                    messageImage.setImageResource(R.drawable.icons8_speech_bubble_original_64);
                    profileImage.setImageResource(R.drawable.icons8_contacts_original_64);

                    orderLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    messageLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    profileLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));

                    // select home

                    homeText.setVisibility(View.VISIBLE);
                    homeImage.setImageResource(R.drawable.icons8_home_64);
                    ScaleAnimation scaleAnimation = new ScaleAnimation(0.8f ,1.0f , 1f, 1f,  Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF, 0.0f);
                    scaleAnimation.setDuration(200);
                    scaleAnimation.setFillAfter(true);
                    homeLayout.startAnimation(scaleAnimation);
                    // set 1st tab as selected tab
                    selectedTab = 1;
                }

            }
        });

        orderLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(selectedTab != 2){

                    getSupportFragmentManager().beginTransaction()
                            .setReorderingAllowed(true)
                            .replace(R.id.fragmentContainer, orderFragment.class, null)
                            .commit();

                    homeText.setVisibility(View.GONE);
                    messageText.setVisibility(View.GONE);
                    profileText.setVisibility(View.GONE);

                    homeImage.setImageResource(R.drawable.icons8_home_original_64);
                    messageImage.setImageResource(R.drawable.icons8_speech_bubble_original_64);
                    profileImage.setImageResource(R.drawable.icons8_contacts_original_64);

                    homeLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    messageLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    profileLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));

                    // select home

                    orderText.setVisibility(View.VISIBLE);
                    orderImage.setImageResource(R.drawable.icons8_document_64);
                    ScaleAnimation scaleAnimation = new ScaleAnimation(0.8f ,1.0f , 1f, 1f,  Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF, 0.0f);
                    scaleAnimation.setDuration(200);
                    scaleAnimation.setFillAfter(true);
                    orderLayout.startAnimation(scaleAnimation);
                    // set 1st tab as selected tab
                    selectedTab = 2;
                }

            }
        });

        messageLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(selectedTab != 3){
                    getSupportFragmentManager().beginTransaction()
                            .setReorderingAllowed(true)
                            .replace(R.id.fragmentContainer, messageFragment.class, null)
                            .commit();

                    homeText.setVisibility(View.GONE);
                    orderText.setVisibility(View.GONE);
                    profileText.setVisibility(View.GONE);

                    homeImage.setImageResource(R.drawable.icons8_home_original_64);
                    orderImage.setImageResource(R.drawable.icons8_document_original_64);
                    profileImage.setImageResource(R.drawable.icons8_contacts_original_64);

                    homeLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    orderLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    profileLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));

                    // select home

                    messageText.setVisibility(View.VISIBLE);
                    messageImage.setImageResource(R.drawable.icons8_speech_bubble_64);
                    ScaleAnimation scaleAnimation = new ScaleAnimation(0.8f ,1.0f , 1f, 1f,  Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF, 0.0f);
                    scaleAnimation.setDuration(200);
                    scaleAnimation.setFillAfter(true);
                    messageLayout.startAnimation(scaleAnimation);
                    // set 1st tab as selected tab
                    selectedTab = 3;
                }

            }
        });

        profileLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(selectedTab != 4){

                    getSupportFragmentManager().beginTransaction()
                            .setReorderingAllowed(true)
                            .replace(R.id.fragmentContainer, profileFragment.class, null)
                            .commit();

                    homeText.setVisibility(View.GONE);
                    orderText.setVisibility(View.GONE);
                    messageText.setVisibility(View.GONE);

                    homeImage.setImageResource(R.drawable.icons8_home_original_64);
                    orderImage.setImageResource(R.drawable.icons8_document_original_64);
                    messageImage.setImageResource(R.drawable.icons8_speech_bubble_original_64);


                    homeLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    orderLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    messageLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));


                    // select home

                    profileText.setVisibility(View.VISIBLE);
                    profileImage.setImageResource(R.drawable.icons8_contacts_64);
                    ScaleAnimation scaleAnimation = new ScaleAnimation(0.8f ,1.0f , 1f, 1f,  Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF, 0.0f);
                    scaleAnimation.setDuration(200);
                    scaleAnimation.setFillAfter(true);
                    profileLayout.startAnimation(scaleAnimation);
                    // set 1st tab as selected tab
                    selectedTab = 4;
                }

            }
        });
    }
}