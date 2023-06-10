package com.marketapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.chat_app.activities.MainActivity;

import com.example.chat_app.activities.SignInActivity;
import com.example.chat_app.activities.SignUpActivity;
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

                   Intent intent = new Intent(beginFragment.this,SignInActivity.class);
                   startActivity(intent);
               }
            }

        };thread.start();
    }
}//จบๆๆๆ +งมอีกสามชม หฟมกแยงนฟำพ่รเพกะนย