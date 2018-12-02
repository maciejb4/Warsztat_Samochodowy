package pl.coderslab.controller.Order;

import pl.coderslab.dao.OrderDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

@WebServlet(name = "OrderDelete")
public class OrderDelete extends HttpServlet {
    String link;

    public void init() {
        try {
            link = getInitParameter("link");
        } catch (Exception e) {
            System.out.println("Bląd linków");
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        OrderDao orderDao = new OrderDao();
        orderDao.setId(id);
        try {
            orderDao.delete();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("link", "/WEB-INF/views/home.jsp");

        getServletContext().getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        OrderDao orderDao = new OrderDao();

        orderDao.setId(id);

        request.setAttribute("id",id);

        request.setAttribute("link", link);
        getServletContext().getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request, response);

    }
}
