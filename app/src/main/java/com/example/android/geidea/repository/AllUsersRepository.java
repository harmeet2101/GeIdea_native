package com.example.android.geidea.repository;

import android.app.Application;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.android.geidea.model.Users;
import com.example.android.geidea.rest.APIInterface;
import com.example.android.geidea.rest.RestService;
import com.example.android.geidea.room.AppDatabaseClient;
import com.example.android.geidea.room.UserDao;
import com.example.android.geidea.room.UserInsertionTask;
import com.example.android.geidea.utils.CommonUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AllUsersRepository {

    private APIInterface apiInterface;
    private final MutableLiveData<Users> usersMutableLiveData = new MutableLiveData<>();
    private Context context;

    public AllUsersRepository(Application application){
        RestService restService = RestService.getINSTANCE();
        apiInterface = restService.getApiInterface();
        this.context = application;
    }


    public MutableLiveData<Users> getAllUsers(){


        if(CommonUtils.isNetworkAvailable(context)){
            Call<Users> usersCall = apiInterface.getAllUsers();
            usersCall.enqueue(new Callback<Users>() {
                                  @Override
                                  public void onResponse(Call<Users> call, Response<Users> response) {
                                      if (response.isSuccessful()){
                                          usersMutableLiveData.setValue(response.body());
                                          new UserInsertionTask(context).execute(response.body());
                                      }
                                  }

                                  @Override
                                  public void onFailure(Call<Users> call, Throwable t) {
                                      usersMutableLiveData.postValue(null);
                                  }
                              }

            );
        }else {
            new ReadFromDbTask(context).execute();
        }


        return  usersMutableLiveData;
    }


    public void updateUsersData(Users user){
        this.usersMutableLiveData.postValue(user);
    }



    public class ReadFromDbTask extends AsyncTask<Void,Void,Void> {

        private Context context;

        public ReadFromDbTask(Context context) {
            this.context = context;

        }

        @Override
        protected Void doInBackground(Void... voids) {

            UserDao userDao = AppDatabaseClient.getInstance(context).getAppDatabase().
                    userDao();

            Users data =  userDao.getAll();
            updateUsersData(data);
            return null;
        }
    }
}
