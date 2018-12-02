package pl.coderslab.dao;

import pl.coderslab.DbUtil.DbUtil;
import pl.coderslab.classes.Raport1;

import java.sql.*;
import java.util.ArrayList;

public class Raport1Dao extends Raport1 {

//    public static ArrayList<ArrayList> rap1(String date_start, String date_end) {
//        try {
//            ArrayList<String> arrayIner = new ArrayList<>();
//            ArrayList<ArrayList> arrayOut = new ArrayList<>();
//            Connection connection = DbUtil.getConn();
//            String sql = "SELECT CONCAT(name, ' ' , lastname)  AS 'Dane' , SUM(orders.man_hours) AS 'Roboczogodziny' FROM orders LEFT JOIN employees ON orders.employee_id=employees.id WHERE  started_date BETWEEN '2017-01-01' AND '2018-11-01' GROUP BY employee_id;";
//
//            PreparedStatement preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setString(1, date_start);
//            preparedStatement.setString(2, date_end);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()) {
//                arrayIner.add(resultSet.getString("Dane"));
//                arrayIner.add(resultSet.getString("Roboczogodziny"));
//                arrayOut.add(arrayIner);
//            }
//            return arrayOut;
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return null; //czy ma coś zwrócić
//    }

    public static ArrayList<Raport1Dao> getRaport1(String date_start, String date_end) {

        try {

            Connection connection = DbUtil.getConn();
            ArrayList<Raport1Dao> orders = new ArrayList<>();
            String sql = "SELECT CONCAT(name, ' ' , lastname)  AS 'Imie_i_Nazwisko' , SUM(orders.man_hours) AS 'Roboczogodziny' FROM orders LEFT JOIN employees ON orders.employee_id=employees.id WHERE  started_date BETWEEN '2017-01-01' AND '2018-11-01' GROUP BY employee_id;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, date_start);
            preparedStatement.setString(2, date_end);
            ResultSet resultSet = preparedStatement.executeQuery();
            getOrderData(orders, resultSet);
            return orders;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static void getOrderData(ArrayList<Raport1Dao> OrderLista, ResultSet resultSet) throws SQLException {
        try {
            while (resultSet.next()) {
                Raport1Dao loadedOrder = new Raport1Dao();
                loadedOrder.setImie_i_Nazwisko(resultSet.getString("Imie_i_Nazwisko"));
                loadedOrder.setRoboczogodziny(Integer.parseInt(resultSet.getString("Roboczogodziny")));
                OrderLista.add(loadedOrder);
            }
        } catch (NumberFormatException e) {
            System.out.println("błąd raportu1 - numberformat");;
        }
    }
}
