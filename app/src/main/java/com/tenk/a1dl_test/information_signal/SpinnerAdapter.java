package com.tenk.a1dl_test.information_signal;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SpinnerAdapter extends BaseAdapter {
    Context context;
    List<String> topics;

    public SpinnerAdapter(Context context) {
        this.context = context;

        topics = new ArrayList<>();
        topics.add("Biển báo cấm");
        topics.add("Biển hiệu lệnh");
        topics.add("Biển chỉ dẫn");
        topics.add("Biển báo nguy hiểm và cảnh báo");
        topics.add("Biển phụ");

    }

    @Override
    public int getCount() {
        return 5;
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
