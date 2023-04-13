package com.tenk.a1dl_test.information_signal;

import static android.content.Context.MODE_PRIVATE;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.fragment.app.Fragment;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.tenk.a1dl_test.DBHelper;
import com.tenk.a1dl_test.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class TrafficSignalFragment extends Fragment {
    View view;
    List<List<String>> listSignals;
    Signal_Adapter signal_adapter;
    ListView listSignal;
    DBHelper db;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_traffic_signal, container, false);
        db = new DBHelper(this.getContext());
        listSignals = db.getListLaw(1, 1);
        signal_adapter = new Signal_Adapter(listSignals);

        listSignal = view.findViewById(R.id.lv_signal);
        listSignal.setAdapter(signal_adapter);
        return view;
    }
}

