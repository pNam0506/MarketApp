package com.marketapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.marketapp.R;
import com.models.User;

import java.util.ArrayList;

public class StoreAdapter extends RecyclerView.Adapter<StoreAdapter.MyViewHolder> {

    Context context;
    ArrayList<slipClass> list;

    public StoreAdapter(Context context, ArrayList<slipClass> list) {
        this.context = context;
        this.list = list;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemstore,parent,false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.NameBoot.setText(list.get(position).getDataNameBoot());

        holder.Product.setText(list.get(position).getDataItem());


    }



    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView NameBoot, Product;

        public MyViewHolder(@NonNull View itemView){
            super(itemView);

            NameBoot = itemView.findViewById(R.id.Storefirstname);
            Product = itemView.findViewById(R.id.productfirstname);

        }
    }
}
