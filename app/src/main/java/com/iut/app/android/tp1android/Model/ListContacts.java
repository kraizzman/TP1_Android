package com.iut.app.android.tp1android.Model;

import java.io.Serializable;
import java.util.ArrayList;

public class ListContacts implements Serializable {

    private ArrayList<UserData> contacts;

    public ListContacts() {
        contacts = new ArrayList<>();
    }

    public void addContact(UserData contact) {
        contacts.add(contact);
    }

    public void removeContact(UserData contact) {
        contacts.remove(contact);
    }

    public ArrayList<UserData> getContacts() {
        return contacts;
    }
}
