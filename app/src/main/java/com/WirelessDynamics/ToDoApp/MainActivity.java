package com.WirelessDynamics.ToDoApp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView mPageTitleTxtView, mSupTitleTxtView, mEndOfPageTxtView;
    private RecyclerView mDutiesRecyclerView;
    private ArrayList<MyDutyModel> myDutyModelArrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPageTitleTxtView = findViewById(R.id.app_title_txt_view);
        mSupTitleTxtView = findViewById(R.id.sub_title_txt_view);
        mEndOfPageTxtView = findViewById(R.id.end_of_duties_txt_view);
        mDutiesRecyclerView = findViewById(R.id.duties_recycler_view);
        myDutyModelArrayList = new ArrayList<>();
        MyDutyModel myDutyModel = new MyDutyModel("Reading Quran", "Today" , "Going to play and wzkrGoing to play and wzkrGoing to play and wzkr");
        MyDutyModel myDutyModel1 = new MyDutyModel("Reading Quran", "ورة البقرة كلها ان شاء الله" +
                "", "Today");
        MyDutyModel myDutyModel2 = new MyDutyModel("Reading Quran", "ورة البقرة كلها ان شاء الله" +
                "", "Today");
        MyDutyModel myDutyModel3 = new MyDutyModel("Reading Quran", "ورة البقرة كلها ان شاء الله" +
                "", "Today");
        MyDutyModel myDutyModel4 = new MyDutyModel("Reading Quran", "ورة البقرة كلها ان شاء الله" +
                "", "Today");
        MyDutyModel myDutyModel5 = new MyDutyModel("Reading Quran", "ورة البقرة كلها ان شاء الله" +
                "", "Today");
        MyDutyModel myDutyModel6 = new MyDutyModel("Reading Quran", "ورة البقرة كلها ان شاء الله" +
                "", "Today");
        MyDutyModel myDutyModel7 = new MyDutyModel("Reading Quran", "ورة البقرة كلها ان شاء الله" +
                "", "Today");
        MyDutyModel myDutyModel8 = new MyDutyModel("Reading Quran", "ورة البقرة كلها ان شاء الله" +
                "", "Today");
        MyDutyModel myDutyModel9 = new MyDutyModel("Reading Quran", "ورة البقرة كلها ان شاء الله" +
                "", "Today");
        MyDutyModel myDutyModel0 = new MyDutyModel("Reading Quran", "ورة البقرة كلها ان شاء الله" +
                "", "Today");
        myDutyModelArrayList.add(myDutyModel);
        myDutyModelArrayList.add(myDutyModel1);
        myDutyModelArrayList.add(myDutyModel2);
        myDutyModelArrayList.add(myDutyModel3);
        myDutyModelArrayList.add(myDutyModel4);
        myDutyModelArrayList.add(myDutyModel5);
        myDutyModelArrayList.add(myDutyModel6);
        myDutyModelArrayList.add(myDutyModel7);
        myDutyModelArrayList.add(myDutyModel8);
        myDutyModelArrayList.add(myDutyModel9);
        myDutyModelArrayList.add(myDutyModel0);
        MyDutyAdapter adapter = new MyDutyAdapter(MainActivity.this, myDutyModelArrayList);
        mDutiesRecyclerView.setAdapter(adapter);
        mDutiesRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        Log.i("ZOKA",""+adapter.getItemCount());


    }
}