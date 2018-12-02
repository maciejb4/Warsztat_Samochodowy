package pl.coderslab.dao;

import pl.coderslab.DbUtil.DbUtil;
import pl.coderslab.classes.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class OrderDao extends Order {

    public OrderDao(Date date_in, Date date_out, Date started_date, int employee_id, String issue_note, String repair_note, int status_id, int vehicle_id, int repair_cost, int parts_cost, int man_hours) {
        super(date_in, date_out, started_date, employee_id, issue_note, repair_note, status_id, vehicle_id, repair_cost, parts_cost, man_hours);
    }

    public OrderDao() {
    }

    public void saveToDB() throws SQLException {

        try {

            Connection connection = DbUtil.getConn();

            if (this.getId() == 0) {

                String sql = "INSERT INTO orders(date_in,date_out, started_date, employee_id, issue_note, repair_note, status_id, vehicle_id, repair_cost, parts_cost, man_hours) \n" +
                        "\n" +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

                String generatedColumns[] = {"ID"};

                PreparedStatement preparedStatement = connection.prepareStatement(sql, generatedColumns);

                preparedStatement.setDate(1, this.getDate_in());

                preparedStatement.setDate(2, this.getDate_out());

                preparedStatement.setDate(3, this.getStarted_date());

                preparedStatement.setInt(4, this.getEmployee_id());

                preparedStatement.setString(5, this.getIssue_note());

                preparedStatement.setString(6, this.getRepair_note());

                preparedStatement.setInt(7, this.getStatus_id());

                preparedStatement.setInt(8, this.getVehicle_id());

                preparedStatement.setInt(9, this.getRepair_cost());

                preparedStatement.setInt(10, this.getParts_cost());

                preparedStatement.setInt(11, this.getMan_hours());

                preparedStatement.executeUpdate();

                ResultSet resultSet = preparedStatement.getGeneratedKeys();

                if (resultSet.next()) {

                    this.setId(resultSet.getInt(1));

                }

            } else {

                String sql = "update orders set date_in = ?,date_out = ?, started_date = ?, employee_id = ?, issue_note = ?, repair_note = ?, status_id = ?, vehicle_id = ?, repair_cost = ?, parts_cost = ?, man_hours = ? where id=?";

                PreparedStatement preparedStatement = connection.prepareStatement(sql);

                preparedStatement.setDate(1, this.getDate_in());

                preparedStatement.setDate(2, this.getDate_out());

                preparedStatement.setDate(3, this.getStarted_date());

                preparedStatement.setInt(4, this.getEmployee_id());

                preparedStatement.setString(5, this.getIssue_note());

                preparedStatement.setString(6, this.getRepair_note());

                preparedStatement.setInt(7, this.getStatus_id());

                preparedStatement.setInt(8, this.getVehicle_id());

                preparedStatement.setInt(9, this.getRepair_cost());

                preparedStatement.setInt(10, this.getParts_cost());

                preparedStatement.setInt(11, this.getMan_hours());

                preparedStatement.setInt(12, this.getId());

                preparedStatement.executeUpdate();

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }
    }

    public void delete() throws SQLException {

        try {

            Connection connection = DbUtil.getConn();

            if (this.getId() != 0) {

                String sql = "delete from orders where id=?";

                PreparedStatement preparedStatement = connection.prepareStatement(sql);

                preparedStatement.setInt(1, this.getId());

                preparedStatement.executeUpdate();

                this.setId(0);

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

    }

    private static void getOrderData(ArrayList<OrderDao> OrderLista, ResultSet resultSet) throws SQLException {

        while (resultSet.next()) {

            OrderDao loadedOrder = new OrderDao();

            loadedOrder.setId(resultSet.getInt("id"));

            loadedOrder.setDate_in(resultSet.getDate("date_in"));

            loadedOrder.setDate_out(resultSet.getDate("date_out"));

            loadedOrder.setStarted_date(resultSet.getDate("started_date"));

            loadedOrder.setEmployee_id(resultSet.getInt("employee_id"));

            loadedOrder.setIssue_note(resultSet.getString("issue_note"));

            loadedOrder.setRepair_note(resultSet.getString("repair_note"));

            loadedOrder.setStatus_id(resultSet.getInt("status_id"));

            loadedOrder.setVehicle_id(resultSet.getInt("vehicle_id"));

            loadedOrder.setRepair_cost(resultSet.getInt("repair_cost"));

            loadedOrder.setParts_cost(resultSet.getInt("parts_cost"));

            loadedOrder.setMan_hours(resultSet.getInt("man_hours"));

            OrderLista.add(loadedOrder);


        }

    }

    public static ArrayList<OrderDao> loadAll() {

        try {

            Connection connection = DbUtil.getConn();

            ArrayList<OrderDao> orders = new ArrayList<>();

            String sql = "SELECT * FROM orders ORDER BY date_in desc";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();

            getOrderData(orders, resultSet);

            return orders;

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return null;

    }

    public void update() throws SQLException {
        try {

        Connection connection = DbUtil.getConn();

        String sql = "update orders set date_in = ?,date_out = ?, started_date = ?, employee_id = ?, issue_note = ?, repair_note = ?, status_id = ?, vehicle_id = ?, repair_cost = ?, parts_cost = ?, man_hours = ? where id=?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setDate(1, this.getDate_in());

        preparedStatement.setDate(2, this.getDate_out());

        preparedStatement.setDate(3, this.getStarted_date());

        preparedStatement.setInt(4, this.getEmployee_id());

        preparedStatement.setString(5, this.getIssue_note());

        preparedStatement.setString(6, this.getRepair_note());

        preparedStatement.setInt(7, this.getStatus_id());

        preparedStatement.setInt(8, this.getVehicle_id());

        preparedStatement.setInt(9, this.getRepair_cost());

        preparedStatement.setInt(10, this.getParts_cost());

        preparedStatement.setInt(11, this.getMan_hours());

        preparedStatement.setInt(12, this.getId());

        preparedStatement.executeUpdate();

        } catch (SQLException e) {

            e.printStackTrace();

        }

    }


    public static ArrayList<OrderDao> EmployeeOrders(int employee_id) throws SQLException {
        try {
            ArrayList<OrderDao> orders1 = new ArrayList<>();
            Connection connection = DbUtil.getConn();
            String sql = "select * from orders where employee_id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, employee_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            getOrderData(orders1,resultSet);
            return orders1;
        } catch (
                SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    //-----------------------3---------------------------------
//    public static VehicleDao loadVehiclesByCustomerId(int customer_id){
//        try{
//            Connection connection = DbUtil.getConn();
//            String sql = "select * from vehicles where customer_id=?";
//            PreparedStatement preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setInt(1,customer_id);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            return getVehiclesData(resultSet);
//        }catch (SQLException e){
//            System.out.println("Błąd SQL");
//        }
//        return null;
//    }
    //-----------------------4---------------------------------
    private static OrderDao getOrdersData(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            OrderDao loadedOrder = new OrderDao();

            loadedOrder.setId(resultSet.getInt("id"));

            loadedOrder.setDate_in(resultSet.getDate("date_in"));

            loadedOrder.setDate_out(resultSet.getDate("date_out"));

            loadedOrder.setStarted_date(resultSet.getDate("started_date"));

            loadedOrder.setEmployee_id(resultSet.getInt("employee_id"));

            loadedOrder.setIssue_note(resultSet.getString("issue_note"));

            loadedOrder.setRepair_note(resultSet.getString("repair_note"));

            loadedOrder.setStatus_id(resultSet.getInt("status_id"));

            loadedOrder.setVehicle_id(resultSet.getInt("vehicle_id"));

            loadedOrder.setRepair_cost(resultSet.getInt("repair_cost"));

            loadedOrder.setParts_cost(resultSet.getInt("parts_cost"));

            loadedOrder.setMan_hours(resultSet.getInt("man_hours"));


            return loadedOrder;
        }else {
            return null;
        }
    }

    public static ArrayList<OrderDao> RecentOrdersForEmployee(int employee_id) throws SQLException  {
        try {

            Connection connection = DbUtil.getConn();
            ArrayList<OrderDao> orders2 = new ArrayList<>();
            String sql = "select * from orders where status_id != 5 AND employee_id=?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, employee_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            getOrderData(orders2,resultSet);
            return orders2;
        } catch (
                SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ArrayList<OrderDao> VehicleHistory(int vehicle_id) throws SQLException  {
        try {

            Connection connection = DbUtil.getConn();
            ArrayList<OrderDao> orders3 = new ArrayList<>();
            String sql = "select * from orders where vehicle_id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, vehicle_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            getOrderData(orders3,resultSet);
            return orders3;
        } catch (
                SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}


