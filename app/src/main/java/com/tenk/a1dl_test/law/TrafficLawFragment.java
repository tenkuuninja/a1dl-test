package com.tenk.a1dl_test.law;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.tenk.a1dl_test.DBHelper;
import com.tenk.a1dl_test.R;

import java.util.ArrayList;
import java.util.List;

public class TrafficLawFragment extends Fragment {
    View view;
    public static final String DATABASE_NAME = "a1dl-v3.db";
    DBHelper db;

    Spinner spinner;
    private ListView listView;

    ViewAdapter viewAdapter;


//    ArrayAdapter<Law> adapter;
//    ArrayList<Law>  listItem = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_traffic_law, container, false);


        listView = view.findViewById(R.id.list_law);
        DBHelper db = new DBHelper(getActivity());
        List<List<String>> data = db.getListLaw(1, 1);

        viewAdapter = new ViewAdapter(data);
        listView.setAdapter(viewAdapter);



        return view;
    }



}