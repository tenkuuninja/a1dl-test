package com.tenk.a1dl_test;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.fragment.app.Fragment;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentTransaction;

public class TrafficLawFragment extends Fragment {
    View view;
    Spinner spinner;

    FragmentOne fragmentOne;
    FragmentTwo fragmentTwo;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_traffic_law, container, false);

        spinner = view.findViewById(R.id.spinner);
        fragmentOne = new FragmentOne();
        fragmentTwo = new FragmentTwo();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(),
                R.layout.custom_spinner,
                getResources().getStringArray(R.array.fragments));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        setFragment(fragmentOne);
                        break;
                    case 1:
                        setFragment(fragmentTwo);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        return view;
    }
    public void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_frame, fragment);
        fragmentTransaction.commit();

    }
}