package com.tenk.a1dl_test.do_test;

import java.util.ArrayList;
import java.util.List;

public class TestStore {
    private List<Question> questions;
    private Boolean isSubmitted;

    private static TestStore instance;

    private TestStore() {}

    public static TestStore getInstance() {
        if (instance == null) {
            instance = new TestStore();
        }
        return instance;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public Boolean getSubmitted() {
        return isSubmitted;
    }

    public void setSubmitted(Boolean submitted) {
        isSubmitted = submitted;
    }
}
