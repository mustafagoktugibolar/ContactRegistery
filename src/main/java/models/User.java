package models;

import interfaces.IUser;

import java.util.ArrayList;
import java.util.List;

public class User implements IUser {
    private int userId;
    private String userName;
    private String password;
    private String email;
    private String phone;
    private List<ContactList> contactList;

    public User(int userId, String userName, String password, String email, String phone) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.contactList = new ArrayList<>();
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
