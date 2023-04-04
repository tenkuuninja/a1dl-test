package com.tenk.a1dl_test.do_test;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_single_question, container, false);

        Question question = (Question) getArguments().getSerializable("question");

        TextView tvIndex =  view.findViewById(R.id.q_index);
        tvIndex.setText("Câu hỏi " + question.getOrder());

        TextView tvQuestion =  view.findViewById(R.id.q_text);
        tvQuestion.setText(question.getText());

        RadioGroup ansGroup = view.findViewById(R.id.q_ans_group);

        for (int i = 0; i < question.getAnswers().size(); i++) {
            MaterialRadioButton rb = new MaterialRadioButton(getActivity());
            rb.setText(question.getAnswers().get(i).getText());
            ansGroup.addView(rb);
        }

        if (question.getImage().length() != 0) {
            ImageView imageView = view.findViewById(R.id.q_image);
            imageView.setMinimumHeight(500);
            Glide.with(this).load(question.getImage()).into(imageView);
        }

        return view;
    }
}