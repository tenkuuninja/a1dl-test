package com.tenk.a1dl_test;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.tenk.a1dl_test.information_signal.TrafficSignalFragment;

public class HomeFragmentStateAdapter extends FragmentStateAdapter {


    public HomeFragmentStateAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new TestListFragment();
            case 1:
                return new TrafficSignalFragment();
            case 2:
                return new TrafficLawFragment();
            case 3:
                return new InfoFragment();
            default:
                return null;
        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
