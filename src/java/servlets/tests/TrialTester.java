/*
 * Copyright 2015
 *  http://wazza.co.ke
 * 12:02:21 PM  : Jul 10, 2015
 */
package servlets.tests;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.DbRequestsProcess;
import service.Question;

/**
 * 
 * @author kelli
 * 1. Get questions from database
 * 2. Randomize order of questions in retrieved list 
 * 3. Create attribute from list
 */
public class TrialTester extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String execPath = "start"; //default path is start exam
        String rType = request.getParameter("rType");
        if(rType.equals("start")){
            execPath = "/tester.jsp";
        }else if(rType.equals("analyse")){
            execPath = "/results.jsp";
        }else{
            execPath = "/error.jsp";
        }
        
        DbRequestsProcess dbProcess  = new DbRequestsProcess();
        Connection  conn = (Connection) getServletContext().getAttribute("connector");
        ArrayList<Question> questions = dbProcess.getQuestions(conn);
        
        //randomize questions in list..later
        
            request.setAttribute("questions", questions);
            getServletContext().getRequestDispatcher(execPath).forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
