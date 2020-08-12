package com.example.android.geidea.repository.remote;

import android.util.Log;

import com.example.android.geidea.model.UserDetails;
import com.example.android.geidea.rest.RestService;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserInfoRepository implements Callback<UserDetails> {


    public void start(){
        RestService restService = RestService.getINSTANCE();
        restService.getApiInterface().getUserById(3).enqueue(this);
    }

    @Override
    public void onResponse(Call<UserDetails> call, Response<UserDetails> response) {
        if(response.isSuccessful()) {
            UserDetails changesList = response.body();
            Log.d("resp",changesList.toString());
        } else {
            try {
                Log.d("resp",response.errorBody().string());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onFailure(Call<UserDetails> call, Throwable t) {
        t.printStackTrace();
    }
}
