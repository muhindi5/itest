/*
 * Copyright 2015
 *  http://wazza.co.ke
 * 2:05:48 PM  : Jul 12, 2015
 */
package service;

/**
 *
 * @author kelli
 */
public class Summary {
    private  int correctScoreCount;
    private  int wrongScoreCount;
    private int totalQuestions;

    /**
     * @return the correctScoreCount
     */
    public int getCorrectScoreCount() {
        return correctScoreCount;
    }

    /**
     * @param correctScoreCount the correctScoreCount to set
     */
    public void setCorrectScoreCount(int correctScoreCount) {
        this.correctScoreCount = correctScoreCount;
    }

    /**
     * @return the wrongScoreCount
     */
    public int getWrongScoreCount() {
        return wrongScoreCount;
    }

    /**
     * @param wrongScoreCount the wrongScoreCount to set
     */
    public void setWrongScoreCount(int wrongScoreCount) {
        this.wrongScoreCount = wrongScoreCount;
    }

    /**
     * @return the totalQuestions
     */
    public int getTotalQuestions() {
        return totalQuestions;
    }

    /**
     * @param totalQuestions the totalQuestions to set
     */
    public void setTotalQuestions(int totalQuestions) {
        this.totalQuestions = totalQuestions;
    }

    void incrementCorrectScore() {
        this.correctScoreCount++;
    }
    
    void incrementWrongScore() {
        this.wrongScoreCount++;
    }
    
    
    
}
