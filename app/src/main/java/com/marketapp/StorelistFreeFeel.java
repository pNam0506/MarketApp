package com.marketapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.marketapp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class StorelistFreeFeel extends AppCompatActivity {

    RecyclerView recyclerView;
    StoreAdapter storeAdapter;
    ArrayList<slipClass> list;

    DatabaseReference reference;
    ValueEventListener eventListener;

    String nameMarket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storelist_free_feel);

        recyclerView = findViewById(R.id.StorelistFreeFeel);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(StorelistFreeFeel.this,1);
        recyclerView.setLayoutManager(gridLayoutManager);

        /*AlertDialog.Builder builder = new AlertDialog.Builder(StorelistFreeFeel.this);
        builder.setCancelable(false);
        builder.setView(R.layout.progress_layout);
        AlertDialog dialog = builder.create();
        dialog.show();*/

        list = new ArrayList<>();
        storeAdapter = new StoreAdapter(this,list);
        recyclerView.setAdapter(storeAdapter);

        nameMarket = "Free Feel";
        //reference = FirebaseDatabase.getInstance().getReference("slip");

        reference = FirebaseDatabase.getInstance().getReference(nameMarket);
        Query checkData = reference.orderByChild("dataNameMarket").equalTo(nameMarket);

        checkData.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){

                    eventListener = reference.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {

                            list.clear();

                            for(DataSnapshot itemSnapshot: snapshot.getChildren()){

                                slipClass slipClass_s = itemSnapshot.getValue(slipClass.class);
                                list.add(slipClass_s);

                            }
                            storeAdapter.notifyDataSetChanged();




                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {


                        }
                    });






                }
                else{
                    Toast.makeText(StorelistFreeFeel.this, "ไม่พบข้อมูล", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });




    }
}