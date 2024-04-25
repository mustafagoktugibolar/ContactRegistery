package models;

import interfaces.IContactList;
import java.util.List;

public class ContactList implements IContactList {
    private int listId;
    private String listName;
    private List<Contact> contacts;

    public ContactList(int listId, String listName, List<Contact> contacts) {
        this.listId = listId;
        this.listName = listName;
        this.contacts = contacts;
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
}
