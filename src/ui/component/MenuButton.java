package ui.component;

import config.Theme;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MenuButton extends JButton {

    public MenuButton(String text) {
        super(text);
        initialize();
    }

    private void initialize() {
        setMaximumSize(new Dimension(Integer.MAX_VALUE, 45));
        setMinimumSize(new Dimension(200, 45));
        setHorizontalAlignment(SwingConstants.LEFT);
        setFocusPainted(false);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setFont(new Font("Segoe UI", Font.BOLD, 15));
        setForeground(Color.WHITE);
        setBackground(Theme.SIDEBAR);
        setBorder(new EmptyBorder(0, 20, 0, 0));
        setOpaque(true);
        setBorderPainted(false);
        setContentAreaFilled(true);
    }
}