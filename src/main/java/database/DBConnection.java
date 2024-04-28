package database;

import Config.Config;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    private Connection connection = null;

    private Connection connectDB(){
        try {
            Class.forName(Config.DB_CLASSNAME);
            this.connection = DriverManager.getConnection(Config.DB_URL, Config.DB_USER, Config.DB_PASSWORD);

        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return connection;
    }
    public static Connection getInstance(){
        DBConnection db = new DBConnection();
        System.out.println("Connected to database!");
        return  db.connectDB();
    }
}
