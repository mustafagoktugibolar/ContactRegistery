package models;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class TournamentsTableModel extends AbstractTableModel {
    //second data structure
    private ArrayList<Tournament> tournaments;

    public void setTournaments(HashMap<Integer, Tournament> tournamentMap) {
        this.tournaments = new ArrayList<>(tournamentMap.values());
    }

    private String[] columns = {"ID", "Name", "start date", "end date", "Team size"};

    public TournamentsTableModel(HashMap<Integer, Tournament> tournamentMap) {
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
        tournaments.sort(Comparator.comparing(Tournament::getTournament_name));
        fireTableDataChanged();
    }

    public void sortReverseAlphabetically() {
        tournaments.sort(Comparator.comparing(Tournament::getTournament_name).reversed());
        fireTableDataChanged();
    }

    public void sortByStartDate() {
        tournaments.sort(Comparator.comparing(Tournament::getTournament_start_date));
        fireTableDataChanged();
    }

    public void sortReverseByStartDate() {
        tournaments.sort(Comparator.comparing(Tournament::getTournament_start_date).reversed());
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
