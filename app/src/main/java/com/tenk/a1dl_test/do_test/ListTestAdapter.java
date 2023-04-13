package com.tenk.a1dl_test.do_test;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.tenk.a1dl_test.R;

import java.util.List;

public class ListTestAdapter extends BaseAdapter {
    Fragment fragment;

    public ListTestAdapter(Fragment fragment) {
        this.fragment = fragment;
    }
    @Override
    public int getCount() {
        return 8;
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        View view;
        if (convertView == null) {
            view = View.inflate(parent.getContext(), R.layout.listview_test_item, null);
        } else view = convertView;

        int testId = i + 1;
        ((TextView) view.findViewById(R.id.title)).setText(String.format("Đề số: %d", testId));


        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(fragment.getContext(), DoTestActivity.class);
                i.putExtra("testId", testId);
                fragment.getActivity().startActivity(i);
            }
        });
        return view;
    }
}
