package pl.coderslab.controller.Employee;

import pl.coderslab.dao.EmployeeDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "EmployeeUpdate")
public class EmployeeUpdate extends HttpServlet {
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

            String name = request.getParameter("name");
            String lastname = request.getParameter("lastname");
            String adress = request.getParameter("adress");
            String employee_phone = request.getParameter("employee_phone");
            String note = request.getParameter("note");
            int hourly = Integer.parseInt(request.getParameter("hourly"));
            int id = Integer.parseInt(request.getParameter("id"));



            EmployeeDao employeeDao = new EmployeeDao();

            employeeDao.setName(name);
            employeeDao.setLastname(lastname);
            employeeDao.setAdress(adress);
            employeeDao.setEmployee_phone(employee_phone);
            employeeDao.setNote(note);
            employeeDao.setHourly(hourly);
            employeeDao.setId(id);
            employeeDao.updateDb();


        } catch (NumberFormatException e) {
            System.out.println("zle wartosci");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        doGet(request,response);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            EmployeeDao employeeDao1=new EmployeeDao();
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            String lastname = request.getParameter("lastname");
            String adress = request.getParameter("adress");
            String employee_phone = request.getParameter("employee_phone");
            String note = request.getParameter("note");
            int hourly = Integer.parseInt(request.getParameter("hourly"));
            employeeDao1.setId(id);
            request.setAttribute("id",id);
            request.setAttribute("name",name);
            request.setAttribute("lastname",lastname);
            request.setAttribute("adress",adress);
            request.setAttribute("employee_phone",employee_phone);
            request.setAttribute("note",note);
            request.setAttribute("hourly",hourly);

        }catch (NumberFormatException e){

        }

        request.setAttribute("link", link);
        getServletContext().getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request, response);

    }
}
