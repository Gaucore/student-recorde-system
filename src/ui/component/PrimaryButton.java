package ui.component;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;

public class PrimaryButton extends JButton {

    public PrimaryButton(String text) {
        super(text);
        initialize();
    }

    private void initialize() {
        setFont(new Font("SansSerif", Font.BOLD, 15));
        setBackground(new Color(25, 118, 210));
        setForeground(Color.WHITE);
        setFocusPainted(false);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setPreferredSize(new Dimension(140, 40));
    }

}
