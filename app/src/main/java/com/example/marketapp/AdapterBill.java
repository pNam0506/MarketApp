package com.example.marketapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterBill extends RecyclerView.Adapter<MyViewHolderBill> {

    private Context context;
    private List<slipClass> dataList_slip;

    public AdapterBill(Context context, List<slipClass> dataList_slip) {
        this.context = context;
        this.dataList_slip = dataList_slip;

    }

    @NonNull
    @Override
    public MyViewHolderBill onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_item_order,parent,false);

        return new MyViewHolderBill(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderBill holder, int position) {
        holder.Log_price.setText(dataList_slip.get(position).getDatalog());
        holder.Log_rec.setText(dataList_slip.get(position).getDataSlip());
        holder.time_slip.setText(dataList_slip.get(position).getDataTime());
        holder.date_slip.setText(dataList_slip.get(position).getDataDate());

        holder.recCard_B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Bill.class);
                intent.putExtra("Slip",dataList_slip.get(holder.getAdapterPosition()).getDataSlip());
                intent.putExtra("log_price",dataList_slip.get(holder.getAdapterPosition()).getDataprice());
                intent.putExtra("log_rec",dataList_slip.get(holder.getAdapterPosition()).getDatalog());

                context.startActivity(intent);


            }
        });

    }

    @Override
    public int getItemCount() {
        return dataList_slip.size();
    }
}

class MyViewHolderBill extends RecyclerView.ViewHolder{

    TextView Log_price,Log_rec,time_slip,date_slip;
    CardView recCard_B;

    public MyViewHolderBill(@NonNull View itemView) {
        super(itemView);
        Log_price = itemView.findViewById(R.id.log_price);
        recCard_B = itemView.findViewById(R.id.recCard_bill);
        Log_rec = itemView.findViewById(R.id.log_rec);
        time_slip = itemView.findViewById(R.id.Time_slip);
        date_slip = itemView.findViewById(R.id.Date_slip);


    }
}