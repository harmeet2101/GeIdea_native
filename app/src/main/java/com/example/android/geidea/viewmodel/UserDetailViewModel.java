package com.example.android.geidea.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.android.geidea.model.UserDetails;
import com.example.android.geidea.repository.UserInfoRepository;

public class UserDetailViewModel extends AndroidViewModel {

    private MutableLiveData<UserDetails> userDetailsMutableLiveData;
    private UserInfoRepository userInfoRepository;


    public UserDetailViewModel(@NonNull Application application) {
        super(application);
        userDetailsMutableLiveData = new MutableLiveData<>();
        userInfoRepository = new UserInfoRepository(application);
    }


    public LiveData<UserDetails> getUserById(long id){

        userDetailsMutableLiveData = userInfoRepository.getUserById(id);
        return userDetailsMutableLiveData;
    }
}
