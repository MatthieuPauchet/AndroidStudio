package com.afpa.quizzgame.model;

import java.util.List;

public class Question {

    private String question;
    private List<String> choiceList;
    private int answerIndex;

    public Question(String question, List<String> choiceList, int answerIndex) {
        this.question = question;
        this.setChoiceList(choiceList);
        this.setAnswerIndex(answerIndex);
//        choiceList.size()>0;
//        0<answerIndex<choiceList.size();
    }

    public Question() {
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<String> getChoiceList() {
        return choiceList;
    }

    public void setChoiceList(List<String> choiceList) {
        if (choiceList == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }
        this.choiceList = choiceList;
    }

    public int getAnswerIndex() {
        return answerIndex;
    }

    public void setAnswerIndex(int answerIndex) {
        if (answerIndex < 0 || answerIndex >= choiceList.size()) {
            throw new IllegalArgumentException("Answer index is out of bound");
        }
        this.answerIndex = answerIndex;
    }
}
