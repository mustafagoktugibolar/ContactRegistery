package interfaces;

import models.Contact;
import models.ContactList;

public interface IUser {
    void addContact(Contact contact);
    void removeContact(Contact contact);
    void updateContact(Contact contact);
    void addContactList(ContactList contactList);
    void removeContactList(ContactList contactList);
    void printContacts();

}
