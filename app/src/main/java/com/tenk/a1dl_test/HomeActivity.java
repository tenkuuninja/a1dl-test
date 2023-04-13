package com.tenk.a1dl_test;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ViewPager2 viewPager = (ViewPager2) findViewById(R.id.pager);
        NavigationBarView navigationBar = findViewById(R.id.bottom_navigation);

//        viewPager.add;
        viewPager.setAdapter(new HomeFragmentStateAdapter(this));

        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                switch (position) {
                    case 0:
                        navigationBar.setSelectedItemId(R.id.pager_1);
                        break;
                    case 1:
                        navigationBar.setSelectedItemId(R.id.pager_2);
                        break;
                    case 2:
                        navigationBar.setSelectedItemId(R.id.pager_3);
                        break;
                    case 3:
                        navigationBar.setSelectedItemId(R.id.pager_4);
                        break;

                }
            }
        });

        navigationBar.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.pager_1:
                        viewPager.setCurrentItem(0);
                        return true;
                    case R.id.pager_2:
                        viewPager.setCurrentItem(1);
                        return true;
                    case R.id.pager_3:
                        viewPager.setCurrentItem(2);
                        return true;
                    case R.id.pager_4:
                        viewPager.setCurrentItem(3);
                        return true;
                }
                return false;
            }
        });

    }
}