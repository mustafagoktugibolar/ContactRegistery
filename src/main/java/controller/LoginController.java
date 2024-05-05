package controller;

import Config.Config;
import data.UserData;
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
                if(resultSet.next()) {
                    UserData userData = UserData.getInstance();
                    userData.setEmail(resultSet.getString("email"));
                    userData.setPassword(resultSet.getString("password"));
                    userData.setFirstName(resultSet.getString("firstName"));
                    userData.setLastName(resultSet.getString("lastName"));
                    userData.setPhone(resultSet.getString("phonenumber"));
                    userData.setUserName(resultSet.getString("username"));
                    userData.setAddress_id(resultSet.getInt("address_id"));
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
