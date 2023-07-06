package com.marketapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.marketapp.R;
import com.models.User;

import java.util.ArrayList;

public class StoreAdapter extends RecyclerView.Adapter<StoreAdapter.MyViewHolder> {

    Context context;
    ArrayList<Store> list;

    public StoreAdapter(Context context, ArrayList<Store> list) {
        this.context = context;
        this.list = list;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.itemstore,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Store store = list.get(position);
        holder.dataNameBoot.setText(store.getStore());
        holder.dataProduct.setText(store.getProduct());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView dataNameBoot, dataProduct;

        public MyViewHolder(@NonNull View itemView){
            super(itemView);

            dataNameBoot = itemView.findViewById(R.id.Storefirstname);
            dataProduct = itemView.findViewById(R.id.productfirstname);

        }
    }
}
