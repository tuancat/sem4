/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sam.booklibrary.servlet;

import com.sam.booklibrary.configuration.Constants;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author cattuan
 */
@WebServlet(name = "BaseServlet", urlPatterns = {"/"})
public class BaseServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet BaseServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet BaseServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
//        processRequest(request, response);

//        request.setAttribute("function", "ListBookServlet");
        System.out.println("This is Base Servlet");
        RequestDispatcher rd = request.getRequestDispatcher("/" + 
                        Constants.FUNCTION_LISTBOOKS_STRING);
        String moduleValue = request.getParameter(Constants.MODULE_STRING);
        if (moduleValue == null || moduleValue.equals("")) {
            moduleValue = Constants.FUNCTION_LISTBOOKS_STRING;
        }
        switch (moduleValue) {
            case "":
//            case "AddNewBook":
                break;
            case "BorrowBookServlet":
                response.sendRedirect("BorrowBookServlet");
                break;
            case "ListUserServlet":
                rd = request.getRequestDispatcher("/" + 
                        Constants.FUNCTION_LISTUSER_STRING);
                response.sendRedirect("ListUserServlet");
                break;
            default:
                rd = request.getRequestDispatcher("/" + 
                        Constants.FUNCTION_LISTBOOKS_STRING);
                rd.forward(request, response);
                break;
        }

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
