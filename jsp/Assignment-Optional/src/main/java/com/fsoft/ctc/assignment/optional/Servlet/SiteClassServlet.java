/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fsoft.ctc.assignment.optional.Servlet;

import com.fsoft.ctc.assignment.optional.Entity.SiteClass;
import com.fsoft.ctc.assignment.optional.dao.SiteClassDao;
import com.fsoft.ctc.assignment.optional.dao.TraineeDao;
import java.io.IOException;
import java.util.List;
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
@WebServlet(name = "SiteClassServlet", urlPatterns = {"/SiteClassServlet"})
public class SiteClassServlet extends HttpServlet {

    TraineeDao traineeDao;
    SiteClassDao siteClassDao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        traineeDao = new TraineeDao();
        siteClassDao = new SiteClassDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<SiteClass> listSiteClass = siteClassDao.findAll();
        request.setAttribute("listSiteClass", listSiteClass);
        request.setAttribute("name", "test");

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/list-siteclass.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
