package controller;

import Config.Config;
import database.DBConnection;
import interfaces.ITournamentObserver;
import models.Tournament;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class TournamentMenuPageController {
    private static Connection connection = DBConnection.getInstance();
    private static Set<ITournamentObserver> observers = new HashSet<>();

    public static HashMap<Integer, Tournament> getTournaments() {
        HashMap<Integer, Tournament> tournaments = new HashMap<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(Config.fetchTournamentQuery);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Tournament tournament = new Tournament();
                tournament.setTournament_id(resultSet.getInt("tournament_id"));
                tournament.setTournament_name(resultSet.getString("tournament_name"));
                tournament.setTournament_start_date(resultSet.getDate("start_date"));
                tournament.setTournament_end_date(resultSet.getDate("end_date"));
                tournament.setTeam_size(resultSet.getInt("team_size"));
                tournaments.put(tournament.getTournament_id(), tournament);
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return tournaments;
    }

    public static void addObserver(ITournamentObserver observer) {
        observers.add(observer);
    }

    public static void notifyObservers() {
        for (ITournamentObserver observer : observers) {
            observer.updateTournaments();
        }
    }

}
