package com.tenk.a1dl_test.law;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.tenk.a1dl_test.R;

import java.util.List;

public class ViewAdapter extends BaseAdapter {
    final private List<List<String>> data;

    public ViewAdapter(List<List<String>> data) {
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View viewLaw;
        if (convertView == null) {
            viewLaw= View.inflate(parent.getContext(), R.layout.data_listview, null);
        } else viewLaw = convertView;

        //Bind sữ liệu phần tử vào View
        List<String> item = (List<String>) getItem(position);
        ((TextView) viewLaw.findViewById(R.id.law_data)).setText(String.format("Hành vi %s:", item.get(0)));
        ((TextView) viewLaw.findViewById(R.id.law_data1)).setText(String.format("Đối tượng %s:", item.get(1)));
        ((TextView) viewLaw.findViewById(R.id.law_data2)).setText(String.format("Hình phạt %s:", item.get(2)));
        ((TextView) viewLaw.findViewById(R.id.law_data3)).setText(String.format("Hình phạt bổ sung %s:", item.get(3)));
        ((TextView) viewLaw.findViewById(R.id.law_data4)).setText(String.format("Khắc phục hậu quả %s:", item.get(4)));
        ((TextView) viewLaw.findViewById(R.id.law_data5)).setText(String.format("Ghi chú %s:", item.get(5)));

        return viewLaw;
    }
}


