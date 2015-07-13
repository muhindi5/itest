/*
 * Copyright 2015
 *  http://wazza.co.ke
 * 10:50:38 AM  : Jul 12, 2015
 */
package service;

/**
 *
 * @author kelli
 */
public class Answer {
    private int answerId;
    private int questionNumber;
    private  String  answerOption;

    Answer(int answerId, int questionNumber, String answerOption) {
        this.answerId = answerId;
        this.questionNumber = questionNumber;
        this.answerOption = answerOption;
    }

    /**
     * @return the answerId
     */
    public int getAnswerId() {
        return answerId;
    }

    /**
     * @param answerId the answerId to set
     */
    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    /**
     * @return the questionNumber
     */
    public int getQuestionNumber() {
        return questionNumber;
    }

    /**
     * @param questionNumber the questionNumber to set
     */
    public void setQuestionNumber(int questionNumber) {
        this.questionNumber = questionNumber;
    }

    /**
     * @return the answerOption
     */
    public String getAnswerOption() {
        return answerOption;
    }

    /**
     * @param answerOption the answerOption to set
     */
    public void setAnswerOption(String  answerOption) {
        this.answerOption = answerOption;
    }
    
    
}
