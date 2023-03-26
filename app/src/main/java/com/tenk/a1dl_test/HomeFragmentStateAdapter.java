package com.tenk.a1dl_test;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class HomeFragmentStateAdapter extends FragmentStateAdapter {


    public HomeFragmentStateAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        System.out.println(position);
        switch (position) {
            case 0:
                return new TestListFragment();
            case 1:
                return new SignalListFragment();
            case 2:
                return new InfoFragment();
            default:
                return null;
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
