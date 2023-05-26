package com.example.marketapp;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.text.DateFormat;
import java.util.Calendar;

public class offerMarketFragment extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_offer_market);

        BottomNavigationView bottom = findViewById(R.id.bottomNavigationView);
        bottom.setSelectedItemId(R.id.homeBottom);

        bottom.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.homeBottom) {
                startActivity(new Intent(getApplicationContext(), offerMarketFragment.class));
                overridePendingTransition(0,0);
                return true;
            } else if (item.getItemId() == R.id.orderBottom) {
                startActivity(new Intent(getApplicationContext(), selectStatusFragment.class));
                overridePendingTransition(0,0);
                return true;
            }
            return false;
        });

        Calendar calendar = Calendar.getInstance();
        String currentDate = DateFormat.getDateInstance(DateFormat.SHORT).format(calendar.getTime());
        TextView textDate = findViewById((int)R.id.Date_Text);
        textDate.setText(currentDate);

        TextView season = findViewById((int)R.id.season_text);
        ImageView sun = findViewById((int)R.id.summer_season);
        int current_day = calendar.get(Calendar.DAY_OF_MONTH);
        int current_month = (calendar.get(Calendar.MONTH)+1);
        String current_season = "";

        if(current_month == 2 ){
            if(current_day >= 14){
            current_season = "ฤดูร้อน";
            season.setText(current_season);
            }
            else{
                current_season = "ฤดูหนาว";
                season.setText(current_season);
                sun.setImageResource(R.drawable.cold_heart_cute_svgrepo_com);

            }
        }
        else if (current_month > 2 && current_month < 6 ) {
            current_season = "ฤดูร้อน";
            season.setText(current_season);
            if(current_month == 5 ){
                if(current_day <= 15){
                    current_season = "ฤดูร้อน";
                    season.setText(current_season);}
                else {
                    current_season = "ฤดูฝน";
                    season.setText(current_season);
                    sun.setImageResource(R.drawable.rain_svgrepo_com_1);

                }

            }
        }
        else if(current_month == 6 ){
            current_season = "ฤดูฝน";
                season.setText(current_season);
            sun.setImageResource(R.drawable.rain_svgrepo_com_1);
        }
        else if (current_month > 6 && current_month < 11 ) {
            current_season = "ฤดูฝน";
            season.setText(current_season);
            sun.setImageResource(R.drawable.rain_svgrepo_com_1);
            if(current_month == 10 ){
                if(current_day <= 15){
                    current_season = "ฤดูฝน";
                    season.setText(current_season);
                    sun.setImageResource(R.drawable.rain_svgrepo_com_1);}
                else {
                    current_season = "ฤดูหนาว";
                    season.setText(current_season);
                    sun.setImageResource(R.drawable.cold_heart_cute_svgrepo_com);

                }

            }
        }
        else if(current_month == 11 || current_month == 12){
            current_season = "ฤดูหนาว";
            season.setText(current_season);
            sun.setImageResource(R.drawable.cold_heart_cute_svgrepo_com);
        }
        else if (current_month == 1) {
            current_season = "ฤดูหนาว";
            season.setText(current_season);
            sun.setImageResource(R.drawable.cold_heart_cute_svgrepo_com);

        }
    }


    //*pgสวสัดีคับhp
}