package com.tenk.a1dl_test.law;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class TopicSpinnerAdapter extends BaseAdapter {
    Context context;
    List<String> topics;

    public TopicSpinnerAdapter(Context context) {
        this.context = context;

        topics = new ArrayList<>();
        topics.add("Hiệu lệnh, chỉ dẫn");
        topics.add("Chuyển hướng, nhường đường");
        topics.add("Dừng xe, đỗ xe");
        topics.add("Thiết bị ưu tiên, còi");
        topics.add("Tốc độ, khoảng cách an toàn");
        topics.add("Vận chuyển người, hàng hoá");
        topics.add("Trang thiết bị phương tiện");
        topics.add("Đường cấm, đường một chiều");
        topics.add("Nồng độ cồn, chất kích thích");
        topics.add("Giấy tờ xe");
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
