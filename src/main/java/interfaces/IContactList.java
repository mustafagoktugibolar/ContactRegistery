package interfaces;

import models.Contact;

public interface IContactList {
    void addContact(Contact contact);
    void removeContact(Contact contact);
    void updateContact(Contact contact);
}
