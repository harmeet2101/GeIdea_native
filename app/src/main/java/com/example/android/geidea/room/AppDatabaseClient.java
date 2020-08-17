package com.example.android.geidea.room;

import android.content.Context;
import androidx.room.Room;


public class AppDatabaseClient {

    private Context context;

    private AppDatabase appDatabase;

    private static AppDatabaseClient mInstance;


    private AppDatabaseClient(Context context){

        this.context = context;
        appDatabase = Room.databaseBuilder(context,AppDatabase.class, "geidiea_db").build();;
    }


    public static synchronized AppDatabaseClient getInstance(Context mCtx) {
        if (mInstance == null) {
            mInstance = new AppDatabaseClient(mCtx);
        }
        return mInstance;
    }


    public AppDatabase getAppDatabase() {
        return appDatabase;
    }
}
