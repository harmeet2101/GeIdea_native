package com.example.android.geidea.room;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.android.geidea.model.Data;

import java.util.List;

@Dao
public interface DataDao {

    @Query("select * from data where id=:userId")
    Data getDataById(int userId);

    @Query("select * from data")
    List<Data> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addAll(List<Data> data);
}
