package pl.coderslab.controller.Employee;

import com.sun.org.apache.xpath.internal.operations.Or;
import pl.coderslab.DbUtil.DbUtil;
import pl.coderslab.dao.EmployeeDao;
import pl.coderslab.dao.OrderDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

@WebServlet(name = "EmployeeOrders")
public class EmployeeOrders extends HttpServlet {
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
        try {

            int employee_id = Integer.parseInt(request.getParameter("employee_id"));

            ArrayList<OrderDao> lista = OrderDao.EmployeeOrders(employee_id);
            request.setAttribute("lista",lista);

            }catch (NumberFormatException e){

        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("link", link);
        getServletContext().getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request, response);

    }
}

