package data;

import database.DBConnection;
import interfaces.IUser;
import models.*;

import java.sql.Connection;
import java.util.HashMap;

public class UserData extends User implements IUser {
    //singleton object
    private static final UserData USER_DATA = new UserData();

    public Address adress = new Address();
    public ProfilePicture profilePicture = new ProfilePicture();
    public HashMap<Integer, Tournament> tournaments = new HashMap<>();

    // database connection
    private static Connection connection = DBConnection.getInstance();

    private UserData(){

    }

    public static Connection getConnection() {
        return connection;
    }

    public static void setConnection(Connection connection) {
        UserData.connection = connection;
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
