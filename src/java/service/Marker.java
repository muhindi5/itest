/*
 * Copyright 2015
 *  http://wazza.co.ke
 * 10:24:56 AM  : Jul 12, 2015
 */
package service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kelli
 */
public class Marker {

    private String[] selectedOptions;
    private Connection connection;
    private Statement statement;
    private ResultSet results;
    private ArrayList<Answer> answerList;
    private ArrayList<MarkAction> markResults;
    private Summary summary;

// Collection of Queries 
    private final String sqlGetAnswers = "select * from answers";

    public Marker() {
    }

    public Marker(Connection connection, String[] selectedOptions) {
        this.connection = connection;
        this.selectedOptions = selectedOptions;
        //get all answers from the table in creating this instance
        answerList = getAllAnswers();
    }

    //get list of answers in the aswers table
    private ArrayList<Answer> getAllAnswers() {
       answerList= new ArrayList<>();
        try {
            statement = connection.createStatement();
            results = statement.executeQuery(sqlGetAnswers);
            while (results.next()) {
                int answerId = results.getInt("entry_id");
                int questionNumber = results.getInt("question_number");
                String answerOption = results.getString("answer_option"); //implicit conversion of char to string in Mysql???..I hope so!
                Logger.getLogger(Marker.class.getName()).log(Level.INFO, "Correct  Answer option is : {0}", answerOption);
                Answer answer = new Answer(answerId, questionNumber, answerOption);
                answerList.add(answer);
            }
        } catch (SQLException sqle) {
            Logger.getLogger(Marker.class.getName()).log(Level.SEVERE, "Error in getting answers: {0}", sqle.getMessage());
        }
        return answerList;
    }

    public ArrayList<MarkAction> getAnalysisOnOptions() {
         markResults = new ArrayList();
        summary = new Summary();
        summary.setTotalQuestions(selectedOptions.length);
        //for each question in the passed array
        for (int i = 0; i <=selectedOptions.length-1; i++) {
        MarkAction action = new MarkAction();
            String correctAnswer = answerList.get(i).getAnswerOption();
            Logger.getLogger(Marker.class.getName()).log(Level.INFO, "Current Correct Answer is: {0}",correctAnswer);
                action.setSelectedOption(selectedOptions[i]); //set what the user selected (to populate results page)
            Logger.getLogger(Marker.class.getName()).log(Level.INFO, "Selected  User Answer is: {0}",action.getSelectedOption());
            //compare this option with stored option in answers table
            if (selectedOptions[i].equals(correctAnswer)) {
                action.setAnswerStatus(true);
            Logger.getLogger(Marker.class.getName()).log(Level.INFO, "Setting true...",selectedOptions[i]);
                summary.incrementCorrectScore();
            } else if(!selectedOptions[i].equals(correctAnswer)) {
                action.setAnswerStatus(false);
            Logger.getLogger(Marker.class.getName()).log(Level.INFO, "Setting false...",selectedOptions[i]);
                summary.incrementWrongScore();
            }
            markResults.add(action);
            Logger.getLogger(Marker.class.getName()).log(Level.INFO, "State of action...{0}",action.getAnswerStatus());
        }
        for (MarkAction markResult : markResults) {
            
            Logger.getLogger(Marker.class.getName()).log(Level.INFO, "Status for answer: {0}",markResult.getAnswerStatus());
        }
        return markResults;
    }

    public Summary getExamSummary() {
       return summary;
    }

    /**
     * Class with possible mark data for each question
     */
    public  class MarkAction {
        
        private String selectedOption;
        private boolean answerStatus;

        /**
         * @return the answerState
         */
        public boolean getAnswerStatus() {
            return answerStatus;
        }

        /**
         * @param state
         */
        public void setAnswerStatus(boolean state) {
            this.answerStatus = state;
        }

        /**
         * @return the selectedOption
         */
        public String getSelectedOption() {
            return selectedOption;
        }

        /**
         * @param selectedOption the selectedOption to set
         */
        public void setSelectedOption(String selectedOption) {
            this.selectedOption = selectedOption;
        }

    }
}
