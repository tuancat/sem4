
package com.fsoft.ctc.assignment.optional.Servlet;

import com.fsoft.ctc.assignment.optional.Entity.Trainee;
import com.fsoft.ctc.assignment.optional.dao.TraineeDao;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/delete-trainee")
public class DeleteTraineeServlet extends HttpServlet{
    TraineeDao traineeDao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        traineeDao = new TraineeDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        traineeDao.deleteTrainee(Long.valueOf(id));
        response.sendRedirect(request.getContextPath() + "/homepage");
    }
}
