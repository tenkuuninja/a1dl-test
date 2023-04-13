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


//        adapter = new ArrayAdapter<Law>(getActivity(), 0, listItem) {
//
//            public View getView(int position, View convertView, ViewGroup parent) {
//                LayoutInflater layoutInflater = (LayoutInflater) getActivity().getSystemService(getActivity().LAYOUT_INFLATER_SERVICE);
//                convertView = inflater.inflate(R.layout.data_listview, null);
//
//
//
//
//
//                TextView law_data = convertView.findViewById(R.id.law_data);
//                TextView law_data1 = convertView.findViewById(R.id.law_data1);
//
//
//                return convertView;
//            }
//        };
//        listView.setAdapter(adapter)
//      MySpinnerAdapter adapter = new MySpinnerAdapter(getActivity(), android.R.layout.simple_spinner_item, db);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        Spinner spinner = view.findViewById(R.id.spinner);
//        spinner.setAdapter(adapter);
//
//
//
//        MySpinnerAdapter adapter1 = new MySpinnerAdapter(getActivity(), android.R.layout.simple_spinner_item, db);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        Spinner spinner1 = view.findViewById(R.id.spinner1);
//        spinner.setAdapter(adapter);

        return view;
    }



}