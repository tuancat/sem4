 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sam.booklibrary.servlet;

import com.sam.booklibrary.configuration.Constants;
import com.sam.booklibrary.dao.BookDao;
import com.sam.booklibrary.dao.UserDao;
import com.sam.booklibrary.model.UserEntity;
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
 * @author tuanc
 */
@WebServlet(name = "ListUserServlet", urlPatterns = {"/ListUserServlet"})
public class ListUserServlet extends HttpServlet {

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
            out.println("<title>Servlet ListUserServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ListUserServlet at " + request.getContextPath() + "</h1>");
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
        String function = request.getParameter("function");

        String id = request.getParameter("id");

        if (id == null || id.equals("")) { //list book
            request.setAttribute("listUser", UserDao.findAll());
            RequestDispatcher rd = getServletContext().
                    getRequestDispatcher("/list-user.jsp");
            rd.forward(request, response);
        } else {
            request.setAttribute("user", UserDao.findOne(Long.parseLong(id)));
            RequestDispatcher rd = getServletContext()
                    .getRequestDispatcher("/detail-user.jsp");
            rd.forward(request, response);
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
//        processRequest(request, response);
        String id = request.getParameter("txtid");
        String userName = request.getParameter("txtusername");
        String fullName = request.getParameter("txtfullName");
        String password = request.getParameter("txtpassword");
        UserEntity user;
        if (id == null || id.equals("")) {
            user = new UserEntity(userName, password, fullName);
        } else {
            user = new UserEntity(Long.valueOf(id), userName, password, fullName);
        }
        UserDao.persitUser(user);
        response.sendRedirect(Constants.FUNCTION_LISTUSER_STRING);
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
