package pl.coderslab.controller.Order;

import com.mysql.cj.x.protobuf.MysqlxCrud;
import pl.coderslab.dao.OrderDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

@WebServlet(name = "ServletOrderUpdate")
public class ServletOrderUpdate extends HttpServlet {
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
        int id = Integer.parseInt(request.getParameter("id"));

        OrderDao orderDao = new OrderDao();

        orderDao.setDate_in(date_in);
        orderDao.setDate_out(date_out);
        orderDao.setStarted_date(started_date);
        orderDao.setEmployee_id(employee_id);
        orderDao.setIssue_note(issue_note);
        orderDao.setRepair_note(repair_note);
        orderDao.setStatus_id(status_id);
        orderDao.setVehicle_id(vehicle_id);
        orderDao.setRepair_cost(repair_cost);
        orderDao.setParts_cost(parts_cost);
        orderDao.setMan_hours(man_hours);
        orderDao.setId(id);
        orderDao.update();
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

        OrderDao orderDao1 = new OrderDao();
        orderDao1.setId(id);

        request.setAttribute("id",id);
        request.setAttribute("date_in",date_in);
        request.setAttribute("date_out",date_out);
        request.setAttribute("started_date",started_date);
        request.setAttribute("employee_id",employee_id);
        request.setAttribute("issue_note",issue_note);
        request.setAttribute("repair_note",repair_note);
        request.setAttribute("status_id",status_id);
        request.setAttribute("vehicle_id",vehicle_id);
        request.setAttribute("repair_cost",repair_cost);
        request.setAttribute("parts_cost",parts_cost);
        request.setAttribute("man_hours",man_hours);



        }catch (NumberFormatException e){
            System.out.println("numberformat int");

        }
        request.setAttribute("link", link);

        getServletContext().getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request, response);



    }
}
