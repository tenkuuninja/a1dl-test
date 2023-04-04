package com.tenk.a1dl_test.do_test;

public class Answer {
    private Integer id;
    private String text;
    private Boolean correct;

    public Answer() {
    }

    public Answer(Integer id, String text, Boolean correct) {
        this.id = id;
        this.text = text;
        this.correct = correct;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Boolean getCorrect() {
        return correct;
    }

    public void setCorrect(Boolean correct) {
        this.correct = correct;
    }
}
