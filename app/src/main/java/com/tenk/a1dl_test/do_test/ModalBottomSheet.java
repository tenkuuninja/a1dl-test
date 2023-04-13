package com.tenk.a1dl_test.do_test;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.button.MaterialButton;
import com.tenk.a1dl_test.R;

import java.util.List;

public class ModalBottomSheet extends BottomSheetDialogFragment {
    View view;
    private OnClickListener mListener;

    public interface OnClickListener {
        void onClick(Integer position);
    }

    public void setListener(OnClickListener listener) {
        mListener = listener;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_modal_bottom_sheet, container, false);

        GridLayout gridLayout = view.findViewById(R.id.bottom_sheet_grid);
        List<Question> questions = TestStore.getInstance().getQuestions();
        for (int i = 0; i< questions.size(); i++) {
            Question q = questions.get(i);
            MaterialButton btn = new MaterialButton(view.getContext());
            btn.setText(String.valueOf(i + 1));
            int finalI = i;
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mListener != null) {
                        mListener.onClick(finalI);
                    }
                }
            });
            gridLayout.addView(btn);
        }

        return view;
    }
}