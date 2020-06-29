package com.example.livedataexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    FirstFragmnet firstFragmnet = new FirstFragmnet();
    SecondFragment secondFragment = new SecondFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstFragmnet.getStringMLiveData().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                secondFragment.setTextChange(s);
            }
        });

        secondFragment.getStringLiveData().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                firstFragmnet.setTextChange(s);
            }
        });

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.firstframe, firstFragmnet).addToBackStack(null);
        transaction.replace(R.id.secondframe, secondFragment).addToBackStack(null);
        transaction.commit();
    }
}