package com.tenk.a1dl_test.information_signal;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.tenk.a1dl_test.R;

import java.util.ArrayList;
import java.util.List;

public class Signal_Adapter extends BaseAdapter {
    final List<List<String>> listSignals;

    Signal_Adapter(List<List<String>> listSignals) {
        this.listSignals = listSignals;
    }

    @Override
    public int getCount() {
        return listSignals.size();
    }

    @Override
    public Object getItem(int i) {
        return listSignals.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        View viewSignal;
        if (convertView == null) {
            viewSignal = View.inflate(parent.getContext(), R.layout.listview_signals, null);
        } else viewSignal = convertView;


        List<String> signal = (List<String>) getItem(i);
        ((TextView) viewSignal.findViewById(R.id.id)).setText(String.format("ID = %s", signal.get(0)));
        ((TextView) viewSignal.findViewById(R.id.topicId)).setText(String.format("Tên biển báo: %s", signal.get(1)));
        ((TextView) viewSignal.findViewById(R.id.title)).setText(String.format("Nội dung biển báo: %s", signal.get(2)));
//        ((TextView) viewSignal.findViewById(R.id.descripton)).setText(String.format("Giá %s", signal.get(3)));
        return viewSignal;
    }
}
