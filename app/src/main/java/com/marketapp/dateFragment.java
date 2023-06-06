package com.marketapp;

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

import com.example.marketapp.R;
import com.google.firebase.database.core.Context;

import java.text.DateFormat;
import java.util.Calendar;

public class dateFragment extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_date);

        Calendar calendar = Calendar.getInstance();
        String currentDate = DateFormat.getDateInstance(DateFormat.SHORT).format(calendar.getTime());

        TextView textDate = findViewById((int)R.id.Date_Text_1);
        textDate.setText(currentDate);

    }
}