package com.marketapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.marketapp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class StorelistFreeFeel extends AppCompatActivity {

    RecyclerView recyclerView;
    StoreAdapter storeAdapter;
    ArrayList<slipClass> list;

    DatabaseReference reference;
    ValueEventListener eventListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storelist_free_feel);

        recyclerView = findViewById(R.id.StorelistFreeFeel);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(StorelistFreeFeel.this,1);
        recyclerView.setLayoutManager(gridLayoutManager);

        AlertDialog.Builder builder = new AlertDialog.Builder(StorelistFreeFeel.this);
        builder.setCancelable(false);
        builder.setView(R.layout.progress_layout);
        AlertDialog dialog = builder.create();
        dialog.show();

        list = new ArrayList<>();
        storeAdapter = new StoreAdapter(this,list);
        recyclerView.setAdapter(storeAdapter);

        reference = FirebaseDatabase.getInstance().getReference("slip");

        dialog.show();

        eventListener = reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                list.clear();

                for(DataSnapshot itemSnapshot: snapshot.getChildren()){

                    slipClass slipClass_s = itemSnapshot.getValue(slipClass.class);
                    list.add(slipClass_s);

                }
                storeAdapter.notifyDataSetChanged();
                dialog.dismiss();



            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                dialog.dismiss();

            }
        });





    }
}