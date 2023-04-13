package com.tenk.a1dl_test;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import androidx.fragment.app.Fragment;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.button.MaterialButton;
import com.tenk.a1dl_test.do_test.Answer;
import com.tenk.a1dl_test.do_test.DoTestActivity;
import com.tenk.a1dl_test.do_test.ListTestAdapter;
import com.tenk.a1dl_test.do_test.Question;
import com.tenk.a1dl_test.information_signal.Signal_Adapter;

import java.util.ArrayList;
import java.util.List;

public class TestListFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_test_list, container, false);

        ListTestAdapter listTestAdapter = new ListTestAdapter(this);

        ListView listView = view.findViewById(R.id.t_listview);
        listView.setAdapter(listTestAdapter);

        return view;
    }
}