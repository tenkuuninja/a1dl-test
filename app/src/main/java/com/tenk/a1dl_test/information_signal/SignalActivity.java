package com.tenk.a1dl_test.information_signal;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.tenk.a1dl_test.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class SignalActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<String> arrBienBao;
    ArrayAdapter<String> adapterBB;
    //Ten CSDL
    String DB_NAME = "a1dl-v2.db ";
    private String DB_PATH ="/databases/";
    private Object myOutPut;
    private Object database;

    SQLiteDatabase database1 = null;
    @Override
    protected void onCreate (Bundle saveInstanceState) {

        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_signal);

        xyLySaoChepCSDL();
        //Them cac Widgets
        addControls();

        showAllSignal();
    }

    private void showAllSignal() {
        database = openOrCreateDatabase(DB_NAME, MODE_PRIVATE, null);
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
        File dbFile = getDatabasePath(DB_NAME);
        if (!dbFile.exists()){
            copyDatabase();
        } else {
            dbFile.delete();
            copyDatabase();
        }
    }

    private void copyDatabase() {
        try {
            InputStream myInput = getAssets().open(DB_NAME);
            String outFileName = getApplicationInfo().dataDir+DB_PATH+DB_NAME;
            File f = new File(getApplicationInfo().dataDir+DB_PATH);
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
        listView = findViewById(R.id.lv_signal);
        arrBienBao = new ArrayList<>();
        adapterBB = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice,arrBienBao);
        listView.setAdapter(adapterBB);
    }
}
