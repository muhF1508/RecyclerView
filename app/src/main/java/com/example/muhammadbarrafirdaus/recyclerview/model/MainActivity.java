package com.example.muhammadbarrafirdaus.recyclerview.model;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.muhammadbarrafirdaus.recyclerview.R;
import com.example.muhammadbarrafirdaus.recyclerview.fragments.MemberFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fragment fragment = getSupportFragmentManager().findFragmentById(android.R.id.content);
        if(fragment == null){
            fragment = MemberFragment.newInstance();
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(android.R.id.content, fragment, "")
                    .commit();
        } else {
            getSupportFragmentManager()
                    .beginTransaction()
                    .attach(fragment)
                    .commit();
        }
    }
}
