package com.tenk.a1dl_test;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.button.MaterialButton;
import com.tenk.a1dl_test.do_test.Answer;
import com.tenk.a1dl_test.do_test.DoTestActivity;
import com.tenk.a1dl_test.do_test.Question;

import java.util.ArrayList;
import java.util.List;

public class TestListFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_test_list, container, false);

        MaterialButton btn = view.findViewById(R.id.btn_test_1);
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), DoTestActivity.class);
                startActivity(i);
            }
        });


        return view;
    }
}