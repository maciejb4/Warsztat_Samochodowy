package pl.coderslab.controller.Customer;

import pl.coderslab.dao.CustomerDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "CustomerFound")
public class CustomerFound extends HttpServlet {

    String link;

    public void init() {
        try {
            link = getInitParameter("link");
        } catch (Exception e) {
            System.out.println("Bląd linków");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String surname = request.getParameter("surname");
        CustomerDao.loadCustomerBySurname(surname);
        doGet(request, response);



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String surname = request.getParameter("surname");
        request.setAttribute("surname", surname);

        ArrayList<CustomerDao> listadanychnazwiska = CustomerDao.loadCustomerBySurname(surname);
        request.setAttribute("link", link);
        request.setAttribute("listadanychnazwiska", listadanychnazwiska);

        getServletContext().getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request, response);

    }

}
