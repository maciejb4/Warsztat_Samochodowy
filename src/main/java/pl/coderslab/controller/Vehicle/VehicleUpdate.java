package pl.coderslab.controller.Vehicle;

import pl.coderslab.dao.OrderDao;
import pl.coderslab.dao.VehicleDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

@WebServlet(name = "VehicleUpdate")
public class VehicleUpdate extends HttpServlet {String link;

    public void init() {
        try {
            link = getInitParameter("link");
        } catch (Exception e) {
            System.out.println("Bląd linków");
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String brand = request.getParameter("brand");
            String model = request.getParameter("model");
            int production_date = Integer.parseInt(request.getParameter("production_date"));
            String plate_number = request.getParameter("plate_number");
            Date next_service_date = Date.valueOf(request.getParameter("next_service_date"));
            int customer_id = Integer.parseInt(request.getParameter("customer_id"));
            int id = Integer.parseInt(request.getParameter("id"));

            VehicleDao vehicle = new VehicleDao(brand, model, production_date, plate_number, next_service_date, customer_id);
            vehicle.setId(id);
            vehicle.updateToDB();

        } catch (NumberFormatException e) {
            System.out.println("zle wartosci");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String brand = request.getParameter("brand");
            String model=request.getParameter("model");
            int production_year=Integer.parseInt(request.getParameter("production_year"));
            String plate_number=request.getParameter("plate_number");
            Date next_service_date= Date.valueOf(request.getParameter("next_service_date"));
            int customer_id=Integer.parseInt(request.getParameter("customer_id"));

            VehicleDao vehicleDao=new VehicleDao();
            vehicleDao.setId(id);

            request.setAttribute("id",id);
            request.setAttribute("brand",brand);
            request.setAttribute("model",model);
            request.setAttribute("production_year",production_year);
            request.setAttribute("plate_number",plate_number);
            request.setAttribute("next_service_date",next_service_date);
            request.setAttribute("customer_id",customer_id);
        }catch (NumberFormatException e){
            e.printStackTrace();
        }
        request.setAttribute("link", link);

        getServletContext().getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request, response);
    }
}