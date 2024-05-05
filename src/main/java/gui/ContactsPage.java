package gui;

import Config.Config;
import data.UserData;
import helper.Helper;

import javax.swing.*;

public class ContactsPage extends JFrame {
    private UserData data = UserData.getInstance();
    private JButton profileButton;
    public ContactsPage() {
        setTitle("welcome " + data.getFirstName());
        setSize(Config.appWidth, Config.appHeight);
        setLocation(Helper.getScreenCenter("x", getSize()), Helper.getScreenCenter("y", getSize()));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        initComponents();
        setVisible(true);

    }
    private void initComponents() {
        profileButton = new JButton("Profile");
        profileButton.setBounds(100, getSize().height - 300, 50, 50);
        profileButton.addActionListener(e -> {
            new ProfilePage();
        });
        add(profileButton);

    }
}
