package com.WirelessDynamics.ToDoApp;

import android.arch.lifecycle.Observer;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.WirelessDynamics.ToDoApp.roomDb.Duty;

import com.facebook.stetho.Stetho;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    private TextView mPageTitleTxtView, mSupTitleTxtView, mEndOfPageTxtView;
    private RecyclerView mDutiesRecyclerView;
    private ArrayList<Duty> myDutyModelArrayList;
    private Button mNewDutyButton;
    private DutyUtils mDutyUtils;
    private MyDutyAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Stetho.initializeWithDefaults(this);
        mPageTitleTxtView = findViewById(R.id.app_title_txt_view);
        mSupTitleTxtView = findViewById(R.id.sub_title_txt_view);
        mEndOfPageTxtView = findViewById(R.id.end_of_duties_txt_view);
        mDutiesRecyclerView = findViewById(R.id.duties_recycler_view);
        mNewDutyButton = findViewById(R.id.add_new_duty_btn);
        mDutyUtils = new DutyUtils(this);

        mNewDutyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), NewDutyActivity.class));
            }
        });


        mDutyUtils = new DutyUtils(this);


        try {
            myDutyModelArrayList = (ArrayList<Duty>) mDutyUtils.getDuties();

        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mAdapter = new MyDutyAdapter(MainActivity.this, myDutyModelArrayList);
        mDutiesRecyclerView.setAdapter(mAdapter);
        mDutiesRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }


}