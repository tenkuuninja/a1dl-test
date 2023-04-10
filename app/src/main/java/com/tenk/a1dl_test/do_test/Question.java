package com.tenk.a1dl_test.do_test;

import java.io.Serializable;
import java.util.List;

public class Question implements Serializable {
    private Integer id;
    private Integer topicId;
    private Integer testId;
    private Integer order;
    private String text;
    private String image;
    private String explain;
    private Boolean critical;
    private List<Answer> answers;
    private Integer correctAnswerIndex;
    private Integer selectionIndex;

    public Question() {
        selectionIndex = -1;
    }

    public Question(Integer id, Integer topicId, Integer testId, Integer order, String text, String image, String explain, Boolean critical) {
        this.id = id;
        this.topicId = topicId;
        this.testId = testId;
        this.order = order;
        this.text = text;
        this.image = image;
        this.explain = explain;
        this.critical = critical;
        selectionIndex = -1;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTopicId() {
        return topicId;
    }

    public void setTopicId(Integer topicId) {
        this.topicId = topicId;
    }

    public Integer getTestId() {
        return testId;
    }

    public void setTestId(Integer testId) {
        this.testId = testId;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }

    public Boolean getCritical() {
        return critical;
    }

    public void setCritical(Boolean critical) {
        this.critical = critical;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public Integer getCorrectAnswerIndex() {
        return correctAnswerIndex;
    }

    public void setCorrectAnswerIndex(Integer correctAnswerIndex) {
        this.correctAnswerIndex = correctAnswerIndex;
    }

    public Integer getSelectionIndex() {
        return selectionIndex;
    }

    public void setSelectionIndex(Integer selectionIndex) {
        this.selectionIndex = selectionIndex;
    }
}
