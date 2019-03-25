package com.WirelessDynamics.ToDoApp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.WirelessDynamics.ToDoApp.roomDb.Duty;

public class NewDutyActivity extends AppCompatActivity {
    private EditText mTitle, mDesc, mDate;
    private DutyDataBaseHelper mDutyDataBaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_duty);
        mTitle = findViewById(R.id.duty_title_edit_txt);
        mDesc = findViewById(R.id.duty_desc_edit_txt);
        mDate = findViewById(R.id.duty_date_edit_txt);
        Button mSaveButton = findViewById(R.id.save_btn);
        Button mCancelButton = findViewById(R.id.cancel_btn);
        mDutyDataBaseHelper = new DutyDataBaseHelper(this);
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
                String date = mDate.getText().toString();
                if (TextUtils.isEmpty(title)) {

                    Toast.makeText(NewDutyActivity.this, "Title can't be empty !", Toast.LENGTH_SHORT).show();
                } else {
                    //start adding to the room DataBase ...
                    final Duty duty = new Duty();
                    duty.setDutyDate(date);
                    duty.setDutyDesc(description);
                    duty.setDutyTitle(title);
                    duty.setDone(false);
                    mDutyDataBaseHelper.insertTask(duty);

                    Toast.makeText(NewDutyActivity.this, "Successfully added", Toast.LENGTH_SHORT).show();
                    Intent mainIntent = new Intent(getApplicationContext(), MainActivity.class);
                    mainIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(mainIntent);
                    finish();
                }


            }
        });
    }
}
