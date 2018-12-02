package pl.coderslab.controller.Vehicle;

import pl.coderslab.dao.VehicleDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

@WebServlet(name = "VehicleSaveToDb")
public class VehicleSaveToDb extends HttpServlet {
    String link;

    public void init() {
        try {
            link = getInitParameter("link");
        } catch (Exception e) {
            System.out.println("Bląd linków");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String brand = request.getParameter("brand");
        String model = request.getParameter("model");
        int production_date = Integer.parseInt(request.getParameter("production_date"));
        String plate_number = request.getParameter("plate_number");
        Date next_service_date = Date.valueOf(request.getParameter("next_service_date"));
        int customer_id = Integer.parseInt(request.getParameter("customer_id"));
        VehicleDao vehicle = new VehicleDao(brand, model, production_date, plate_number, next_service_date, customer_id);
        try {
            vehicle.saveToDB();
        } catch (SQLException e) {
            System.out.println("Błąd save");
        }
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("link", link);
        getServletContext().getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request, response);

    }
}
