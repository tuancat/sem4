/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sam.booklibrary.servlet;

import com.sam.booklibrary.dao.BookDao;
import com.sam.booklibrary.dao.BorrowDao;
import com.sam.booklibrary.dao.UserDao;
import com.sam.booklibrary.model.BorrowBookEntity;
import com.sam.booklibrary.model.BorrowModel;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author tuan
 */
@WebServlet(name = "BorrowBookServlet", urlPatterns = {"/BorrowBookServlet"})
public class BorrowBookServlet extends HttpServlet {

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
            out.println("<title>Servlet BorrowBookServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet BorrowBookServlet at " + request.getContextPath() + "</h1>");
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

        String function = request.getParameter("function");
        if ("".equals(function) || function == null) {
            String userId = request.getParameter("userid");
            request.setAttribute("user", UserDao.findOne(Long.valueOf(userId)));
            request.setAttribute("listBook", BookDao.findAll());
//        processRequest(request, response);
//        request.setAttribute("listBook", BookDao.findAll());
            RequestDispatcher rd = getServletContext().
                    getRequestDispatcher("/borrow-book.jsp");
            rd.forward(request, response);
        } else {
            if ("history".equals(function)) {
                String userId = request.getParameter("userid");
                
                request.setAttribute("user", UserDao.findOne(Long.valueOf(userId)));
                
                List<BorrowBookEntity> listBorrowBook = BorrowDao.findBorrowBookByUserId(Long.valueOf(userId));
                
                List<BorrowModel> listBorrowModel = new ArrayList<>();
                
                for (BorrowBookEntity curr : listBorrowBook) {
                    BorrowModel currModel = new BorrowModel(curr.getId(), UserDao.findOne(curr.getUserId()), 
                            BookDao.findOne(curr.getBookId()), curr.getCurrTime());
                    listBorrowModel.add(currModel);
                }
                
                request.setAttribute("listBorrowModel", listBorrowModel);
                
                RequestDispatcher rd = getServletContext().
                    getRequestDispatcher("/history-borrow.jsp");
                rd.forward(request, response);
            }
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
        String userId = request.getParameter("userid");
        String bookId = request.getParameter("listBooks");
        System.out.println("bookId:" + bookId);

        BorrowBookEntity bor = new BorrowBookEntity(Long.valueOf(userId), Long.valueOf(bookId), 
                new Date());
        BorrowDao.createBorrowBook(bor);
        response.sendRedirect("ListUserServlet");
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
