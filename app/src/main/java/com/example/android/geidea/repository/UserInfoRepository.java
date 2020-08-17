package com.example.android.geidea.repository;

import android.app.Application;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.android.geidea.model.Data;
import com.example.android.geidea.model.UserDetails;
import com.example.android.geidea.model.Users;
import com.example.android.geidea.rest.APIInterface;
import com.example.android.geidea.rest.RestService;
import com.example.android.geidea.room.AppDatabaseClient;
import com.example.android.geidea.room.DataDao;
import com.example.android.geidea.room.UserDao;
import com.example.android.geidea.utils.CommonUtils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserInfoRepository  {

    private APIInterface apiInterface;
    private final MutableLiveData<UserDetails> userDetailsMutableLiveData = new MutableLiveData<>();
    private Context context;


    public UserInfoRepository(Application application){
        RestService restService = RestService.getINSTANCE();
        apiInterface = restService.getApiInterface();
        this.context = application;
    }

    public MutableLiveData<UserDetails> getUserById(long id){

        if(CommonUtils.isNetworkAvailable(context)){
            Call<UserDetails> usersCall = apiInterface.getUserById(id);
            usersCall.enqueue(new Callback<UserDetails>() {
                @Override
                public void onResponse(Call<UserDetails> call, Response<UserDetails> response) {
                    if (response.isSuccessful()){
                        userDetailsMutableLiveData.setValue(response.body());
                    }
                }

                @Override
                public void onFailure(Call<UserDetails> call, Throwable t) {
                    userDetailsMutableLiveData.postValue(null);
                }
            });
        }else {

            new ReadFromDbTask(context).execute(id);
        }


        return  userDetailsMutableLiveData;
    }


    public class ReadFromDbTask extends AsyncTask<Long,Void,Void> {

        private Context context;

        public ReadFromDbTask(Context context) {
            this.context = context;
         }

        @Override
        protected Void doInBackground(Long... ids) {

           DataDao dataDao = AppDatabaseClient.getInstance(context).getAppDatabase().dataDao();
           Data data =  dataDao.getDataById(ids[0].intValue());
           UserDetails userDetails = new UserDetails();
           userDetails.setData(data);
           userDetailsMutableLiveData.postValue(userDetails);
           return null;
        }
    }
}
