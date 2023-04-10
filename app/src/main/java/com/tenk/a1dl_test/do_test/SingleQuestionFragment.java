package com.tenk.a1dl_test.do_test;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.fragment.app.Fragment;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.google.android.material.radiobutton.MaterialRadioButton;
import com.tenk.a1dl_test.R;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class SingleQuestionFragment extends Fragment {

    Question question;
    TextView tvIndex;
    TextView tvQuestion;
    RadioGroup ansGroup;
    TextView tvExplain;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_single_question, container, false);

//        question = (Question) getArguments().getSerializable("question");
        Integer qIndex = getArguments().getInt("questionIndex");
        question = TestStore.getInstance().getQuestions().get(qIndex);

        tvIndex =  view.findViewById(R.id.q_index);
        tvQuestion =  view.findViewById(R.id.q_text);
        ansGroup = view.findViewById(R.id.q_ans_group);
        tvExplain = view.findViewById(R.id.q_explain);

        tvIndex.setText("Câu hỏi " + question.getOrder());
        tvQuestion.setText(question.getText());

        if (question.getImage().length() != 0) {
            ImageView imageView = view.findViewById(R.id.q_image);
            imageView.setMinimumHeight(500);
            Glide.with(this).load(question.getImage()).into(imageView);
        }

        for (int i = 0; i < question.getAnswers().size(); i++) {
            MaterialRadioButton rb = new MaterialRadioButton(getActivity());
            rb.setText(question.getAnswers().get(i).getText());
            if (TestStore.getInstance().getSubmitted()) {
                rb.setEnabled(false);
                if (question.getSelectionIndex() == i) {
                    rb.setTextColor(Color.parseColor("#dddddd"));
                    rb.setChecked(true);
                }
                if (question.getCorrectAnswerIndex() == i) {
                    rb.setTextColor(Color.parseColor("#33dddd"));
                }
            }
            ansGroup.addView(rb);
        }

        ansGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int ansCheckedId = ansGroup.getCheckedRadioButtonId();
                int ansCheckedIndex = ansGroup.indexOfChild(view.findViewById(ansCheckedId));
                System.out.println("Question " + qIndex + ", check answer " + ansCheckedIndex);
                TestStore.getInstance().getQuestions().get(qIndex).setSelectionIndex(ansCheckedIndex);

            }
        });

        if (TestStore.getInstance().getSubmitted()) {
            tvExplain.setText(question.getExplain());
        } else {
            tvExplain.setText("");
        }

        return view;
    }
}