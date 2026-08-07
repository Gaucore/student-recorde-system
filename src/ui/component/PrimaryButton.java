package ui.component;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

import config.Theme;

public class PrimaryButton extends JButton {

    public PrimaryButton(String text) {
        super(text);
        initialize();
    }

    private void initialize() {
        setFont(new Font("SansSerif", Font.BOLD, 15));
        setForeground(Color.WHITE);
        setBackground(Theme.PRIMARY);
        setBorder(new EmptyBorder(10, 20, 10, 20));
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        ;
    }

}
