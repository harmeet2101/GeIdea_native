package com.example.android.geidea.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.android.geidea.R;
import com.example.android.geidea.model.Data;
import com.example.android.geidea.model.Users;
import com.example.android.geidea.repository.remote.AllUsersRepository;
import com.example.android.geidea.repository.remote.UserInfoRepository;
import com.example.android.geidea.viewmodel.UsersViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button btn1;
    private RecyclerView recyclerView;
    private UsersRecyclerViewAdapter recyclerViewAdapter;
    private List<Data> dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = (Button)findViewById(R.id.btn1);

        recyclerView = (RecyclerView)findViewById(R.id.recyclerview);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this,
                RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);

        CustomDividerItemDecoration itemDecor = new CustomDividerItemDecoration(MainActivity.this);
        recyclerView.addItemDecoration(itemDecor);

        recyclerViewAdapter = new UsersRecyclerViewAdapter(this,dataList);
        recyclerView.setAdapter(recyclerViewAdapter);


        final UsersViewModel usersViewModel = ViewModelProvider.AndroidViewModelFactory.
                getInstance(getApplication()).create(UsersViewModel.class);




        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                observe(usersViewModel);
            }
        });





    }

    private void observe(UsersViewModel loginViewModel){

        loginViewModel.getAllUsers().observe(this, new Observer<Users>() {
            @Override
            public void onChanged(Users users) {

                  recyclerViewAdapter.updateDataSource(users.getData());
            }
        });
    }
}
