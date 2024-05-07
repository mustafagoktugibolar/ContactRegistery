package gui;

import Config.Config;
import data.UserData;
import helper.Helper;

import javax.swing.*;

public class TournamentPage extends JFrame {
    private UserData data = UserData.getInstance();
    private int row_id;

    public TournamentPage(int id) {
        super("Tournament");
        this.row_id = id;
        setSize(Config.appWidth, Config.appHeight);
        setLocation(Helper.getScreenCenter("x", getSize()), Helper.getScreenCenter("y", getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        initComponents();
        setVisible(true);
    }

    private void initComponents() {
        System.out.println(data.getTournaments().get(row_id).toString());
    }
}
