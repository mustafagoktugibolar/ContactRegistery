package controller;

import Config.Config;
import data.UserData;
import database.DBConnection;
import gui.TournamentPage;
import helper.Helper;
import models.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TournamentController {
    private static Connection connection = DBConnection.getInstance();
    private static UserData data = UserData.getInstance();

    public static Integer[] fetchTeamIds(int tournamentId){
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(Config.fetchTeamIdsQuery);
            preparedStatement.setInt(1,tournamentId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                Array teamIds = resultSet.getArray("team_ids");
                Integer[] arr = (Integer[]) teamIds.getArray();
                return arr;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return new Integer[0];
    }

    public static ArrayList<User> getTeams() {
        ArrayList<User> teams = new ArrayList<>();


        StringBuilder sql = new StringBuilder("SELECT * FROM users WHERE user_id IN(");
        ArrayList<Integer> team_ids = Helper.convertToArrayList(fetchTeamIds(TournamentPage.row_id));
        for (int i = 0; i < team_ids.size(); i++) {
            if (i > 0) {
                sql.append(", ");
            }
            sql.append("?");
        }
        sql.append(")");
        System.out.println(sql.toString());
        try {
            // Prepare SQL statement
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql.toString())) {
                // Set the team_ids array as parameter
                for (int i = 0; i < team_ids.size(); i++) {
                    preparedStatement.setInt(i + 1, team_ids.get(i));
                }
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        User userData = new User();
                        // Populate User object
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
                        teams.add(userData);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return teams;
    }

    public static boolean addTeam(Integer[] team_ids, int tournamentId) {
        try {
            Integer[] old_team_ids = fetchTeamIds(tournamentId);
            System.out.println(old_team_ids);
            for (int i = 0; i < old_team_ids.length; i++) {
                if (old_team_ids[i] == 18){
                    old_team_ids[i] = data.getUser_id();
                    break;
                }
            }
            System.out.println(old_team_ids);
            Connection connection = DBConnection.getInstance();
            Array team_ids_array = connection.createArrayOf("INTEGER", old_team_ids);
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE tournaments SET team_ids = ? WHERE tournament_id = ?;");
            preparedStatement.setArray(1, team_ids_array);// this must be an array
            preparedStatement.setInt(2, tournamentId);
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
