package gui;

import Config.Config;
import controller.CreateTournamentController;
import helper.Helper;
import models.Tournament;
import javax.swing.*;
import java.awt.*;

public class CreateTournamentPage extends JFrame {
    private JLabel tournamentName;
    private JTextField tournamentNameField;
    private JLabel startDateLabel;
    private JTextField startDateTextField;
    private JLabel endDateLabel;
    private JTextField endDateTextField;
    private JButton createTournamentButton;
    private JComboBox<Integer> teamSizeComboBox;
    private JLabel teamSizeLabel;

    public CreateTournamentPage() {
        super("Create Tournament");
        setSize(Config.appWidth, Config.appHeight);
        setLocation(Helper.getScreenCenter("x", getSize()), Helper.getScreenCenter("y", getSize()));
        setResizable(false);
        setLayout(null);
        initComponents();
        setVisible(true);
    }

    private void initComponents() {
        // tournament name label
        tournamentName = new JLabel("Tournament Name");
        tournamentName.setFont(new Font("Tahoma", Font.PLAIN, 13));
        tournamentName.setForeground(Color.GRAY);
        tournamentName.setBounds(100, 100, 120, 10);
        add(tournamentName);

        // tournament text field
        tournamentNameField = new JTextField();
        tournamentNameField.setFont(new Font("Tahoma", Font.PLAIN, 19));
        tournamentNameField.setBackground(Color.white);
        tournamentNameField.setForeground(Color.DARK_GRAY);
        tournamentNameField.setBounds(100, 120, 200, 30);
        add(tournamentNameField);

        // start date label
        startDateLabel = new JLabel("Start Date");
        startDateLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
        startDateLabel.setForeground(Color.GRAY);
        startDateLabel.setBounds(100, 280, 120, 10);
        add(startDateLabel);

        // start date text field
        startDateTextField = new JTextField();
        startDateTextField.setFont(new Font("Tahoma", Font.PLAIN, 19));
        startDateTextField.setBackground(Color.white);
        startDateTextField.setForeground(Color.DARK_GRAY);
        startDateTextField.setBounds(100, 300, 200, 30);
        add(startDateTextField);

        // end date
        endDateLabel = new JLabel("End Date");
        endDateLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
        endDateLabel.setForeground(Color.GRAY);
        endDateLabel.setBounds(100, 350, 120, 10);
        add(endDateLabel);

        // end date text field
        endDateTextField = new JTextField();
        endDateTextField.setFont(new Font("Tahoma", Font.PLAIN, 19));
        endDateTextField.setBackground(Color.white);
        endDateTextField.setForeground(Color.DARK_GRAY);
        endDateTextField.setBounds(100, 370, 200, 30);
        add(endDateTextField);

        // team combo box label
        teamSizeLabel = new JLabel("Team Size");
        teamSizeLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
        teamSizeLabel.setForeground(Color.GRAY);
        teamSizeLabel.setBounds(100, 410, 120, 10);
        add(teamSizeLabel);

        // team size combo box
        teamSizeComboBox = new JComboBox<>(new Integer[]{8, 16, 32});
        teamSizeComboBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
        teamSizeComboBox.setBackground(Color.white);
        teamSizeComboBox.setForeground(Color.DARK_GRAY);
        teamSizeComboBox.setBounds(100, 440, 200, 30);
        add(teamSizeComboBox);

        // create button
        createTournamentButton = new JButton("Create Tournament");
        createTournamentButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
        createTournamentButton.setForeground(Color.GRAY);
        createTournamentButton.setBackground(Color.DARK_GRAY);
        createTournamentButton.setBounds(100, 500, 120, 30);
        createTournamentButton.addActionListener(e -> {
            if(Helper.isFieldEmpty(tournamentNameField, startDateTextField, endDateTextField)) {
                Helper.showMessage("fill");
            }
            // create tournament object
            Tournament tournament = new Tournament();
            tournament.setTournament_name(tournamentNameField.getText());
            tournament.setTournament_start_date(Helper.isValidBirthDate(startDateTextField.getText()));
            tournament.setTournament_end_date(Helper.isValidBirthDate(endDateTextField.getText()));
            tournament.setTeam_size((int)(teamSizeComboBox.getSelectedItem()));

            // save object to database
            if(CreateTournamentController.createTournament(tournament)){
                Helper.showMessage("Success!", "Tournament created successfully");
                this.dispose();
            }
            else{
                Helper.showMessage("Error!", "Tournament creation failed");
            }
        });
        add(createTournamentButton);


    }
}
