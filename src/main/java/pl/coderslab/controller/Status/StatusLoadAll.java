package pl.coderslab.controller.Status;

import pl.coderslab.dao.StatusDao;
import pl.coderslab.dao.VehicleDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "StatusLoadAll")
public class StatusLoadAll extends HttpServlet {
    String link;

    public void init() {
        try {
            link = getInitParameter("link");
        } catch (Exception e) {
            System.out.println("Bląd linków");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<StatusDao> ListStatus = StatusDao.loadAllStatus();

        request.setAttribute("link", link);
        request.setAttribute("Lista", ListStatus);

        getServletContext().getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request, response);


    }
}
