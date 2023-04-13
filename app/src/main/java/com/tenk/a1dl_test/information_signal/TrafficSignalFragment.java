package com.tenk.a1dl_test.information_signal;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.fragment.app.Fragment;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.tenk.a1dl_test.DBHelper;
import com.tenk.a1dl_test.R;

import java.util.List;

public class TrafficSignalFragment extends Fragment {
    View view;
    List<List<String>> listSignals;
    Signal_Adapter signal_adapter;
    ListView listSignal;
    DBHelper db;

    Integer topicId;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_traffic_signal, container, false);

        SpinnerAdapter spinnerAdapter = new SpinnerAdapter(this.getContext());
        Spinner spinner = view.findViewById(R.id.spn_topicId);
//        spinner.setDropDownVerticalOffset(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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
        spinner.setSelection(0);

        db = new DBHelper(this.getContext());

        return view;

    }

    private void loadData() {
        listSignals = db.getListSignal(topicId);
        signal_adapter = new Signal_Adapter(listSignals);
        listSignal = view.findViewById(R.id.lv_signal);
        listSignal.setAdapter(signal_adapter);
    }
}

