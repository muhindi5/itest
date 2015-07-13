/*
 * Copyright 2015
 *  http://wazza.co.ke
 * 12:58:32 PM  : Jul 10, 2015
 */
package servlets.tests;

import java.io.IOException;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import service.DatabaseConnection;

/**
 *
 * @author kelli
 */
public class ConnectionInit extends GenericServlet {
    
    protected String url,user,password;
    protected  Connection connection;
    @Override
    /**Overide the init method to create database connection object and load them
     * to the servletcontex
     * @param configt*/
    
    public  void init(ServletConfig config) throws ServletException{
        this.url= config.getInitParameter("url");
        Logger.getLogger(ConnectionInit.class.getName()).log(Level.INFO, "url = {0}", url);
        this.user= config.getInitParameter("user");
        Logger.getLogger(ConnectionInit.class.getName()).log(Level.INFO, "user= : {0}", user);
        this.password= config.getInitParameter("password");
        Logger.getLogger(ConnectionInit.class.getName()).log(Level.INFO, "password=: {0}", password);
        
        //create the database connection...
        connection = (Connection)DatabaseConnection.getDBConnection(url, user, password);
        //push to ServletContext....
        ServletContext context =config.getServletContext();
        context.setAttribute("connector",connection);
        Logger.getLogger(ConnectionInit.class.getName()).log(Level.INFO, "Database connection "+"attribute set= {0}", context.getAttribute("connector"));
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        
    }

   

}
