package models;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class TournamentTableModel extends AbstractTableModel {
    //second data structure
    private ArrayList<Tournament> tournaments;

    public ArrayList<Tournament> getTournaments() {
        return tournaments;
    }

    public void setTournaments(HashMap<Integer, Tournament> tournamentMap) {
        this.tournaments = new ArrayList<>(tournamentMap.values());
    }

    private String[] columns = {"ID", "Name", "start date", "end date", "Team size"}; // Adjust column names as per your requirements

    public TournamentTableModel(HashMap<Integer, Tournament> tournamentMap) {
        this.tournaments = new ArrayList<>(tournamentMap.values());

    }

    @Override
    public int getRowCount() {
        return tournaments.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    // Sorting methods
    public void sortAlphabetically() {
        Collections.sort(tournaments, Comparator.comparing(Tournament::getTournament_name));
        fireTableDataChanged();
    }

    public void sortReverseAlphabetically() {
        Collections.sort(tournaments, Comparator.comparing(Tournament::getTournament_name).reversed());
        fireTableDataChanged();
    }

    public void sortByStartDate() {
        Collections.sort(tournaments, Comparator.comparing(Tournament::getTournament_start_date));
        fireTableDataChanged();
    }

    public void sortReverseByStartDate() {
        Collections.sort(tournaments, Comparator.comparing(Tournament::getTournament_start_date).reversed());
        fireTableDataChanged();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Tournament tournament = tournaments.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return tournament.getTournament_id();
            case 1:
                return tournament.getTournament_name();
            case 2:
                return tournament.getTournament_start_date();
            case 3:
                return tournament.getTournament_end_date();
            case 4:
                return tournament.getTeam_size();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }
}
