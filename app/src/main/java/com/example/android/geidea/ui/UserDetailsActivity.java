package com.example.android.geidea.ui;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.android.geidea.R;
import com.example.android.geidea.model.UserDetails;
import com.example.android.geidea.viewmodel.UserDetailViewModel;

public class UserDetailsActivity extends AppCompatActivity {

    private TextView idTextview;
    private TextView counterTextview;
    private TextView firstNameTextview;
    private TextView lastNameTextview;

    private int counter = 5 ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_screen);

        idTextview = (TextView)findViewById(R.id.idTextview);
        counterTextview = (TextView)findViewById(R.id.countTextview);
        firstNameTextview = (TextView)findViewById(R.id.fnTextview);
        lastNameTextview = (TextView)findViewById(R.id.lnTextview);

        final UserDetailViewModel userDetailViewModel = ViewModelProvider.AndroidViewModelFactory.
                getInstance(getApplication()).create(UserDetailViewModel.class);


        Bundle bundle = getIntent().getExtras();
        if (bundle!=null){

            long userId = bundle.getLong("id");

            observe(userDetailViewModel,userId);
        }

        new CountDownTimer(5000, 1000) {

            public void onTick(long millisUntilFinished) {

                counterTextview.setText("Counter: "+counter);
                counter--;
            }

            public void onFinish() {
                finish();
            }
        }.start();
    }



    private void observe(UserDetailViewModel userDetailViewModel,Long id){

        userDetailViewModel.getUserById(id).observe(this, new Observer<UserDetails>() {
            @Override
            public void onChanged(UserDetails userDetails) {

               idTextview.setText(idTextview.getText().toString()+""+userDetails.getData().getId());
               firstNameTextview.setText(firstNameTextview.getText().toString()+""+userDetails.getData().getFirstName());
               lastNameTextview.setText(lastNameTextview.getText().toString()+""+userDetails.getData().getEmail());
            }
        });
    }


}
