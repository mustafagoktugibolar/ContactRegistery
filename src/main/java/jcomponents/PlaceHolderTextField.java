package jcomponents;
import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class PlaceHolderTextField extends JTextField implements FocusListener {
    private String placeholder;

    public PlaceHolderTextField(String placeholder) {
        this.placeholder = placeholder;
        addFocusListener(this);
        setForeground(Color.GRAY);
        setText(placeholder);
    }

    @Override
    public void focusGained(FocusEvent e) {
        if (getText().equals(placeholder)) {
            setText("");
            setForeground(Color.BLACK);
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (getText().isEmpty()) {
            setText(placeholder);
            setForeground(Color.GRAY);
        }
    }

    @Override
    public String getText() {
        String text = super.getText();
        return text.equals(placeholder) ? "" : text;
    }

    @Override
    public void setText(String t) {
        if (t == null || t.isEmpty()) {
            super.setText(placeholder);
            setForeground(Color.GRAY);
        } else {
            super.setText(t);
            setForeground(Color.BLACK);
        }
    }
}
