package com.marketapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.marketapp.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class night_fairs extends AppCompatActivity {

    Button success;

    EditText log_selected;

    private int log;

    private String price;



    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.night_fairs_booking);

        success = findViewById((int)R.id.Success2);
        log_selected = findViewById((int)R.id.log_night_fair);





        success.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                setData();

            }
        });




    }

    public void setData(){


        log = Integer.parseInt(log_selected.getText().toString().trim());
        String log_j = "จองล็อคที่"+log;


        if(log <= 4){
            price = "ราคา 600 บาท";

            Intent intent = new Intent(night_fairs.this,slip.class);

            intent.putExtra(slip.LOG_S,log_j);
            intent.putExtra(slip.PRICE,price);

            startActivity(intent);


        }
        else if(log <= 20){
            price = "ราคา 350 บาท";

            Intent intent = new Intent(night_fairs.this,slip.class);

            intent.putExtra(slip.LOG_S,log_j);
            intent.putExtra(slip.PRICE,price);

            startActivity(intent);


        }





    }

}
