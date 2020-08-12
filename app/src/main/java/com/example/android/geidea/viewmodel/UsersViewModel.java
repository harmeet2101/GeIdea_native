package com.example.android.geidea.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.android.geidea.model.Users;
import com.example.android.geidea.repository.remote.AllUsersRepository;

public class UsersViewModel extends AndroidViewModel {

    private MutableLiveData<Users> usersMutableLiveData;
    private AllUsersRepository allUsersRepository;

    public UsersViewModel(@NonNull Application application) {
        super(application);
        usersMutableLiveData = new MutableLiveData<>();
        allUsersRepository = new AllUsersRepository();
    }

    public LiveData<Users> getAllUsers(){

        usersMutableLiveData = allUsersRepository.getAllUsers();
        return usersMutableLiveData;
    }


}
