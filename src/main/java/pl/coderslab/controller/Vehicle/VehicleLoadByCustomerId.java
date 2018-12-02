package pl.coderslab.controller.Vehicle;

import pl.coderslab.dao.VehicleDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "VehicleLoadByCustomerId")
public class VehicleLoadByCustomerId extends HttpServlet {
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
            int customer_id = Integer.parseInt(request.getParameter("customer_id"));
            ArrayList<VehicleDao> vehicleDList = VehicleDao.loadVehiclesByCustomerId(customer_id);
            request.setAttribute("vehicleDList", vehicleDList);

        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        request.setAttribute("link", link);
        getServletContext().getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request, response);
    }
}
