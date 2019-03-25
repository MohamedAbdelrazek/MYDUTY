package com.WirelessDynamics.ToDoApp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;


import com.WirelessDynamics.ToDoApp.roomDb.Duty;

import java.util.ArrayList;

public class MyDutyAdapter extends RecyclerView.Adapter<MyDutyAdapter.MyViewHolder> {

    private final ArrayList<Duty> myDutyArrayList;
    private final DutyDataBaseHelper mDutyDataBaseHelper;


    public MyDutyAdapter(Context context, ArrayList<Duty> dutyArrayList) {
        this.myDutyArrayList = dutyArrayList;
        mDutyDataBaseHelper = new DutyDataBaseHelper(context);
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

        myViewHolder.titleTxtView.setText(myDutyArrayList.get(i).getDutyTitle());
        myViewHolder.descTxtView.setText(myDutyArrayList.get(i).getDutyDesc());
        myViewHolder.dateTxtView.setText(myDutyArrayList.get(i).getDutyDate());
        myViewHolder.isDoneCheckBox.setChecked(myDutyArrayList.get(i).getDone());
    }

    @Override
    public int getItemCount() {
        if (null == myDutyArrayList) {
            return 0;
        } else {
            return myDutyArrayList.size();
        }
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private final TextView titleTxtView, descTxtView, dateTxtView;
        private final CheckBox isDoneCheckBox;

        private MyViewHolder(@NonNull final View itemView) {
            super(itemView);
            titleTxtView = itemView.findViewById(R.id.item_title);
            descTxtView = itemView.findViewById(R.id.item_desc);
            dateTxtView = itemView.findViewById(R.id.item_date);
            isDoneCheckBox = itemView.findViewById(R.id.is_done_check_box);


            isDoneCheckBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (isDoneCheckBox.isChecked()) {


                        mDutyDataBaseHelper.updateDutyState(getAdapterPosition() + 1, true);


                    } else {
                        mDutyDataBaseHelper.updateDutyState(getAdapterPosition() + 1, false);


                    }


                }
            });
        }
    }
}
