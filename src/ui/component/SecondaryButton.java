package ui.component;

import java.awt.Cursor;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

public class SecondaryButton extends JButton {

    public SecondaryButton(String text) {
        super(text);
        initialize();
    }

    private void initialize() {
        setFocusPainted(false);

        setFont(new Font("Segoe UI", Font.BOLD, 15));

        setBorder(new EmptyBorder(10, 20, 10, 20));

        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
}
