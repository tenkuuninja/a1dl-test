package com.tenk.a1dl_test.do_test;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
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

    View view;
    Question question;
    TextView tvIndex;
    TextView tvQuestion;
    RadioGroup ansGroup;
    TextView tvExplain;
    Integer questionIndex;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_single_question, container, false);

        renderContent();

        return view;
    }

    private void renderContent() {
//        question = (Question) getArguments().getSerializable("question");
        questionIndex = getArguments().getInt("questionIndex");
        question = TestStore.getInstance().getQuestions().get(questionIndex);

        renderQuestionInfo();

    }

    private void renderQuestionInfo() {
        tvIndex =  view.findViewById(R.id.q_index);
        tvQuestion =  view.findViewById(R.id.q_text);
        ansGroup = view.findViewById(R.id.q_ans_group);
        tvExplain = view.findViewById(R.id.q_explain);

        if (TestStore.getInstance().getSubmitted() && question.getCritical()) {
            tvIndex.setText("Câu hỏi " + question.getOrder() + " (Câu điểm liệt)");
        } else {
            tvIndex.setText("Câu hỏi " + question.getOrder());
        }
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
                    rb.setTextColor(Color.parseColor("#eb4d4b"));
                    rb.setChecked(true);
                }
                if (question.getCorrectAnswerIndex() == i) {
                    rb.setTextColor(Color.parseColor("#6ab04c"));
                }
            }
            ansGroup.addView(rb);
        }

        ansGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int ansCheckedId = ansGroup.getCheckedRadioButtonId();
                int ansCheckedIndex = ansGroup.indexOfChild(view.findViewById(ansCheckedId));
                System.out.println("Question " + questionIndex + ", check answer " + ansCheckedIndex);
                TestStore.getInstance().getQuestions().get(questionIndex).setSelectionIndex(ansCheckedIndex);

            }
        });

        if (TestStore.getInstance().getSubmitted()) {
            tvExplain.setText("Giải thích: " + question.getExplain());
        } else {
            tvExplain.setText("");
        }
    }
}