package com.example.android.geidea.rest;

import com.example.android.geidea.model.UserDetails;
import com.example.android.geidea.model.Users;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface APIInterface {

    @GET(RestConstants.USERS_END_POINT)
    Call<Users> getAllUsers();

    @GET(RestConstants.USER_INFO_END_POINT)
    Call<UserDetails> getUserById(@Path("id") long id);
}
