package data;

import interfaces.IUser;
import models.*;
import java.util.ArrayList;
import java.util.HashMap;

public class UserData extends User implements IUser {
    //singleton object
    private static final UserData USER_DATA = new UserData();

    public Address adress = new Address();

    public ProfilePicture profilePicture = new ProfilePicture();
    //first data structure
    public HashMap<Integer, Tournament> tournaments = new HashMap<>();

    public ArrayList<Integer> team_ids = new ArrayList<>();

    private UserData(){}

    public ArrayList<Integer> getTeam_ids() {
        return team_ids;
    }

    public void setTeam_ids(ArrayList<Integer> team_ids) {
        this.team_ids = team_ids;
    }

    public HashMap<Integer, Tournament> getTournaments() {
        return tournaments;
    }

    public void setTournaments(HashMap<Integer, Tournament> tournaments) {
        this.tournaments = tournaments;
    }


    public ProfilePicture getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(ProfilePicture profilePicture) {
        this.profilePicture = profilePicture;
    }

    public Address getAdress() {
        return adress;
    }

    public void setAdress(Address adress) {
        this.adress = adress;
    }

    // to access singleton object from other classes
    public static UserData getInstance() {
        return USER_DATA;
    }
}
