package com.example.android.geidea.room;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.android.geidea.model.Data;
import com.example.android.geidea.model.Users;

import java.util.List;

@Dao
public interface UserDao {

    @Query("select * from users")
    Users getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Users users);

}
