package ui.component;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;

public class SecondaryButton extends JButton {

    public SecondaryButton(String text) {
        super(text);
        initialize();
    }

    private void initialize() {
        setFont(new Font("SansSerif", Font.BOLD, 15));
        setBackground(new Color(100, 117, 125));
        setForeground(Color.WHITE);
        setFocusPainted(false);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setPreferredSize(new Dimension(140, 40));
    }
}
