package pl.coderslab.dao;

import pl.coderslab.DbUtil.DbUtil;
import pl.coderslab.classes.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeDao extends Employee {

    public EmployeeDao(String name, String lastname, String adress, String employee_phone, String note, int hourly) {
        super(name, lastname, adress, employee_phone, note, hourly);
    }

    public EmployeeDao() {

    }

    public void saveToDB() throws SQLException {
        try {
            Connection connection = DbUtil.getConn();
            if (this.getId() == 0) {
                String sql = "INSERT INTO employees (name,lastname,adress,employee_phone,note,hourly) values( ?, ?, ?, ?, ?, ?)";
                String generatedColumns[] = {"ID"};
                PreparedStatement preparedStatement = connection.prepareStatement(sql, generatedColumns);
                preparedStatement.setString(1, this.getName());
                preparedStatement.setString(2, this.getLastname());
                preparedStatement.setString(3, this.getAdress());
                preparedStatement.setString(4, this.getEmployee_phone());
                preparedStatement.setString(5, this.getNote());
                preparedStatement.setInt(6, this.getHourly());
                preparedStatement.executeUpdate();
                ResultSet resultSet = preparedStatement.getGeneratedKeys();
                if (resultSet.next()) {
                    this.setId(resultSet.getInt(1));
                }
            } else {
                String sql = "update employees set name=?, lastname=?,adress=?, employee_phon=?, note=?,hourly=? where id=?";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, this.getName());
                preparedStatement.setString(2, this.getLastname());
                preparedStatement.setString(3, this.getAdress());
                preparedStatement.setString(4, this.getEmployee_phone());
                preparedStatement.setString(5, this.getNote());
                preparedStatement.setInt(6, this.getHourly());
                preparedStatement.setInt(7, this.getId());
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
                String sql = "delete from employees where id=?";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, this.getId());
                preparedStatement.executeUpdate();
                this.setId(0);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private static void getEmployeeData(ArrayList<EmployeeDao> employees, ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            EmployeeDao employeeDao = new EmployeeDao();

            employeeDao.setId(resultSet.getInt("id"));
            employeeDao.setName(resultSet.getString("name"));
            employeeDao.setLastname(resultSet.getString("lastname"));
            employeeDao.setAdress(resultSet.getString("adress"));
            employeeDao.setEmployee_phone(resultSet.getString("employee_phone"));
            employeeDao.setNote(resultSet.getString("note"));
            employeeDao.setHourly(resultSet.getInt("hourly"));

            employees.add(employeeDao);
        }
    }

    public static ArrayList<EmployeeDao> loadAll() {
        try {
            Connection connection = DbUtil.getConn();
            ArrayList<EmployeeDao> employeeDaos = new ArrayList<>();
            String sql = "SELECT * FROM employees";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            getEmployeeData(employeeDaos, resultSet);
            return employeeDaos;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public void updateDb() throws SQLException {
        try {
            Connection connection = DbUtil.getConn();
            String sql = "update employees set name=?, lastname=?,adress=?, employee_phone=?, note=?,hourly=? where id=?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, this.getName());
            preparedStatement.setString(2, this.getLastname());
            preparedStatement.setString(3, this.getAdress());
            preparedStatement.setString(4, this.getEmployee_phone());
            preparedStatement.setString(5, this.getNote());
            preparedStatement.setInt(6, this.getHourly());
            preparedStatement.setInt(7, this.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static ArrayList<EmployeeDao> EmployeeDetails(int id) throws SQLException {
        try {
            ArrayList<EmployeeDao> employeeDaos = new ArrayList<>();
            Connection connection = DbUtil.getConn();
            String sql = "select * from employees where id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            getEmployeeData(employeeDaos,resultSet);
            return employeeDaos;
        } catch (
                SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


}
