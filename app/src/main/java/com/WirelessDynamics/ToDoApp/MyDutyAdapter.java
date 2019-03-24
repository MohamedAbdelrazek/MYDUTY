package com.WirelessDynamics.ToDoApp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MyDutyAdapter extends RecyclerView.Adapter<MyDutyAdapter.MyViewHolder> {

    Context mContext;
    ArrayList<MyDutyModel> myDutyArrayList;

    public MyDutyAdapter(Context context, ArrayList<MyDutyModel> dutyArrayList) {
        this.mContext = context;
        this.myDutyArrayList = dutyArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.recycler_view_single_item, viewGroup, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        Log.i("ZOKA", "onBindViewHolder");
        myViewHolder.titleTxtView.setText(myDutyArrayList.get(i).getDutyTitle());
        myViewHolder.descTxtView.setText(myDutyArrayList.get(i).getDutyDesc());
        myViewHolder.dateTxtView.setText(myDutyArrayList.get(i).getDutyDate());

        Log.i("ZOKA", "onBindViewHolder" + myDutyArrayList.get(i).getDutyDesc());
    }

    @Override
    public int getItemCount() {
        return myDutyArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView titleTxtView, descTxtView, dateTxtView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTxtView = itemView.findViewById(R.id.item_title);
            descTxtView = itemView.findViewById(R.id.item_desc);
            dateTxtView = itemView.findViewById(R.id.item_date);
        }
    }
}
