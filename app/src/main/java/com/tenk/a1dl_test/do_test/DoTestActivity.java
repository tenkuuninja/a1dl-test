package com.tenk.a1dl_test.do_test;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDragHandleView;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.tenk.a1dl_test.DBHelper;
import com.tenk.a1dl_test.R;

import java.util.List;

public class DoTestActivity extends AppCompatActivity {
    BottomSheetDragHandleView bottomSheet;
    ViewPager2 viewPager;

    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_do_test);


        bottomSheet = findViewById(R.id.bottom_sheet);
        TestStore.getInstance().setSubmitted(false);

        ImageView btnBack = findViewById(R.id.back_to_list);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent i = new Intent(DoTestActivity.this, HomeActivity.class);
//                startActivity(i);
                finish();
            }
        });

        TextView submit = findViewById(R.id.submit_test);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showConfirmSubmitDialog();
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
        List<Question> questions =  db.getListQuestionByTestId(1);
        TestStore.getInstance().setQuestions(questions);

        viewPager = (ViewPager2) findViewById(R.id.test_pager);
        viewPager.setAdapter(new TestFragmentStateAdapter(this));
        viewPager.setMinimumHeight(600);

    }

    private void showConfirmSubmitDialog() {
        new MaterialAlertDialogBuilder(DoTestActivity.this)
            .setTitle("Xác nhận nộp")
            .setMessage("Bạn có muốn nộp không?")
            .setNegativeButton(R.string.app_name, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {

                }
            })
            .setPositiveButton(R.string.app_name, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    showResultDialog();
                }
            })
            .show();
    }

    private void showResultDialog() {
        int points = 0;
        String title = "";
        String message = "";
        boolean isFailByCritical = false;
        for (Question q : TestStore.getInstance().getQuestions()) {
            if (q.getSelectionIndex() == q.getCorrectAnswerIndex()) {
                points++;
            } else if (q.getCritical()) {
                isFailByCritical = true;
                break;
            }
        }
        if (isFailByCritical) {
            title = "Không đạt";
            message = "Bạn không đạt do sai câu điểm liệt";
        } else if (points < 21) {
            title = "Không đạt";
            message = "Bạn không đạt do không đủ điểm\nĐiểm của bạn là " + points + "/25\nBạn cần tối thiểu 21 điểm";
        } else {
            title = "Đạt";
            message = "Bạn đã vượt qua bài thi";
        }
        new MaterialAlertDialogBuilder(DoTestActivity.this)
            .setTitle(title)
            .setMessage(message)
            .setNegativeButton(R.string.app_name, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    TestStore.getInstance().setSubmitted(true);
                    int currentPage = viewPager.getCurrentItem();
                    viewPager.setAdapter(new TestFragmentStateAdapter(DoTestActivity.this));
                    viewPager.setCurrentItem(currentPage, false);
                }
            })
            .setPositiveButton(R.string.app_name, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    finish();
                }
            })
            .show();
    }

    public class TestFragmentStateAdapter extends FragmentStateAdapter {

        public TestFragmentStateAdapter(@NonNull FragmentActivity fragmentActivity) {
            super(fragmentActivity);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            List<Question> questions = TestStore.getInstance().getQuestions();
            SingleQuestionFragment fragment = new SingleQuestionFragment();
            Bundle bundle = new Bundle();
//            bundle.putSerializable("question", questions.get(position));
            bundle.putInt("questionIndex", position);
            fragment.setArguments(bundle);
            return fragment;
        }

        @Override
        public int getItemCount() {
            return 25;
        }
    }
}