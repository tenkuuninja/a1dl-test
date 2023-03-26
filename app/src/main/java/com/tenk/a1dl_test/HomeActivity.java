package com.tenk.a1dl_test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ViewPager2 viewPager = (ViewPager2) findViewById(R.id.pager);

//        viewPager.add;
        viewPager.setAdapter(new HomeFragmentStateAdapter(this));
    }
}