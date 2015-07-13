/*
 * Copyright 2015
 *  http://wazza.co.ke
 * 1:44:10 PM  : Jul 10, 2015
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
public class DbRequestsProcess {

    private Statement statement;
    private ResultSet results;

    public ArrayList getQuestions(Connection conn) {
        String questionsQuery = "select * from questions;";
        ArrayList items = new ArrayList();

        try {
            statement = conn.createStatement();
            results = statement.executeQuery(questionsQuery);
            while (results.next()) {

                String question = results.getString("question");
                String option1 = results.getString("option_1");
                String option2 = results.getString("option_2");
                String option3 = results.getString("option_3");
                String option4 = results.getString("option_4");
                String option5 = results.getString("option_5");

                Question current = new Question(question, option1, option2, option3, option4, option5);
                items.add(current);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DbRequestsProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return items;

    }
}
