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

import com.tenk.a1dl_test.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class TrafficSignalFragment extends Fragment {
    ListView listView;
    ArrayList<String> arrBienBao;
    ArrayAdapter<String> adapterBB;
    //Ten CSDL
    String DB_NAME = "a1dl-v2.db ";
    private String DB_PATH ="/databases/";
    private Object myOutPut;
    private Object database;

    SQLiteDatabase database1 = null;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        xyLySaoChepCSDL();
        //Them cac Widgets
        addControls();

        showAllSignal();
        return inflater.inflate(R.layout.fragment_traffic_signal, container, false);
    }
    private void showAllSignal() {
        database = getActivity().openOrCreateDatabase(DB_NAME, MODE_PRIVATE, null);
        Cursor cursor = database1.query("signals", null, null, null, null, null, null);

        arrBienBao.clear();
        while (cursor.moveToNext()){
            int id = cursor.getInt(0);
            int topicID = cursor.getInt(1);
            String title = cursor.getString(2);
            String description = cursor.getString(3);
            arrBienBao.add(id+"-"+topicID+"-"+title+"-"+description);
        }
        cursor.close();
        adapterBB.notifyDataSetChanged();

    }


    private void xyLySaoChepCSDL() {
        File dbFile = getActivity().getDatabasePath(DB_NAME);
        if (!dbFile.exists()){
            copyDatabase();
        } else {
            dbFile.delete();
            copyDatabase();
        }
    }

    private void copyDatabase() {
        try {
            InputStream myInput = getActivity().getAssets().open(DB_NAME);
            String outFileName = getActivity().getApplicationInfo().dataDir+DB_PATH+DB_NAME;
            File f = new File(getActivity().getApplicationInfo().dataDir+DB_PATH);
            if (!f.exists()){
                f.mkdir();
            }

            OutputStream myOutPut = new FileOutputStream(outFileName);
            byte[] buffer = new byte[1024];
            int len;
            while ((len=myInput.read(buffer)) > 0){

                myOutPut.write(buffer, 0, len);
            }
            myOutPut.flush();
            myInput.close();
            myOutPut.close();

        } catch (Exception e) {
            e.printStackTrace();
            Log.e("Loi", e.toString());
        }
    }

    private void addControls() {
        listView = getView().findViewById(R.id.lv_signal);
        arrBienBao = new ArrayList<>();
        adapterBB = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_single_choice,arrBienBao);
        listView.setAdapter(adapterBB);
    }
}