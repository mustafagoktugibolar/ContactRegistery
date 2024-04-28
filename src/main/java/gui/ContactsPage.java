package gui;

import Config.Config;
import helper.Helper;
import models.User;

import javax.swing.*;

public class ContactsPage extends JFrame {
    public ContactsPage() {
        setTitle("welcome " + User.currentUser.getFirstName());
        setSize(Config.appWidth, Config.appHeight);
        setLocation(Helper.getScreenCenter("x", getSize()), Helper.getScreenCenter("y", getSize()));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        initComponents();
        setVisible(true);

    }
    private void initComponents() {

    }
}
