package com.example.marketapp;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class offerMarketFragment extends AppCompatActivity {

    RecyclerView recyclerView;
    List<DataClass> dataList;
    DatabaseReference databaseReference;
    ValueEventListener eventListener;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_offer_market);

        recyclerView = findViewById((int)R.id.recycleView);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(offerMarketFragment.this,1);
        recyclerView.setLayoutManager(gridLayoutManager);

        AlertDialog.Builder builder = new AlertDialog.Builder(offerMarketFragment.this);
        builder.setCancelable(false);
        builder.setView(R.layout.progress_layout);
        AlertDialog dialog = builder.create();
        dialog.show();

        dataList = new ArrayList<>();

        MyAdapter adapter = new MyAdapter(offerMarketFragment.this,dataList);
        recyclerView.setAdapter(adapter);

        databaseReference = FirebaseDatabase.getInstance().getReference("Manager");
        dialog.show();

        eventListener = databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                dataList.clear();
                for(DataSnapshot itemSnapshot : snapshot.getChildren() ){
                    DataClass dataClass = itemSnapshot.getValue(DataClass.class);
                    dataList.add(dataClass);

                }
                adapter.notifyDataSetChanged();
                dialog.dismiss();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                dialog.dismiss();
            }
        });


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
        Date date = new Date();
        calendar.setTime(date);

        String[] Days = new String[]{"จันทร์","อังคาร","พุธ","พฤหัส","ศุกร์","เสาร์","อาทิตย์"};
        TextView textDate = findViewById((int)R.id.Date_Text);
        String currentDay = Days[calendar.get(Calendar.DAY_OF_WEEK)-2];
        textDate.setText(currentDay);

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
}