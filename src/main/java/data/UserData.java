package data;

import database.DBConnection;
import interfaces.IUser;
import models.Contact;
import models.ContactList;
import models.User;
import java.sql.Connection;

public class UserData extends User implements IUser {
    //singleton object
    private static final UserData USER_DATA = new UserData();

    // database connection
    private static Connection connection = DBConnection.getInstance();

    private UserData(){

    }

    // to access singleton object from other classes
    public static UserData getInstance() {
        return USER_DATA;
    }

    @Override
    public void addContact(Contact contact) {

    }

    @Override
    public void removeContact(Contact contact) {

    }

    @Override
    public void updateContact(Contact contact) {

    }

    @Override
    public void addContactList(ContactList contactList) {

    }

    @Override
    public void removeContactList(ContactList contactList) {

    }

    @Override
    public void printContacts() {

    }
}
