package controller;

import Config.Config;
import database.DBConnection;
import models.User;

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
                if(resultSet.next()) {
                    User user = User.currentUser = new User();
                    user.setEmail(resultSet.getString("email"));
                    user.setPassword(resultSet.getString("password"));
                    user.setFirstName(resultSet.getString("firstName"));
                    user.setLastName(resultSet.getString("lastName"));
                    user.setPhone(null);
                    user.setUserName(resultSet.getString("username"));
                    user.setAddress_id(resultSet.getInt("address_id"));
                    return true; // if user logged in  successfully
                }
                else {
                    return false;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // for any error return false
        }
    }

}
