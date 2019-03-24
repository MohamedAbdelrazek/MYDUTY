package com.WirelessDynamics.ToDoApp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NewDutyActivity extends AppCompatActivity {
    private EditText mTitle, mDesc, mDate;
    private Button mSaveButton, mCancelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_duty);
        mTitle = findViewById(R.id.duty_title_edit_txt);
        mDesc = findViewById(R.id.duty_desc_edit_txt);
        mDate = findViewById(R.id.duty_date_edit_txt);
        mSaveButton = findViewById(R.id.save_btn);
        mCancelButton = findViewById(R.id.cancel_btn);
        mCancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String title = mTitle.getText().toString();
                String description = mDesc.getText().toString();
                String date = mDesc.getText().toString();
                if (TextUtils.isEmpty(title)) {

                    Toast.makeText(NewDutyActivity.this, "Title can't be empty !", Toast.LENGTH_SHORT).show();
                } else {
                    //start adding to DB
                    Toast.makeText(NewDutyActivity.this, "added to db", Toast.LENGTH_SHORT).show();
                    Intent mainIntent = new Intent(getApplicationContext(), MainActivity.class);
                    mainIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(mainIntent);
                    finish();
                }


            }
        });
    }
}