package models;

import java.sql.Date;

public class Tournament {
    private int tournament_id;
    private String tournament_name;
    private Date tournament_start_date;
    private Date tournament_end_date;
    private String location;
    private int home_team_id;
    private int away_team_id;
    private int team_size;


    public int getTeam_size() {
        return team_size;
    }

    public void setTeam_size(int team_size) {
        this.team_size = team_size;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getTournament_id() {
        return tournament_id;
    }

    public void setTournament_id(int tournament_id) {
        this.tournament_id = tournament_id;
    }

    public String getTournament_name() {
        return tournament_name;
    }

    public void setTournament_name(String tournament_name) {
        this.tournament_name = tournament_name;
    }

    public Date getTournament_start_date() {
        return tournament_start_date;
    }

    public void setTournament_start_date(Date tournament_start_date) {
        this.tournament_start_date = tournament_start_date;
    }

    public Date getTournament_end_date() {
        return tournament_end_date;
    }

    public void setTournament_end_date(Date tournament_end_date) {
        this.tournament_end_date = tournament_end_date;
    }

    public int getHome_team_id() {
        return home_team_id;
    }

    public void setHome_team_id(int home_team_id) {
        this.home_team_id = home_team_id;
    }

    public int getAway_team_id() {
        return away_team_id;
    }

    public void setAway_team_id(int away_team_id) {
        this.away_team_id = away_team_id;
    }
}
