package com.example.android.geidea.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.android.geidea.R;
import com.example.android.geidea.model.Data;
import com.example.android.geidea.model.Users;
import com.example.android.geidea.viewmodel.UsersViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private UsersRecyclerViewAdapter recyclerViewAdapter;
    private List<Data> dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

        observe(usersViewModel);

    }

    private void observe(UsersViewModel loginViewModel){

        loginViewModel.getAllUsers().observe(this, new Observer<Users>() {
            @Override
            public void onChanged(Users users) {

                if (users!=null)
                recyclerViewAdapter.updateDataSource(users.getData());
                else
                    recyclerViewAdapter.updateDataSource(null);



            }
        });
    }
}
