package com.example.marketapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private Context context;
    private List<DataClass> dataList;

    public MyAdapter(Context context, List<DataClass> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_item,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Glide.with(context).load(dataList.get(position).getDataImage()).into(holder.recImage);
        holder.recNameMk.setText(dataList.get(position).getDataNameMarket());
        holder.recLocation.setText(dataList.get(position).getDataLocationMarket());

        holder.recCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,detailOfMarket.class);
                intent.putExtra("image",dataList.get(holder.getAdapterPosition()).getDataImage());
                intent.putExtra("NameMk",dataList.get(holder.getAdapterPosition()).getDataNameMarket());
                intent.putExtra("LocationMk",dataList.get(holder.getAdapterPosition()).getDataLocationMarket());

                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public void searthDataList(ArrayList<DataClass> searchList){

        dataList = searchList;
        notifyDataSetChanged();

    }
}

class MyViewHolder extends RecyclerView.ViewHolder{

    ImageView recImage;
    TextView recNameMk,recLocation;
    CardView recCard;


    public MyViewHolder(@NonNull View itemView) {
        super(itemView);

        recImage = itemView.findViewById(R.id.recImage);
        recNameMk = itemView.findViewById(R.id.recNameMk);
        recLocation = itemView.findViewById(R.id.recLocationMk);
        recCard = itemView.findViewById(R.id.recCard);

    }
}