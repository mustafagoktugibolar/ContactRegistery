package controller;

import Config.Config;
import database.DBConnection;
import models.Tournament;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateTournamentController {
    private static Connection connection = DBConnection.getInstance();

    public static boolean createTournament(Tournament tournament) {
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(Config.saveTournamentQuery);
            preparedStatement.setString(1, tournament.getTournament_name());
            preparedStatement.setDate(2, tournament.getTournament_start_date());
            preparedStatement.setDate(3, tournament.getTournament_end_date());
            preparedStatement.setInt(4, tournament.getTeam_size());

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected == 0) {
                throw new SQLException("Failed to create tournament.");
            }else{
                return true;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
