package com.example.android.geidea.rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestService {

    private APIInterface apiInterface;
    private static RestService INSTANCE;

    private RestService(){

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(RestConstants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        apiInterface = retrofit.create(APIInterface.class);

    }


    public static RestService getINSTANCE() {
        if (INSTANCE==null){
            INSTANCE = new RestService();
        }
        return INSTANCE;
    }

    public APIInterface getApiInterface() {
        return apiInterface;
    }

}
