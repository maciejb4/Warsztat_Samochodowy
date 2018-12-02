package pl.coderslab.controller.Employee;

import pl.coderslab.dao.EmployeeDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "EmployeeDel")
public class EmployeeDel extends HttpServlet {
    String link;

    public void init() {
        try {
            link = getInitParameter("link");
        } catch (Exception e) {
            System.out.println("Bląd linków");

        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            int id = Integer.parseInt(request.getParameter("id"));
            EmployeeDao employeeDaoDel = new EmployeeDao();
            employeeDaoDel.setId(id);
            employeeDaoDel.delete();
        } catch (NumberFormatException e) {
            System.out.println("zle wartosci");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("link", "/WEB-INF/views/home.jsp");
        getServletContext().getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request, response);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            EmployeeDao employeeDao1=new EmployeeDao();
            int id = Integer.parseInt(request.getParameter("id"));
            employeeDao1.setId(id);
            request.setAttribute("id",id);
        }catch (NumberFormatException e){

        }
        request.setAttribute("link", link);
        getServletContext().getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request, response);

    }
}

