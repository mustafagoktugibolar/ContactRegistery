package controller;

import Config.Config;
import database.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginController {
    private static Connection connection = DBConnection.getInstance();

    public static boolean login(String email, String password) {
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(Config.loginQuery);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                return resultSet.next(); // if user exists return true
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // for any error return false
        }
    }

}
