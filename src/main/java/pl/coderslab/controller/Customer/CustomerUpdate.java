package pl.coderslab.controller.Customer;

import pl.coderslab.dao.CustomerDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

@WebServlet(name = "CustomerUpdate")
public class CustomerUpdate extends HttpServlet {

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
            String surname = request.getParameter("surname");
            Date birthdate = Date.valueOf(request.getParameter("birthDate"));
            String customerPhone = request.getParameter("customer_phone");
            int id = Integer.parseInt(request.getParameter("id"));

            CustomerDao customerDao = new CustomerDao(name, surname, birthdate, customerPhone);

            customerDao.setName(name);
            customerDao.setSurname(surname);
            customerDao.setBirthDate(birthdate);
            customerDao.setCustomer_phone(customerPhone);
            customerDao.setId(id);
            customerDao.editCustomer();

        } catch (NumberFormatException e) {
            System.out.println("zle wartosci");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("link", "/WEB-INF/views/home.jsp");
        getServletContext().getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request, response);
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            String name = request.getParameter("name");
            String surname = request.getParameter("surname");
            Date birthDate = Date.valueOf(request.getParameter("birthDate"));
            String customer_phone = request.getParameter("customer_phone");
            int id = Integer.parseInt(request.getParameter("id"));

            CustomerDao customerDao1 = new CustomerDao();
            customerDao1.setId(id);

            request.setAttribute("name", name);
            request.setAttribute("surname", surname);
            request.setAttribute("birthDate", birthDate);
            request.setAttribute("customer_phone", customer_phone);
            request.setAttribute("id", id);

        } catch (NumberFormatException e) {
        }
        request.setAttribute("link", link);
        getServletContext().getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request, response);

    }

}
