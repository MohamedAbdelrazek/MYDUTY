package com.WirelessDynamics.ToDoApp.roomDb;


import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.RawQuery;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface DutyDao {


    @Insert
    Long insertTask(Duty duty);


    @Query("SELECT * FROM duty ")
    List<Duty> fetchAllDuties();




    @Delete
    void deleteTask(Duty duty);

    @Query("UPDATE Duty SET isDone= :isDone WHERE dutyId = :id")
    public abstract int updateDutyState(int id, Boolean isDone);
}
