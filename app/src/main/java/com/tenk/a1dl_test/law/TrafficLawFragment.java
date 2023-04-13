package com.tenk.a1dl_test.law;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.tenk.a1dl_test.DBHelper;
import com.tenk.a1dl_test.R;
import com.tenk.a1dl_test.information_signal.Signal_Adapter;
import com.tenk.a1dl_test.information_signal.SpinnerAdapter;

import java.util.ArrayList;
import java.util.List;

public class TrafficLawFragment extends Fragment {
    View view;
    public static final String DATABASE_NAME = "a1dl-v3.db";
    DBHelper db;

    Spinner spinner;
    private ListView listView;

    ViewAdapter viewAdapter;

    Integer topicId = 1;
    Integer vehId = 1;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_traffic_law, container, false);

        Spinner topicSpinner = view.findViewById(R.id.spinner);
        TopicSpinnerAdapter topicSpinnerAdapter = new TopicSpinnerAdapter(this.getContext());
        topicSpinner.setAdapter(topicSpinnerAdapter);
        topicSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                topicId = i + 1;
                loadData();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                System.out.println("Nothing");
            }
        });
        topicSpinner.setSelection(0);

        Spinner vehSpinner = view.findViewById(R.id.spinner1);
        VehicleSpinnerAdapter vehicleSpinnerAdapter = new VehicleSpinnerAdapter(this.getContext());
        vehSpinner.setAdapter(vehicleSpinnerAdapter);
        vehSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                vehId = i + 1;
                loadData();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                System.out.println("Nothing");
            }
        });
        vehSpinner.setSelection(0);

        db = new DBHelper(getActivity());

        return view;
    }

    private void loadData() {
        List<List<String>> data = db.getListLaw(topicId, vehId);
        viewAdapter = new ViewAdapter(data);
        listView = view.findViewById(R.id.list_law);
        listView.setAdapter(viewAdapter);
    }



}