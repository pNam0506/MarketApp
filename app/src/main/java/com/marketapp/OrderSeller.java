package com.marketapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.chat_app.activities.MainActivity;
import com.example.marketapp.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class OrderSeller extends AppCompatActivity {

    RecyclerView recyclerView_b;
    List<slipClass> dataList_slip;
    DatabaseReference reference;
    ValueEventListener eventListener;

    AdapterBill adapterBill;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_seller);




        recyclerView_b = findViewById(R.id.order_bill);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(OrderSeller.this,1);
        recyclerView_b.setLayoutManager(gridLayoutManager);

        AlertDialog.Builder builder = new AlertDialog.Builder(OrderSeller.this);
        builder.setCancelable(false);
        builder.setView(R.layout.progress_layout);
        AlertDialog dialog = builder.create();
        dialog.show();

        dataList_slip = new ArrayList<>();


        adapterBill = new AdapterBill(OrderSeller.this,dataList_slip);
        recyclerView_b.setAdapter(adapterBill);


        reference = FirebaseDatabase.getInstance().getReference("slip");

        dialog.show();

        eventListener = reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                dataList_slip.clear();

                for(DataSnapshot itemSnapshot: snapshot.getChildren()){

                    slipClass slipClass_s = itemSnapshot.getValue(slipClass.class);



                    dataList_slip.add(slipClass_s);



                }
                adapterBill.notifyDataSetChanged();
                dialog.dismiss();



            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                dialog.dismiss();

            }
        });






        BottomNavigationView bottom = findViewById(R.id.bottomNavigationView);
        bottom.setSelectedItemId(R.id.orderBottom);

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
}