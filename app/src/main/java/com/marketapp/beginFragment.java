package com.marketapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.marketapp.R;

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


                   Intent intent = new Intent(beginFragment.this,StorelistFreeFeel.class);

                   startActivity(intent);
               }
            }

        };thread.start();
    }
}//จบๆๆๆ +งมอีกสามชม หฟมกแยงนฟำพ่รเพกะนย