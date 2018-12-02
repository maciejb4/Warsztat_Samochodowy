package pl.coderslab.controller;

import pl.coderslab.dao.EmployeeDao;
import pl.coderslab.dao.OrderDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "HomePage")
public class HomePage extends HttpServlet {
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
        ArrayList<EmployeeDao> lista = EmployeeDao.loadAll();
        request.setAttribute("lista", lista);
        request.setAttribute("link", link);
        getServletContext().getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request, response);
    }
}
