package gui;

import Config.Config;
import data.UserData;
import helper.Helper;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ProfilePage extends JFrame {
    private UserData data = UserData.getInstance();
    private JLabel profileLogo;

    public ProfilePage() {
        super("Profile");
        setSize(Config.appWidth, Config.appHeight);
        setLocation(Helper.getScreenCenter("x", getSize()), Helper.getScreenCenter("y", getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        initComponents();
        setVisible(true);
    }

    private void initComponents() {
        // profile picture
        profileLogo = new JLabel(Helper.loadImageIcon("src/main/images/profile-logo.png"));
        profileLogo.setBounds(50,30, 100,100);
        profileLogo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // select picture to change profile picture
                String selectedPitcure = Helper.fileSelector(ProfilePage.this);
            }
        });
        add(profileLogo);

    }
}
