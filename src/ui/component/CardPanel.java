package ui.component;

import javax.swing.*;
import javax.swing.border.*;

import config.Theme;

import java.awt.*;

public class CardPanel extends JPanel {

    public CardPanel() {
        initialize();
    }

    private void initialize() {
        setBackground(Theme.CARD);
        setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(new Color(220, 220, 220)),
                new EmptyBorder(20, 20, 20, 20)));
    }
}
