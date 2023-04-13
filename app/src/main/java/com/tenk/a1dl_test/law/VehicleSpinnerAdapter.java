package com.tenk.a1dl_test.law;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class VehicleSpinnerAdapter extends BaseAdapter {
    Context context;
    List<String> topics;

    public VehicleSpinnerAdapter(Context context) {
        this.context = context;

        topics = new ArrayList<>();
        topics.add("Xe máy");
        topics.add("Ô tô");
        topics.add("Khác");
    }

    @Override
    public int getCount() {
        return topics.size();
    }

    @Override
    public Object getItem(int i) {
        return topics.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        TextView textView = new TextView(context);
        textView.setText(topics.get(i));

        return textView;
    }
}
