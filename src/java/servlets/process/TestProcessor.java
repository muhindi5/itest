/*
 * Copyright 2015
 *  http://wazza.co.ke
 * 5:11:17 PM  : Jul 11, 2015
 */
package servlets.process;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.Marker;
import service.Marker.MarkAction;
import service.Summary;

/**
 *
 * @author kelli
 * Get user responses 
 */
public class TestProcessor extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
      
            Logger.getLogger(TestProcessor.class.getName()).log(Level.INFO, "Entering processor...");
        //get the user answer
            
        String  option1 = request.getParameter("option1");
        String  option2 = request.getParameter("option2");
        String  option3 = request.getParameter("option3");
        String  option4 = request.getParameter("option4");
        String  option5 = request.getParameter("option5");
        
        String [] selectedOptions = new String[] {option1,option2,option3,option4,option5};
        
        Logger.getLogger(TestProcessor.class.getName()).log(Level.INFO,selectedOptions[0]);
        Logger.getLogger(TestProcessor.class.getName()).log(Level.INFO,selectedOptions[1]);
        Logger.getLogger(TestProcessor.class.getName()).log(Level.INFO,selectedOptions[2]);
        Logger.getLogger(TestProcessor.class.getName()).log(Level.INFO,selectedOptions[3]);
        Logger.getLogger(TestProcessor.class.getName()).log(Level.INFO,selectedOptions[4]);
        
        //get database connection and pass selectedOptions to marker instance...
        Connection connection = (Connection)getServletContext().getAttribute("connector");
        Logger.getLogger(TestProcessor.class.getName()).log(Level.INFO,"Got connection {0} for marker",connection);
        //pass database connection and user choices for procassing
        Marker marker = new Marker(connection,selectedOptions);
        ArrayList<MarkAction> output = marker.getAnalysisOnOptions();
        for (MarkAction output1 : output) {
            System.out.println("Items selected- MarkItem: "+output1.getSelectedOption());
        }
        Summary summary = marker.getExamSummary();
        
        Logger.getLogger(TestProcessor.class.getName()).log(Level.INFO,"MarkAction items in output",output.size());
        
        //set the output attribute 
        request.setAttribute("results",output);
        request.setAttribute("summary",summary);
        getServletContext().getRequestDispatcher("/tester1?rType=analyse").forward(request, response);
        
        
        
        
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
