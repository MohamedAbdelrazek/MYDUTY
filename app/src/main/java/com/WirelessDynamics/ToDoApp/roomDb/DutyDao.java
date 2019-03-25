package com.WirelessDynamics.ToDoApp.roomDb;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface DutyDao {


    @Insert
    void insertTask(Duty duty);


    @Query("SELECT * FROM duty ")
    List<Duty> fetchAllDuties();

    @Query("SELECT COUNT(dutyId) FROM duty where isDone=0")
    int getUnDoneDutiesCount();



    @Query("UPDATE Duty SET isDone= :isDone WHERE dutyId = :id")
    void updateDutyState(int id, Boolean isDone);
}
