package com.marketapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.marketapp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class nama extends AppCompatActivity {

    Button success;

    EditText log_selected, item;

    private int log,count = 1;

    private String price,nameMarket,item_s,count_s;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nama);


        success = findViewById((int)R.id.Success3);
        log_selected = findViewById((int)R.id.log_nama);
        item = findViewById((int)R.id.log_nama_item);
        count_s = "จำนวน "+count+" ร้าน";





        success.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                setData();

            }
        });




    }

    public void setData(){


        log = Integer.parseInt(log_selected.getText().toString().trim());
        item_s = item.getText().toString().trim();

        String item_ch = "ขาย "+item_s;
        String log_j = "จองล็อคที่ "+log+" Nama";
        nameMarket = "Nama";

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("slip");
        Query checkData = reference.orderByChild("dataSlip").equalTo(log_j);

        checkData.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){

                    log_selected.setError("มีการจองเเล้ว");
                    log_selected.requestFocus();

                }
                else{

                    if(log <= 4){
                        price = "ราคา 600 บาท";

                        Intent intent = new Intent(nama.this,slip.class);

                        intent.putExtra(slip.LOG_S,log_j);
                        intent.putExtra(slip.PRICE,price);
                        intent.putExtra(slip.NAME_MARKET,nameMarket);

                        startActivity(intent);


                    }
                    else if(log > 4 && log <= 13){
                        price = "ราคา 450 บาท";

                        Intent intent = new Intent(nama.this,slip.class);

                        intent.putExtra(slip.LOG_S,log_j);
                        intent.putExtra(slip.PRICE,price);
                        intent.putExtra(slip.NAME_MARKET,nameMarket);

                        startActivity(intent);


                    }
                    else if(log == 14){
                        price = "ราคา 400 บาท";

                        Intent intent = new Intent(nama.this,slip.class);

                        intent.putExtra(slip.LOG_S,log_j);
                        intent.putExtra(slip.PRICE,price);
                        intent.putExtra(slip.NAME_MARKET,nameMarket);

                        startActivity(intent);


                    }

                    DatabaseReference reference = FirebaseDatabase.getInstance().getReference("slip");
                    Query checkData = reference.orderByChild("dataItem").equalTo(item_ch);

                    checkData.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if(snapshot.exists()){

                                count = (int) snapshot.getChildrenCount()+1;
                                    count_s = "จำนวน "+count+" ร้าน";
                                    Intent intent = new Intent(nama.this,slip.class);

                                    intent.putExtra(slip.LOG_S,log_j);
                                    intent.putExtra(slip.PRICE,price);
                                    intent.putExtra(slip.ITEM,item_ch);
                                    intent.putExtra(slip.COUNT,count_s);
                                    startActivity(intent);

                            }
                            else{

                                count_s = "จำนวน "+count+" ร้าน";
                                    Intent intent = new Intent(nama.this,slip.class);

                                    intent.putExtra(slip.LOG_S,log_j);
                                    intent.putExtra(slip.PRICE,price);
                                    intent.putExtra(slip.ITEM,item_ch);
                                    intent.putExtra(slip.COUNT,count_s);
                                    startActivity(intent);

                            }


                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });




                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });







    }
}

