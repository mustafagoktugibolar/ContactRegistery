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
                    userData.setGender(resultSet.getString("gender"));
                    userData.setUser_id(resultSet.getInt("user_id"));
                    userData.setPhoto_id(resultSet.getInt("photo_id"));
                    // get data from photo_id, address_id and team_id
                    fetchAdditionalData(userData);
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

    private static void fetchAdditionalData(UserData userData) {
        // profile picture
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(Config.fetchProfilePictureQuery);
            preparedStatement.setInt(1, userData.getPhoto_id());

            try(ResultSet resultSet = preparedStatement.executeQuery()) {
                if(resultSet.next()) {
                    userData.getProfilePicture().setPhoto_id(resultSet.getInt("photo_id"));
                    userData.getProfilePicture().setPath(resultSet.getString("path"));
                    userData.getProfilePicture().setProfile_photo(resultSet.getBytes("profile_photo"));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        // address
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(Config.fetchAddressesQuery);
            preparedStatement.setInt(1, userData.getAddress_id());

            try(ResultSet resultSet = preparedStatement.executeQuery()) {
                if(resultSet.next()) {
                    userData.getAdress().setAddress_id(resultSet.getInt("address_id"));
                    userData.getAdress().setCountry(resultSet.getString("country"));
                    userData.getAdress().setCity(resultSet.getString("city"));
                    userData.getAdress().setPostalCode(resultSet.getString("postal_code"));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
