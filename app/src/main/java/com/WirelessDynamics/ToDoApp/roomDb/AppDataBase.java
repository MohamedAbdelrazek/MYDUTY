package com.WirelessDynamics.ToDoApp.roomDb;



import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {Duty.class}, version = 1, exportSchema = false)
public abstract class AppDataBase extends RoomDatabase {

    public abstract DutyDao dutyDao();
}
