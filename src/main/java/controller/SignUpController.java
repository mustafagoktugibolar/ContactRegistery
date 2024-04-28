package controller;

import database.DBConnection;
import models.Address;
import models.User;

import java.sql.*;

public class SignUpController {
    private static Connection connection = DBConnection.getInstance();

    // saving address
    public static int saveAddressToDatabase(Address address) {
        String query = "INSERT INTO addresses (country, city, postal_code) VALUES (?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, address.getCountry());
            preparedStatement.setString(2, address.getCity());
            preparedStatement.setString(3, address.getPostalCode());

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected == 0) {
                throw new SQLException("Failed to insert address.");
            }

            try (ResultSet resultSet = preparedStatement.getGeneratedKeys()) {
                if (resultSet.next()) {
                    return resultSet.getInt(1); // Otomatik artan sütunun indeksi 1'den başlar
                } else {
                    throw new SQLException("Failed to get ID of inserted address.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return -1; // if there is an error return -1
        }

    }

    // saving user
    public static boolean saveUserToDatabase(User user) {
        String query = "INSERT INTO users (username, password, address_id, firstname, lastname, phonenumber, email) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setInt(3, (int) user.getAddress_id());
            preparedStatement.setString(4, user.getFirstName());
            preparedStatement.setString(5, user.getLastName());
            preparedStatement.setString(6, user.getPhone());
            preparedStatement.setString(7, user.getEmail());

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
