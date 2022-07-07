package com.sam.booklibrary.servlet;

import com.sam.booklibrary.dao.BookDao;
import com.sam.booklibrary.model.BookEntity;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author cattuan
 */
@WebServlet(name = "ListBookServlet", urlPatterns = {"/ListBookServlet"})
public class BookServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

    }

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
            out.println("<title>Servlet ListBookServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ListBookServlet at " + request.getContextPath() + "</h1>");
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
        System.out.println("This is ListBook");
        String function = request.getParameter("function");

        String id = request.getParameter("id");
        if (id == null || id.equals("")) { //list book
            request.setAttribute("listBook", BookDao.findAll());
            RequestDispatcher rd = getServletContext().
                    getRequestDispatcher("/list-book.jsp");
            rd.forward(request, response);
        } else {
            request.setAttribute("book", BookDao.findOne(Long.parseLong(id)));
            RequestDispatcher rd = getServletContext()
                    .getRequestDispatcher("/detail-book.jsp");
            rd.forward(request, response);
            switch (function) {
                case "delete":
                    BookDao.deleteBook(Long.parseLong(id));
                    response.sendRedirect("ListBookServlet");
                    break;
                case "detail":
                    rd = getServletContext().getRequestDispatcher("/detail-book.jsp");
                    rd.forward(request, response);
                    break;
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
        System.out.println("do post List Book");
        String id = request.getParameter("txtid");
        String title = request.getParameter("txttitle");
        String description = request.getParameter("txtdesription");
        String author = request.getParameter("txtauthor");
        String url = request.getParameter("txturl");

        BookEntity book;
        if (id == null || id.equals("")) {
            book = new BookEntity(title, description, author, url);
        } else {
            book = new BookEntity(Long.parseLong(id), title, description, author, url);
        }
        BookDao.persitBook(book);
        System.out.println("title: " + title);
       response.sendRedirect("ListBookServlet");
        // RequestDispatcher rd = getServletContext().getRequestDispatcher("/list-book.jsp");
        // rd.forward(request, response);
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
