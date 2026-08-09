package ui.component;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.JButton;

public class MenuButton extends JButton {

    public MenuButton(String text) {
        super(text);

        setMaximumSize(new Dimension(Integer.MAX_VALUE, 45));
        setAlignmentX(Component.CENTER_ALIGNMENT);
        setFocusPainted(false);
        setCursor(new Cursor(Cursor.HAND_CURSOR));

    }
}
