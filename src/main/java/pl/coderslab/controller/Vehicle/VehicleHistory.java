package pl.coderslab.controller.Vehicle;

import pl.coderslab.dao.OrderDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "VehicleHistory")
public class VehicleHistory extends HttpServlet {
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

            int vehicle_id = Integer.parseInt(request.getParameter("vehicle_id"));

            ArrayList<OrderDao> lista = OrderDao.VehicleHistory(vehicle_id);
            request.setAttribute("lista",lista);
        }catch (NumberFormatException e){

        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("link", link);
        getServletContext().getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request, response);

    }

}
