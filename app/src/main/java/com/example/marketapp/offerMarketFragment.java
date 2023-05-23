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
        int current_month = calendar.get(Calendar.MONTH);
        String CurrentDay_month = current_day + "/"+ current_month;
        season.setText(CurrentDay_month);

    }
}