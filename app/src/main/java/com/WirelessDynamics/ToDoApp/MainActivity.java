package com.WirelessDynamics.ToDoApp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView mPageTitleTxtView, mSupTitleTxtView, mEndOfPageTxtView;
    private RecyclerView mDutiesRecyclerView;
    private ArrayList<MyDutyModel> myDutyModelArrayList;
    private Button mNewDutyButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPageTitleTxtView = findViewById(R.id.app_title_txt_view);
        mSupTitleTxtView = findViewById(R.id.sub_title_txt_view);
        mEndOfPageTxtView = findViewById(R.id.end_of_duties_txt_view);
        mDutiesRecyclerView = findViewById(R.id.duties_recycler_view);
        mNewDutyButton = findViewById(R.id.add_new_duty_btn);
        mNewDutyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), NewDutyActivity.class));
            }
        });

        myDutyModelArrayList = new ArrayList<>();
        MyDutyAdapter adapter = new MyDutyAdapter(MainActivity.this, myDutyModelArrayList);
        mDutiesRecyclerView.setAdapter(adapter);
        mDutiesRecyclerView.setLayoutManager(new LinearLayoutManager(this));


    }
}