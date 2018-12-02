package pl.coderslab.dao;

import pl.coderslab.DbUtil.DbUtil;
import pl.coderslab.classes.Status;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StatusDao extends Status {

    public StatusDao(String status) {
        super(status);
    }

    public StatusDao() {
    }

    public void saveToDB() throws SQLException {
        try {
            Connection connection = DbUtil.getConn();
            if (this.getId() == 0) {
                String sql = "insert into status (status) values (?);";
                String generatedColumns[] = {"ID"};
                PreparedStatement preparedStatement = connection.prepareStatement(sql, generatedColumns);
                preparedStatement.setString(1, this.getStatus());
                preparedStatement.executeUpdate();
                ResultSet resultSet = preparedStatement.getGeneratedKeys();
                if (resultSet.next()) {
                    this.setId(resultSet.getInt(1));
                }
            } else {
                String sql = "update status set status=? where id=?";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, this.getStatus());
                preparedStatement.setInt(2, this.getId());
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
                String sql = "delete from status where id=?";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, this.getId());
                preparedStatement.executeUpdate();
                this.setId(0);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<StatusDao> loadAllStatus() {
        try {
            Connection connection = DbUtil.getConn();
            ArrayList<StatusDao> statusDaos = new ArrayList<>();
            String sql = "SELECT * FROM status";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            getStatusDate(statusDaos, resultSet);
            return statusDaos;
        } catch (SQLException e) {
            System.out.println("Błąd load all");
        }
        return null;
    }

    private static void getStatusDate(ArrayList<StatusDao> statusDaos, ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            StatusDao loadedStatuses = new StatusDao();
            loadedStatuses.setId(resultSet.getInt("id"));
            loadedStatuses.setStatus(resultSet.getString("status"));
            statusDaos.add(loadedStatuses);
        }
    }
}
