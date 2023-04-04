package com.tenk.a1dl_test.do_test;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.bottomsheet.BottomSheetDragHandleView;
import com.tenk.a1dl_test.DBHelper;
import com.tenk.a1dl_test.HomeActivity;
import com.tenk.a1dl_test.HomeFragmentStateAdapter;
import com.tenk.a1dl_test.InfoFragment;
import com.tenk.a1dl_test.R;
import com.tenk.a1dl_test.TestListFragment;
import com.tenk.a1dl_test.TrafficLawFragment;
import com.tenk.a1dl_test.TrafficSignalFragment;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DoTestActivity extends AppCompatActivity {
    List<Question> questions = new ArrayList<>();
    BottomSheetDragHandleView bottomSheet;

    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_do_test);


        bottomSheet = findViewById(R.id.bottom_sheet);

        ImageView btnBack = findViewById(R.id.back_to_list);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DoTestActivity.this, HomeActivity.class);
                startActivity(i);
//                BottomSheetBehavior.from(bottomSheet).setState(BottomSheetBehavior.STATE_EXPANDED);
            }
        });

//        BottomSheetDialogFragment modalBottomSheet = new BottomSheetFragment();
//        modalBottomSheet.show(getSupportFragmentManager(), BottomSheetFragment.TAG);

//        BottomSheetBehavior standardBottomSheetBehavior = BottomSheetBehavior.from(modalBottomSheet);

//        bottomSheet.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                System.out.println(123);
//                BottomSheetBehavior.from(bottomSheet).setState(BottomSheetBehavior.STATE_EXPANDED);
//            }
//        });


        db = new DBHelper(this);

        questions =  db.getListQuestionByTestId(1);

        ViewPager2 viewPager = (ViewPager2) findViewById(R.id.test_pager);

//        viewPager.add;
        viewPager.setAdapter(new TestFragmentStateAdapter(this));

    }

    public class TestFragmentStateAdapter extends FragmentStateAdapter {


        public TestFragmentStateAdapter(@NonNull FragmentActivity fragmentActivity) {
            super(fragmentActivity);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            SingleQuestionFragment fragment = new SingleQuestionFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable("question", questions.get(position));
            fragment.setArguments(bundle);
            return fragment;
        }

        @Override
        public int getItemCount() {
            return 25;
        }
    }
}