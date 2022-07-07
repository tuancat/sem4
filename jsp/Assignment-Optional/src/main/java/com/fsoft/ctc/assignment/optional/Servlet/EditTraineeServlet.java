package com.fsoft.ctc.assignment.optional.Servlet;

import com.fsoft.ctc.assignment.optional.Entity.Trainee;
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

@WebServlet("/edit-trainee")
public class EditTraineeServlet extends HttpServlet {

    TraineeDao traineeDao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        traineeDao = new TraineeDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        request.setAttribute("currTrainee", traineeDao.findOne(Long.valueOf(id)));
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/edit-trainee.jsp");
        rd.forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Trainee editTrainee = new Trainee(request.getParameter("txtFirstName"), request.getParameter("txtLastName"), request.getParameter("txtEmail"));
        editTrainee.setId(Long.valueOf(request.getParameter("txtId")));
        traineeDao.updateTrainee(editTrainee);
        response.sendRedirect(request.getContextPath() + "/homepage");
    }
}
