package com.example.marketapp;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterSlip extends RecyclerView.Adapter<MyViewHolderSlip> {
}
class MyViewHolderSlip extends RecyclerView.ViewHolder{

    ImageView recImage;
    TextView recNameMk,recLocation;
    CardView recCard;


    public MyViewHolderSlip(@NonNull View itemView) {
        super(itemView);

        recImage = itemView.findViewById(R.id.recImage);
        recNameMk = itemView.findViewById(R.id.recNameMk);
        recLocation = itemView.findViewById(R.id.recLocationMk);
        recCard = itemView.findViewById(R.id.recCard);

    }
