package controller;

import Config.Config;
import database.DBConnection;
import models.Address;
import models.ProfilePicture;
import models.User;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;

public class SignUpController {
    private static Connection connection = DBConnection.getInstance();

    // saving address
    public static int saveAddressToDatabase(Address address) {

        try (PreparedStatement preparedStatement = connection.prepareStatement(Config.saveAddressQuery, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, address.getCountry());
            preparedStatement.setString(2, address.getCity());
            preparedStatement.setString(3, address.getPostalCode());

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected == 0) {
                throw new SQLException("Failed to insert address.");
            }

            try (ResultSet resultSet = preparedStatement.getGeneratedKeys()) {
                if (resultSet.next()) {
                    return resultSet.getInt(1); // auto generated id starts at column 1
                } else {
                    throw new SQLException("Failed to get ID of inserted address.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return -1; // if there is an error return -1
        }

    }

    // save profile photo
    public static int saveProfilePictureToDatabase(ProfilePicture profilePicture) {
        try(PreparedStatement preparedStatement = connection.prepareStatement(Config.saveProfilePictureQuery, Statement.RETURN_GENERATED_KEYS)){
            // Convert File path to input stream
            File imageFile = new File(profilePicture.getUsername());
            FileInputStream inputStream = new FileInputStream(imageFile);
            System.out.println(inputStream.readAllBytes());
            //prepare statement
            preparedStatement.setString(1, profilePicture.getUsername());
            preparedStatement.setBytes(2, profilePicture.getProfile_photo());
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected == 0) {
                throw new SQLException("Failed to insert profile picture.");
            }
            try (ResultSet resultSet = preparedStatement.getGeneratedKeys()) {
                if (resultSet.next()) {
                    return resultSet.getInt(1);
                }else {
                    throw new SQLException("Failed to get ID of inserted profile picture.");
                }
            }
        }catch (SQLException | FileNotFoundException e){
            e.printStackTrace();
            return -1; // if there is an error
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // saving user
    public static boolean saveUserToDatabase(User user) {
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(Config.saveUserQuery);
            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setInt(3, (int)user.getAddress_id());
            preparedStatement.setString(4, user.getFirstName());
            preparedStatement.setString(5, user.getLastName());
            preparedStatement.setString(6, user.getPhoneNumber());
            preparedStatement.setString(7, user.getEmail());
            preparedStatement.setDate(8, user.getBirth_date());
            preparedStatement.setInt(9, (int)user.getTeam_id());
            preparedStatement.setInt(10, (int)user.getPhoto_id());
            preparedStatement.setString(11, user.getGender());

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected == 0) {
                throw new SQLException("Failed to insert user.");
            }else{
                return true;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
