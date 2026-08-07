package ui.panel;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import config.Theme;

public abstract class BasePanel extends JPanel {

    public BasePanel() {
        initialize();
    }

    private void initialize() {
        setBackground(Theme.CARD);
        setLayout(new BorderLayout());
        setBorder(new EmptyBorder(20, 20, 20, 20));
    }

}
