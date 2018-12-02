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

@WebServlet(name = "OrderSaveToDb")
public class OrderSaveToDb extends HttpServlet {

    String link;

    public void init() {
        try {
            link = getInitParameter("link");
        } catch (Exception e) {
            System.out.println("Bląd linków");
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Date date_in = Date.valueOf(request.getParameter("date_in"));
        Date date_out = Date.valueOf(request.getParameter("date_out"));
        Date started_date = Date.valueOf(request.getParameter("started_date"));
        int employee_id = Integer.parseInt(request.getParameter("employee_id"));
        String issue_note = request.getParameter("issue_note");
        String repair_note = request.getParameter("repair_note");
        int status_id = Integer.parseInt(request.getParameter("status_id"));
        int vehicle_id = Integer.parseInt(request.getParameter("vehicle_id"));
        int repair_cost = Integer.parseInt(request.getParameter("repair_cost"));
        int parts_cost = Integer.parseInt(request.getParameter("parts_cost"));
        int man_hours = Integer.parseInt(request.getParameter("man_hours"));
        OrderDao order = new OrderDao(date_in, date_out, started_date, employee_id, issue_note, repair_note, status_id, vehicle_id, repair_cost, parts_cost, man_hours);
        try {
            order.saveToDB();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("link", link);
        getServletContext().getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request, response);

    }
}


//preparedStatement.setDate(1, this.getDate_in());
//
//        preparedStatement.setDate(2, this.getDate_out());
//
//        preparedStatement.setDate(3, this.getStarted_date());
//
//        preparedStatement.setInt(4, this.getEmployee_id());
//
//        preparedStatement.setString(5, this.getIssue_note());
//
//        preparedStatement.setString(6, this.getRepair_note());
//
//        preparedStatement.setInt(7, this.getStatus_id());
//
//        preparedStatement.setInt(8, this.getVehicle_id());
//
//        preparedStatement.setString(9, this.getRepair_cost());
//
//        preparedStatement.setInt(10, this.getParts_cost());
//
//        preparedStatement.setInt(11, this.getMan_hours());