package gui;

import Config.Config;
import data.UserData;
import helper.Helper;

import javax.swing.*;

public class TournamentPage extends JFrame {
    private UserData data = UserData.getInstance();
    private JButton profileButton;
    private JButton enterTournamentButton;
    private JButton createTournamentButton;
    private JLabel selectCountryLabel;
    private JComboBox countryComboBox;
    private JLabel selectCityLabel;
    private JComboBox selectCityComboBox;

    public TournamentPage() {
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
        // profile button
        profileButton = new JButton();
        profileButton.setBounds(900, 20, 75, 75);
        profileButton.setIcon(Helper.fitImage(data.getProfilePicture().getProfile_photo(), profileButton.getWidth(),profileButton.getHeight()));
        profileButton.addActionListener(e -> {
            new ProfilePage();
        });
        add(profileButton);

        // create tournament button
        createTournamentButton = new JButton("Create Tournament");
        createTournamentButton.setBounds(800, 20, 75, 40);
        createTournamentButton.addActionListener(e -> {
            new CreateTournamentPage();
        });
        add(createTournamentButton);

        //

    }
}
