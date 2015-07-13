/*
 * Copyright 2015
 *  http://wazza.co.ke
 * 1:02:35 PM  : Jul 10, 2015
 */
package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseConnection {

    //Database connection strings:
    private static Connection conn;
    private static DriverManager driverManager;
    private static boolean connected = false;

    public static Connection getDBConnection(String url, String user, String pass) {

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            /*Connect to the database*/
            conn = DriverManager.getConnection(url, user, pass);
            if (conn != null) {
                connected = true;
                Logger.getLogger(DatabaseConnection.class.getName()).log(Level.INFO, "Connection to itest db created!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex.getStackTrace());
        }
        return conn;
    }

    public static boolean closeConnection() {
        return connected;
    }
}
