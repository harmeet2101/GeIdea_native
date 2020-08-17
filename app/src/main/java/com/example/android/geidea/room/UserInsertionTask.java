package com.example.android.geidea.room;

import android.content.Context;
import android.os.AsyncTask;

import com.example.android.geidea.model.Data;
import com.example.android.geidea.model.Users;

public class UserInsertionTask extends AsyncTask<Users,Void,Void> {

    private Context context;

    public UserInsertionTask(Context context){
        this.context = context;
    }

    @Override
    protected Void doInBackground(Users... users) {

        UserDao userDao = AppDatabaseClient.getInstance(context).
                getAppDatabase().userDao();
        userDao.insert(users[0]);

        DataDao dataDao = AppDatabaseClient.getInstance(context).getAppDatabase().dataDao();
        dataDao.addAll(users[0].getData());
        return null;
    }
}
