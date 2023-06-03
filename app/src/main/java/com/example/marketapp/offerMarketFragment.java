package com.example.marketapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONObject;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import cz.msebera.android.httpclient.Header;

public class offerMarketFragment extends AppCompatActivity {


    RecyclerView recyclerView;
    List<DataClass> dataList;
    DatabaseReference databaseReference;
    ValueEventListener eventListener;

    final String APP_ID = "f5ca53909af72aeb24361439619370b7";
    final String WEATHER_URL = "https://api.openweathermap.org/data/2.5/weather";
    final long MIN_TIME = 5000;
    final float MIN_DISTANCE = 1000;
    final int REQUEST_CODE = 101;

    String Location_provider = LocationManager.GPS_PROVIDER;

    TextView weather,nameUser,name_boot;
    ImageView status_weather;

    LocationManager mLocationManager;
    LocationListener locationListener;
    SearchView searchView;
    MyAdapter adapter;
    String nameUser_s,nameBoot_s,nameUser_d,nameBoot_d;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.fragment_offer_market);



        recyclerView = findViewById((int) R.id.recycleView);
        searchView = findViewById(R.id.searchBar);
        searchView.clearFocus();

        GridLayoutManager gridLayoutManager = new GridLayoutManager(offerMarketFragment.this, 1);
        recyclerView.setLayoutManager(gridLayoutManager);

        AlertDialog.Builder builder = new AlertDialog.Builder(offerMarketFragment.this);
        builder.setCancelable(false);
        builder.setView(R.layout.progress_layout);
        AlertDialog dialog = builder.create();
        dialog.show();

        dataList = new ArrayList<>();

        adapter = new MyAdapter(offerMarketFragment.this, dataList);
        recyclerView.setAdapter(adapter);

        databaseReference = FirebaseDatabase.getInstance().getReference("Manager");
        dialog.show();

        eventListener = databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                dataList.clear();
                for (DataSnapshot itemSnapshot : snapshot.getChildren()) {
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

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                searchList(newText);
                return true;
            }
        });


        BottomNavigationView bottom = findViewById(R.id.bottomNavigationView);
        bottom.setSelectedItemId(R.id.homeBottom);

        bottom.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.homeBottom) {
                startActivity(new Intent(getApplicationContext(), offerMarketFragment.class));
                overridePendingTransition(0, 0);
                return true;
            } else if (item.getItemId() == R.id.orderBottom) {
                startActivity(new Intent(getApplicationContext(), OrderSeller.class));
                overridePendingTransition(0, 0);
                return true;
            }
            else if (item.getItemId() == R.id.profileBottom) {
                startActivity(new Intent(getApplicationContext(), profile.class));
                overridePendingTransition(0, 0);
                return true;
            }
            return false;
        });

        Calendar calendar = Calendar.getInstance();
        Date date = new Date();
        calendar.setTime(date);



        String[] Days = new String[]{ "เสาร์","อาทิตย์","จันทร์", "อังคาร", "พุธ", "พฤหัส", "ศุกร์" };
        TextView textDate = findViewById((int) R.id.Date_Text);
        String currentDay = Days[calendar.get(Calendar.DAY_OF_WEEK)];
        textDate.setText(currentDay);

        TextView season = findViewById((int) R.id.season_text);
        ImageView sun = findViewById((int) R.id.summer_season);
        int current_day = calendar.get(Calendar.DAY_OF_MONTH);
        int current_month = (calendar.get(Calendar.MONTH) + 1);
        String current_season = "";

        if (current_month == 2) {
            if (current_day >= 14) {
                current_season = "ฤดูร้อน";
                season.setText(current_season);
            } else {
                current_season = "ฤดูหนาว";
                season.setText(current_season);
                sun.setImageResource(R.drawable.cold_heart_cute_svgrepo_com);

            }
        } else if (current_month > 2 && current_month < 6) {
            current_season = "ฤดูร้อน";
            season.setText(current_season);
            if (current_month == 5) {
                if (current_day <= 15) {
                    current_season = "ฤดูร้อน";
                    season.setText(current_season);
                } else {
                    current_season = "ฤดูฝน";
                    season.setText(current_season);
                    sun.setImageResource(R.drawable.rain_svgrepo_com_1);

                }

            }
        } else if (current_month == 6) {
            current_season = "ฤดูฝน";
            season.setText(current_season);
            sun.setImageResource(R.drawable.rain_svgrepo_com_1);
        } else if (current_month > 6 && current_month < 11) {
            current_season = "ฤดูฝน";
            season.setText(current_season);
            sun.setImageResource(R.drawable.rain_svgrepo_com_1);
            if (current_month == 10) {
                if (current_day <= 15) {
                    current_season = "ฤดูฝน";
                    season.setText(current_season);
                    sun.setImageResource(R.drawable.rain_svgrepo_com_1);
                } else {
                    current_season = "ฤดูหนาว";
                    season.setText(current_season);
                    sun.setImageResource(R.drawable.cold_heart_cute_svgrepo_com);

                }

            }
        } else if (current_month == 11 || current_month == 12) {
            current_season = "ฤดูหนาว";
            season.setText(current_season);
            sun.setImageResource(R.drawable.cold_heart_cute_svgrepo_com);
        } else if (current_month == 1) {
            current_season = "ฤดูหนาว";
            season.setText(current_season);
            sun.setImageResource(R.drawable.cold_heart_cute_svgrepo_com);

        }


        weather = findViewById(R.id.weatherText);
        status_weather = findViewById(R.id.weatherImage);
    }


        @Override
        protected void onResume () {
            super.onResume();
            getWeatherForCurrentLocation();

        }

        private void getWeatherForCurrentLocation () {
            mLocationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
            locationListener = new LocationListener() {
                @Override
                public void onLocationChanged(@NonNull Location location) {
                    String Latitude = String.valueOf(location.getLatitude());
                    String Longitude = String.valueOf(location.getLongitude());

                    RequestParams params = new RequestParams();
                    params.put("lat", Latitude);
                    params.put("lon", Longitude);
                    params.put("appid", APP_ID);
                    letdoSumeNetworking(params);

                }
            };

            if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_CODE);
                return;
            }
            mLocationManager.requestLocationUpdates(Location_provider, MIN_TIME, MIN_DISTANCE, locationListener);

        }

        @Override
        public void onRequestPermissionsResult ( int requestCode, @NonNull String[] permissions,
        @NonNull int[] grantResults){
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);

            if (requestCode == REQUEST_CODE) {

                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    Toast.makeText(offerMarketFragment.this, "Locationget Sucsessfully", Toast.LENGTH_SHORT).show();
                    getWeatherForCurrentLocation();
                } else {

                    //
                }

            }
        }

        private void letdoSumeNetworking (RequestParams params){

            AsyncHttpClient client = new AsyncHttpClient();

            client.get(WEATHER_URL, params, new JsonHttpResponseHandler() {

                @Override
                public void onSuccess(int statusCode, Header[] headers, JSONObject response) {

                    Toast.makeText(offerMarketFragment.this, "Data get Success", Toast.LENGTH_SHORT).show();

                    weatherData weatherD = weatherData.fromJson(response);
                    updateUI(weatherD);


                    //super.onSuccess(statusCode, headers, response);
                }

                @Override
                public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                    super.onFailure(statusCode, headers, throwable, errorResponse);
                }
            });

        }


        public void updateUI (weatherData w){

            weather.setText(w.getmWeather());
            int resourceID = getResources().getIdentifier(w.getmImage(), "drawable", getPackageName());
            status_weather.setImageResource(resourceID);


        }

        @Override
        protected void onPause () {
            super.onPause();
            if (mLocationManager != null) {

                mLocationManager.removeUpdates(locationListener);

            }
        }


        public void searchList(String text){

        ArrayList<DataClass> searchList = new ArrayList<>();
        for(DataClass dataClass: dataList){
            if(dataClass.getDataNameMarket().toLowerCase().contains(text.toLowerCase())){

                searchList.add(dataClass);

            }

        }

        adapter.searthDataList(searchList);

        }

}

