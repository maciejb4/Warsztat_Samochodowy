package pl.coderslab.dao;

import pl.coderslab.DbUtil.DbUtil;
import pl.coderslab.classes.Customer;

import java.sql.*;
import java.util.ArrayList;

public class CustomerDao extends Customer {

    public CustomerDao(String name, String surname, Date birthDate, String customer_phone) {

        super(name, surname, birthDate, customer_phone);
    }

    public CustomerDao() {

    }

    public void saveToDB() throws SQLException {

        try {
            Connection connection = DbUtil.getConn();
            if (this.getId() == 0) {
                String sql = "insert into customers(name, surname, birthdate, customer_phone) values(?, ?, ?, ?)";
                String generatedColumns[] = {"ID"};
                PreparedStatement preparedStatement = connection.prepareStatement(sql, generatedColumns);
                preparedStatement.setString(1, this.getName());
                preparedStatement.setString(2, this.getSurname());
                preparedStatement.setDate(3, this.getBirthDate());
                preparedStatement.setString(4, this.getCustomer_phone());
                preparedStatement.executeUpdate();
                ResultSet resultSet = preparedStatement.getGeneratedKeys();
                if (resultSet.next()) {
                    this.setId(resultSet.getInt(1));
                }

            } else {
                String sql = "update customers set name=?, surname=?, birthdate=?, customer_phone=? where id=?";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, this.getName());
                preparedStatement.setString(2, this.getSurname());
                preparedStatement.setDate(3, this.getBirthDate());
                preparedStatement.setString(4, this.getCustomer_phone());
                preparedStatement.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();

        }
    }


    private static void getCustomerData(ArrayList<CustomerDao> CustomerLista, ResultSet resultSet) throws SQLException {

        while (resultSet.next()) {
            CustomerDao loadedCustomer = new CustomerDao();
            loadedCustomer.setId(resultSet.getInt("id"));
            loadedCustomer.setName(resultSet.getString("name"));
            loadedCustomer.setSurname(resultSet.getString("surname"));
            loadedCustomer.setBirthDate(resultSet.getDate("birthDate"));
            loadedCustomer.setCustomer_phone(resultSet.getString("customer_phone"));
            CustomerLista.add(loadedCustomer);
        }

    }

    public static ArrayList<CustomerDao> loadAll() {

        try {
            Connection connection = DbUtil.getConn();
            ArrayList<CustomerDao> customers = new ArrayList<>();
            String sql = "SELECT * FROM customers";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            getCustomerData(customers, resultSet);
            return customers;

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return null;
    }

    public static ArrayList<CustomerDao> loadCustomerBySurname(String surname) {
        try {
            Connection connection = DbUtil.getConn();
            ArrayList<CustomerDao> customers = new ArrayList<>();
            String sql = "SELECT * FROM customers WHERE surname = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, surname);
            ResultSet resultSet = preparedStatement.executeQuery();
            getCustomerData(customers, resultSet);
            return customers;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void editCustomer() throws SQLException {

        try {
            Connection connection = DbUtil.getConn();
            String sql = "update customers set name=?, surname=?, birthdate=?, customer_phone=? WHERE id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, this.getName());
            preparedStatement.setString(2, this.getSurname());
            preparedStatement.setDate(3, this.getBirthDate());
            preparedStatement.setString(4, this.getCustomer_phone());
            preparedStatement.setInt(5, this.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete() throws SQLException {

        try (Connection connection = DbUtil.getConn()) {
            if (this.getId() != 0) {
            }
            String sql = "DELETE FROM customers WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, this.getId());
            preparedStatement.executeUpdate();
            this.setId(0);

        } catch (SQLException e) {
            e.printStackTrace();

        }
    }


}


