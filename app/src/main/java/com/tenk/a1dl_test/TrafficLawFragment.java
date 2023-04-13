package com.tenk.a1dl_test;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class TrafficLawFragment extends Fragment {

    DBHelper db;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        db = new DBHelper(getActivity());
//        db.getListLaw(1, 1);
        return inflater.inflate(R.layout.fragment_traffic_law, container, false);
    }
}