package com.example.android.geidea.room;

import androidx.room.Database;
import androidx.room.Entity;
import androidx.room.RoomDatabase;

import com.example.android.geidea.model.Ad;
import com.example.android.geidea.model.Data;
import com.example.android.geidea.model.Users;

@Database(entities = {Users.class,Data.class/*,Ad.class*/},version = 1)
abstract public class AppDatabase extends RoomDatabase {

    public abstract UserDao userDao();
    public abstract DataDao dataDao();
}