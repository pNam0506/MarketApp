package com.marketapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.marketapp.R;

public class freeFeel extends AppCompatActivity {

    Button success;

    EditText log_selected;

    private int log;

    private String price,nameMarket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_free_feel);

        success = findViewById(R.id.Success);
        log_selected = findViewById((int)R.id.log_free_feel);


        success.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setData2();
            }
        });

    }

    public void setData2(){


        log = Integer.parseInt(log_selected.getText().toString().trim());


        if(log == 15 || log == 16){
            price = "ราคา 500 บาท";
            nameMarket = "Free Feel";

            Intent intent = new Intent(freeFeel.this,slip.class);

            intent.putExtra(slip.LOG,log);
            intent.putExtra(slip.PRICE,price);
            intent.putExtra(slip.NAME_MARKET,nameMarket);

            startActivity(intent);


        }
        else{
            price = "ราคา 300 บาท";
            nameMarket = "Free Feel";

            Intent intent = new Intent(freeFeel.this,slip.class);

            intent.putExtra(slip.LOG,log);
            intent.putExtra(slip.PRICE,price);
            intent.putExtra(slip.NAME_MARKET,nameMarket);

            startActivity(intent);


        }





    }
}