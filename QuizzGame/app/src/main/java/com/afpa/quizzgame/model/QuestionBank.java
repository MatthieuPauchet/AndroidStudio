package com.afpa.quizzgame.model;

import java.util.Collections;
import java.util.List;

public class QuestionBank {
    private List<Question> questionList;
    private int nextQuestionIndex;

    public QuestionBank(List<Question> ql){
        questionList = ql;

        // Shuffle the question list
        Collections.shuffle(questionList);

        nextQuestionIndex = 0;
    }

    public Question getQuestion(){
        // Ensure we loop over the questions
        if (nextQuestionIndex == questionList.size()) {
            nextQuestionIndex = 0;
        }

        // Please note the post-incrementation
        return questionList.get(nextQuestionIndex++);
    }

}
