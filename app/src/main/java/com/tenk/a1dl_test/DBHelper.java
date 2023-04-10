package com.tenk.a1dl_test;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;
import com.tenk.a1dl_test.do_test.Answer;
import com.tenk.a1dl_test.do_test.Question;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DBHelper extends SQLiteAssetHelper {
    public static final String DATABASE_NAME = "a1dl-v2.db";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME , null, 1);
    }

    @SuppressLint("Range")
    public List<Question> getListQuestionByTestId(Integer testId) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from questions where testId = " + testId, null );
        res.moveToFirst();
        List<Question> questions = new ArrayList<>();
        while(res.isAfterLast() == false){
            Question question = new Question();
            question.setId(res.getInt(res.getColumnIndex("id")));
            question.setOrder(res.getInt(res.getColumnIndex("order")));
            question.setText(res.getString(res.getColumnIndex("text")));
            question.setImage(res.getString(res.getColumnIndex("image")));
            question.setCritical(res.getInt(res.getColumnIndex("critical")) == 1);
            question.setExplain(res.getString(res.getColumnIndex("explain")));

            Cursor ansRes =  db.rawQuery( "select * from answers where questionId = " + question.getId(), null );
            ansRes.moveToFirst();
            List<Answer> answers = new ArrayList<>();

            int ansIndex = 0;
            while(ansRes.isAfterLast() == false) {
                Answer answer = new Answer();
                answer.setId(ansRes.getInt(ansRes.getColumnIndex("id")));
                answer.setText(ansRes.getString(ansRes.getColumnIndex("text")));
                answer.setCorrect(ansRes.getInt(ansRes.getColumnIndex("correct")) == 1 ? true : false);
                if (answer.getCorrect()) {
                    question.setCorrectAnswerIndex(ansIndex);
                }
                answers.add(answer);
                ansRes.moveToNext();
                ansIndex++;
            }
            question.setAnswers(answers);

            questions.add(question);
            res.moveToNext();
        }
        db.close();
        return questions;
    }

    @SuppressLint("Range")
    public void getListSignal() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select id, topicId, title, description, image from signals", null );
        res.moveToFirst();
        while(res.isAfterLast() == false){
            System.out.println(res.getInt(res.getColumnIndex("title")));
        }
        db.close();
    }
}