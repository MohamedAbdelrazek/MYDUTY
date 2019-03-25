package com.WirelessDynamics.ToDoApp;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.WirelessDynamics.ToDoApp.roomDb.Duty;
import com.facebook.stetho.Stetho;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Duty> myDutyModelArrayList;
    private Notification mNotification;
    private NotificationManager mNotifiManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Stetho.initializeWithDefaults(this);
        RecyclerView mDutiesRecyclerView = findViewById(R.id.duties_recycler_view);
        Button mNewDutyButton = findViewById(R.id.add_new_duty_btn);
        DutyDataBaseHelper mDutyDataBaseHelper = new DutyDataBaseHelper(this);
        mNewDutyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), NewDutyActivity.class));
            }
        });



        try {
            myDutyModelArrayList = (ArrayList<Duty>) mDutyDataBaseHelper.getDuties();

        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        MyDutyAdapter mAdapter = new MyDutyAdapter(MainActivity.this, myDutyModelArrayList);
        mDutiesRecyclerView.setAdapter(mAdapter);
        mDutiesRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        try {
            Integer n = mDutyDataBaseHelper.getUnDoneDutiesCount();
            Toast.makeText(this, "The number of un done items is " + n, Toast.LENGTH_SHORT).show();

            if (n > 0) {
                createNotification("You have " + n + " un done Tasks", this);
            } else {
                createNotification("Great Job, You have nothing to do :) ", this);

            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }


    private void createNotification(String aMessage, Context context) {


        String id = context.getString(R.string.channel_id); // default_channel_id
        String title = context.getString(R.string.channel_name); // Default Channel
        Intent intent;
        PendingIntent pendingIntent;
        NotificationCompat.Builder builder;
        if (mNotifiManager == null) {
            mNotifiManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel mChannel = mNotifiManager.getNotificationChannel(id);
            if (mChannel == null) {
                mChannel = new NotificationChannel(id, title, importance);
                mChannel.enableVibration(true);
                mChannel.setVibrationPattern(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400});
                mNotifiManager.createNotificationChannel(mChannel);
            }
            builder = new NotificationCompat.Builder(context, id);
            intent = new Intent(context, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);
            builder.setContentTitle(aMessage)                            // required
                    .setSmallIcon(R.drawable.ic_lan2)   // required
                    .setContentText(context.getString(R.string.app_name)) // required
                    .setDefaults(Notification.DEFAULT_ALL)
                    .setAutoCancel(true)
                    .setContentIntent(pendingIntent)
                    .setTicker(aMessage)
                    .setVibrate(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400});
        } else {
            builder = new NotificationCompat.Builder(context, id);
            intent = new Intent(context, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);
            builder.setContentTitle(aMessage)                            // required
                    .setSmallIcon(R.drawable.ic_lan2)   // required
                    .setContentText(context.getString(R.string.app_name)) // required
                    .setDefaults(Notification.DEFAULT_ALL)
                    .setAutoCancel(true)
                    .setContentIntent(pendingIntent)
                    .setTicker(aMessage)
                    .setVibrate(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400})
                    .setPriority(Notification.PRIORITY_HIGH)
                    .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION));
        }
        mNotification = builder.build();

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

        int NOTIFY_ID = 0;
        mNotifiManager.notify(NOTIFY_ID, mNotification);

    }
}