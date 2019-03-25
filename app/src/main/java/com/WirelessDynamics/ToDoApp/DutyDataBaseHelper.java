package com.WirelessDynamics.ToDoApp;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.os.AsyncTask;

import com.WirelessDynamics.ToDoApp.roomDb.AppDataBase;
import com.WirelessDynamics.ToDoApp.roomDb.Duty;

import java.util.List;
import java.util.concurrent.ExecutionException;

class DutyDataBaseHelper {

    private final AppDataBase appDataBase;

    public DutyDataBaseHelper(Context context) {
        appDataBase = Room.databaseBuilder(context, AppDataBase.class, "duties").build();

    }

    public void insertTask(final Duty duty) {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                appDataBase.dutyDao().insertTask(duty);
                return null;
            }
        }.execute();
    }

    public List<Duty> getDuties() throws ExecutionException, InterruptedException {


        return new AsyncTask<Void, Void, List<Duty>>() {
            @Override
            protected List<Duty> doInBackground(Void... voids) {

                return appDataBase.dutyDao().fetchAllDuties();
            }

        }.execute().get();

    }

    public Integer getUnDoneDutiesCount() throws ExecutionException, InterruptedException {


        return new AsyncTask<Void, Void, Integer>() {
            @Override
            protected Integer doInBackground(Void... voids) {


                return appDataBase.dutyDao().getUnDoneDutiesCount();
            }

        }.execute().get();

    }

    public void updateDutyState(final int id, final Boolean state) {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                appDataBase.dutyDao().updateDutyState(id, state);
                return null;
            }
        }.execute();


    }

}
