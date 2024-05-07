package jcomponents;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class CenteredTextRenderer extends DefaultTableCellRenderer {
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                   boolean hasFocus, int row, int column) {
        Component rendererComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        ((JLabel) rendererComponent).setHorizontalAlignment(SwingConstants.CENTER);
        return rendererComponent;
    }

    public static class BorderRenderer implements TableCellRenderer {
        private TableCellRenderer originalRenderer;

        public BorderRenderer(TableCellRenderer originalRenderer) {
            this.originalRenderer = originalRenderer;
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component component = originalRenderer.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            ((JComponent) component).setBorder(BorderFactory.createLineBorder(Color.BLACK)); // Add border
            return component;
        }
    }
}

