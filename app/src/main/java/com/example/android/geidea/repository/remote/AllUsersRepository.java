package com.example.android.geidea.repository.remote;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.android.geidea.model.Users;
import com.example.android.geidea.rest.APIInterface;
import com.example.android.geidea.rest.RestService;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AllUsersRepository {

    private APIInterface apiInterface;
    private final MutableLiveData<Users> usersMutableLiveData = new MutableLiveData<>();

    public AllUsersRepository(){
        RestService restService = RestService.getINSTANCE();
        apiInterface = restService.getApiInterface();
    }


    public MutableLiveData<Users> getAllUsers(){

        Call<Users> usersCall = apiInterface.getAllUsers();
        usersCall.enqueue(new Callback<Users>() {
            @Override
            public void onResponse(Call<Users> call, Response<Users> response) {
                if (response.isSuccessful()){
                    usersMutableLiveData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<Users> call, Throwable t) {
                usersMutableLiveData.postValue(null);
            }
        });

        return  usersMutableLiveData;
    }







}
