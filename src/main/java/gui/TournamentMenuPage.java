package gui;

import Config.Config;
import controller.TournamentMenuPageController;
import data.UserData;
import helper.Helper;
import interfaces.ITournamentObserver;
import jcomponents.CenteredTextRenderer;
import models.TournamentTableModel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TournamentMenuPage extends JFrame implements ITournamentObserver {
    private UserData data = UserData.getInstance();
    private JButton profileButton;
    private JButton createTournamentButton;
    private JLabel sortByLabel;
    private JComboBox sortByComboBox;
    private JTable tournamentTable;
    private JLabel profileLabel;
    private JButton refreshButton;

    public TournamentMenuPage() {
        setTitle("welcome " + data.getFirstName());
        setSize(Config.appWidth, Config.appHeight);
        setLocation(Helper.getScreenCenter("x", getSize()), Helper.getScreenCenter("y", getSize()));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        initComponents();
        setVisible(true);
        TournamentMenuPageController.addObserver(this);
    }
    private void initComponents() {
        // profile button
        profileButton = new JButton();
        profileButton.setBounds(810, 75, 130, 130);
        profileButton.setIcon(Helper.fitImage(data.getProfilePicture().getProfile_photo(), profileButton.getWidth(),profileButton.getHeight()));
        profileButton.addActionListener(e -> {
            new ProfilePage();
        });
        add(profileButton);

        // profile label
        profileLabel = new JLabel(data.getFullName());
        profileLabel.setHorizontalAlignment(SwingConstants.CENTER);
        profileLabel.setBounds(810, 205, 130,30);
        profileLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
        add(profileLabel);


        // create tournament button
        createTournamentButton = new JButton("Create Tournament");
        createTournamentButton.setBounds(800, 250, 150, 40);
        createTournamentButton.addActionListener(e -> {
            new CreateTournamentPage();
        });
        add(createTournamentButton);
        data.setTournaments(TournamentMenuPageController.getTournaments());

        // tournament table
        TournamentTableModel tournamentTableModel = new TournamentTableModel(data.getTournaments());
        tournamentTable = new JTable(tournamentTableModel);
        tournamentTable.setBounds(100,75,650,500);

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

        // add clicking action
        tournamentTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) { // Check for double-click
                    int selectedRow = tournamentTable.getSelectedRow();
                    if (selectedRow != -1) {
                        int row = tournamentTable.rowAtPoint(e.getPoint());
                        if (row != -1) {
                            Object id = tournamentTable.getValueAt(row, 0);
                            System.out.println("ID from clicked row: " + id);
                            new TournamentPage((int)id);
                            updateTournaments();
                        }
                    }
                }
            }
        });
        add(tournamentTable);

        // Create a JScrollPane and set the table as its view
        JScrollPane scrollPane = new JScrollPane(tournamentTable);

        // Set bounds for the scroll pane
        scrollPane.setBounds(100, 75, 650, 500);

        // Add the scroll pane to the panel
        add(scrollPane);

        // sort by label
        sortByLabel = new JLabel("Sort By");
        sortByLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
        sortByLabel.setForeground(Color.GRAY);
        sortByLabel.setBounds(781, 314, 150, 30);
        add(sortByLabel);

        // sort by combobox
        sortByComboBox = new JComboBox(new String[] {"Ascending Alphabetical", "Descending Alphabetical", "Ascending Date", "Descending Date"});
        sortByComboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
        sortByComboBox.setBackground(Color.white);
        sortByComboBox.setForeground(Color.DARK_GRAY);
        sortByComboBox.setBounds(775, 335, 200, 30);
        sortByComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox cb = (JComboBox) e.getSource();
                switch ((String) cb.getSelectedItem()) {
                    case "Ascending Alphabetical":
                        tournamentTableModel.sortAlphabetically();
                        break;
                    case "Descending Alphabetical":
                        tournamentTableModel.sortReverseAlphabetically();
                        break;
                    case "Ascending Date":
                        tournamentTableModel.sortByStartDate();
                        break;
                    case "Descending Date":
                        tournamentTableModel.sortReverseByStartDate();
                        break;
                }
            }
        });
        add(sortByComboBox);

        // refresh button
        refreshButton = new JButton("Refresh");
        refreshButton.setBounds(800, 450, 150, 40);
        refreshButton.addActionListener(e -> {
            updateTournaments();
        });
        add(refreshButton);
    }


    @Override
    public void updateTournaments() {
        // Refresh the table data
        data.setTournaments(TournamentMenuPageController.getTournaments());

        // Update the existing table model with the new tournament data
        TournamentTableModel tournamentTableModel = (TournamentTableModel) tournamentTable.getModel();
        tournamentTableModel.setTournaments(data.getTournaments());
        tournamentTableModel.fireTableDataChanged(); // Notify the table model about the data change
    }

}
