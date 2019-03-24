package com.WirelessDynamics.ToDoApp;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mPageTitleTxtView, mSupTitleTxtView, mEndOfPageTxtView;
    private RecyclerView mDutiesRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPageTitleTxtView = findViewById(R.id.app_title_txt_view);
        mSupTitleTxtView = findViewById(R.id.sub_title_txt_view);
        mEndOfPageTxtView = findViewById(R.id.end_of_duties_txt_view);
        mDutiesRecyclerView = findViewById(R.id.duties_recycler_view);

    }
}