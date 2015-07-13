/*
 * Copyright 2015
 *  http://wazza.co.ke
 * 1:53:22 PM  : Jul 10, 2015
 */
package service;

/**
 *
 * @author kelli
 */
public class Question {
    private String question;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String option5;

    public Question(){
        
    }
    
    public Question(String question,String option1,String option2,String option3,String option4,String option5){
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.option5 = option5;
    }

    /**
     * @return the question
     */
    public String getQuestion() {
        return question;
    }

    /**
     * @param question the question to set
     */
    public void setQuestion(String question) {
        this.question = question;
    }

    /**
     * @return the option1
     */
    public String getOption1() {
        return option1;
    }

    /**
     * @param option1 the option1 to set
     */
    public void setOption1(String option1) {
        this.option1 = option1;
    }

    /**
     * @return the option2
     */
    public String getOption2() {
        return option2;
    }

    /**
     * @param option2 the option2 to set
     */
    public void setOption2(String option2) {
        this.option2 = option2;
    }

    /**
     * @return the option3
     */
    public String getOption3() {
        return option3;
    }

    /**
     * @param option3 the option3 to set
     */
    public void setOption3(String option3) {
        this.option3 = option3;
    }

    /**
     * @return the option4
     */
    public String getOption4() {
        return option4;
    }

    /**
     * @param option4 the option4 to set
     */
    public void setOption4(String option4) {
        this.option4 = option4;
    }

    /**
     * @return the option5
     */
    public String getOption5() {
        return option5;
    }

    /**
     * @param option5 the option5 to set
     */
    public void setOption5(String option5) {
        this.option5 = option5;
    }
    
    
    
}
