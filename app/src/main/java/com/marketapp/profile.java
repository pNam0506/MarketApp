package com.marketapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.adapters.RecentConversationsAdapter;
import com.example.chat_app.activities.BaseActivity;
import com.example.chat_app.activities.ChatActivity;
import com.example.chat_app.activities.MainActivity;
import com.example.chat_app.activities.SignInActivity;
import com.example.chat_app.activities.UsersActivity;
import com.example.marketapp.R;
import com.example.marketapp.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.messaging.FirebaseMessaging;
import com.listeners.ConversionListener;
import com.models.ChatMessage;
import com.models.User;
import com.utilities.Constants;
import com.utilities.PreferenceManager;

import java.util.HashMap;
import java.util.List;

public class profile extends AppCompatActivity implements ConversionListener{

    private ActivityMainBinding binding;
    private PreferenceManager preferenceManager;
    private List<ChatMessage> conversations;
    private RecentConversationsAdapter conversationsAdapter;
    private FirebaseFirestore database;

    Button b1,b2,b3,b4;

    AlertDialog.Builder delete,prob;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        preferenceManager = new PreferenceManager(getApplicationContext());
        setContentView(R.layout.activity_profile);
        b1 = (Button) findViewById(R.id.profile);
        b2 = (Button) findViewById(R.id.safty);
        b3 = (Button) findViewById(R.id.delete);
        b4 = (Button) findViewById(R.id.probpo);


        delete = new AlertDialog.Builder(this);

        Intent Bp = new Intent(this, infoseller.class);
        Intent login = new Intent(this, SignInActivity.class);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(Bp);
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delete.setTitle("คุณต้องการออกจากบัญชี?")
                        .setMessage("คุณต้องการจะออกจากบัญชีนี้แล้วเข้าสู่ระบบใหม่")
                        .setCancelable(true)
                        .setPositiveButton("ใช่", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                signOut();
                            }
                        })
                        .setNegativeButton("ไม่", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        })
                        .show();
            }
        });


        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prob.setTitle("เกี่ยวกับแอพลิเคชัน")
                        .setMessage("Build from Android studio for android 5.0 or more")
                        .setCancelable(true)
                        .setPositiveButton("back", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int i) {
                                dialog.cancel();
                            }
                        }).show();
            }
        });

        BottomNavigationView bottom = findViewById((int)R.id.bottomNavigationView);
        bottom.setSelectedItemId(R.id.profileBottom);

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
            else if (item.getItemId() == R.id.messageBottom) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                overridePendingTransition(0, 0);
                return true;
            }
            return false;
        });

    }


    private void showToast(String message){
        Toast.makeText(getApplicationContext(), message , Toast.LENGTH_SHORT).show();
    }

    private void getToken(){
        FirebaseMessaging.getInstance().getToken().addOnSuccessListener(this::updateToken);
    }

    private void updateToken(String token){
        preferenceManager.putString(Constants.KEY_FCM_TOKEN,token);
        FirebaseFirestore database = FirebaseFirestore.getInstance();
        DocumentReference documentReference =
                database.collection(Constants.KEY_COLLECTION_USERS).document(
                        preferenceManager.getString(Constants.KEY_USER_ID)
                );
        documentReference.update(Constants.KEY_FCM_TOKEN,token)
                .addOnFailureListener(e -> showToast("Unable to update token"));

    }

    private void signOut(){
        showToast("Signing out...");
        FirebaseFirestore database = FirebaseFirestore.getInstance();
        DocumentReference documentReference =
                database.collection(Constants.KEY_COLLECTION_USERS).document(
                        preferenceManager.getString(Constants.KEY_USER_ID)
                );
        HashMap<String,Object> updates = new HashMap<>();
        updates.put(Constants.KEY_FCM_TOKEN, FieldValue.delete());
        documentReference.update(updates)
                .addOnSuccessListener(unused -> {
                    preferenceManager.clear();
                    startActivity(new Intent(getApplicationContext(),SignInActivity.class));
                    finish();
                })
                .addOnFailureListener(e -> showToast("Unable to sign out"));
    }

    @Override
    public void onConversationClicked(User user) {
        Intent intent = new Intent(getApplicationContext(), ChatActivity.class);
        intent.putExtra(Constants.KEY_USER, user);
        startActivity(intent);
    }

}