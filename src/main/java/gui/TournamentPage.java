package gui;

import Config.Config;
import controller.TournamentController;
import controller.TournamentMenuPageController;
import data.UserData;
import helper.Helper;
import jcomponents.CenteredTextRenderer;
import models.Tournament;
import models.TournamentTableModel;
import models.User;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;


public class TournamentPage extends JFrame {
    private UserData data = UserData.getInstance();
    public static int row_id;
    private Tournament tournament;
    private JLabel tournamentNameLabel;
    private JLabel startDateLabel;
    private JLabel endDateLabel;
    private JLabel currentTeamsLabel;
    private JTable tournamentTable;


    public TournamentPage(int id) {
        super("Tournament");
        this.row_id = id;
        tournament = data.getTournaments().get(id);
        setSize(Config.appWidth, Config.appHeight);
        setLocation(Helper.getScreenCenter("x", getSize()), Helper.getScreenCenter("y", getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        initComponents();
        setVisible(true);
    }

    private void initComponents() {
        System.out.println(tournament.toString());
        System.out.println(tournament.getTeam_ids().toString());
        tournament.setTeam_ids(TournamentController.fetchTeamIds(tournament.getTournament_id()));
        // tournament label
        tournamentNameLabel = new JLabel(tournament.getTournament_name());
        tournamentNameLabel.setFont(new Font("Tahoma", Font.BOLD, 34));
        tournamentNameLabel.setBounds(60,20, 400,100);
        add(tournamentNameLabel);

        // start date label
        startDateLabel = new JLabel("<HTML><div style=\" text-align: left;\"><b>Start Date:</b></div><div>" + tournament.getTournament_start_date() + "</div></HTML>");
        startDateLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        startDateLabel.setBounds(90,100, 400,100);
        add(startDateLabel);

        // end date label
        endDateLabel = new JLabel("<HTML><div style=\" text-align: left;\"><b> End Date:</b></div><div>" + tournament.getTournament_end_date() + "</div></HTML>");
        endDateLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        endDateLabel.setBounds(90,150, 400,100);
        add(endDateLabel);

        // current teams label
        currentTeamsLabel = new JLabel("Current Teams:");
        currentTeamsLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        currentTeamsLabel.setBounds(90,240, 400,100);
        add(currentTeamsLabel);

        data.setTournaments(TournamentMenuPageController.getTournaments());
        HashMap<Integer, User> teams  = new HashMap<>();
        User user= new User();
        user.setUserName("deneme");
        user.setEmail("deneme1");
        user.setPassword("deneme");
        user.setFirstName("deneme");
        user.setLastName("deneme");
        user.setGender("Male");
        teams.put(1,user);

        // tournament table
        TournamentTableModel tournamentTableModel = new TournamentTableModel(TournamentController.getTeams());
        tournamentTable = new JTable(tournamentTableModel);
        tournamentTable.setBounds(300,65,650,500);

        // align the cell's text to center
        tournamentTable.setDefaultRenderer(Object.class, new CenteredTextRenderer());

        // draw borders to cells
        tournamentTable.setDefaultRenderer(Object.class, new CenteredTextRenderer.BorderRenderer(tournamentTable.getDefaultRenderer(Object.class)));
        tournamentTable.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        // set row height
        tournamentTable.setRowHeight(45);

        // selection setup
        tournamentTable.setDragEnabled(false);
        tournamentTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tournamentTable.getTableHeader().setReorderingAllowed(false);

        add(tournamentTable);

        // Create a JScrollPane and set the table as its view
        JScrollPane scrollPane = new JScrollPane(tournamentTable);

        // Set bounds for the scroll pane
        scrollPane.setBounds(300, 65, 650, 500);

        // Add the scroll pane to the panel
        add(scrollPane);

        // join button
        JButton joinButton = new JButton("Join Tournament");
        joinButton.setBounds(90, 320, 150, 30);
        joinButton.addActionListener(e -> {
            data.getTeam_ids().add(data.getUser_id());
            tournament.setTeam_ids(Helper.convertToIntegerArray(data.getTeam_ids()));
                boolean success = TournamentController.addTeam(tournament.getTeam_ids(), row_id);
                if (success) {
                    for (Integer team_id : tournament.getTeam_ids()) {
                        System.out.println(team_id);
                    }
                    JOptionPane.showMessageDialog(this, "Team added successfully.");
                    this.dispose();
                    // Update the table or refresh the view if needed
                } else {
                    JOptionPane.showMessageDialog(this, "Failed to add team. Please try again.");
                }
        });
        add(joinButton);
    }
}
