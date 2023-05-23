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

import java.text.DateFormat;
import java.util.Calendar;

public class offerMarketFragment extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_offer_market);

        Calendar calendar = Calendar.getInstance();
        String currentDate = DateFormat.getDateInstance(DateFormat.SHORT).format(calendar.getTime());
        TextView textDate = findViewById((int)R.id.Date_Text);
        textDate.setText(currentDate);

        TextView season = findViewById((int)R.id.season_text);
        int current_day = calendar.get(Calendar.DAY_OF_MONTH);
        int current_month = (calendar.get(Calendar.MONTH)+1) - 4;
        String current_season = "";

        if(current_month == 2 ){
            if(current_day >= 14){
            current_season = "ฤดูร้อน";
            season.setText(current_season);
            }
            else{
                current_season = "ฤดูหนาว";
                season.setText(current_season);

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

                }

            }
        }
        else if(current_month == 6 ){
            current_season = "ฤดูฝน";
                season.setText(current_season);
        }
        else if (current_month > 6 && current_month < 11 ) {
            current_season = "ฤดูฝน";
            season.setText(current_season);
            if(current_month == 10 ){
                if(current_day <= 15){
                    current_season = "ฤดูฝน";
                    season.setText(current_season);}
                else {
                    current_season = "ฤดูหนาว";
                    season.setText(current_season);

                }

            }
        }
        else if(current_month == 11 || current_month == 12){
            current_season = "ฤดูหนาว";
            season.setText(current_season);
        }
        else if (current_month == 1) {
            current_season = "ฤดูหนาว";
            season.setText(current_season);
        }



    }
}