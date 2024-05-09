package models;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.HashMap;

public class TournamentTableModel extends AbstractTableModel {
    //second data structure
    private ArrayList<User> users;


    public void setUsers(HashMap<Integer, User> users) {
        this.users = new ArrayList<>(users.values());
    }

    private String[] columns = {"firstName", "lastName", "email","Phone Number"};

    public TournamentTableModel(ArrayList<User> arrayList) {
        this.users = arrayList;
    }

    @Override
    public int getRowCount() {
        return users.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        User user = users.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return user.getFirstName();
            case 1:
                return user.getLastName();
            case 2:
                return user.getEmail();
            case 3:
                return user.getPhoneNumber();

            default:
                return null;
        }
    }
}
