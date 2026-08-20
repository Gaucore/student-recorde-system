package ui.panel;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import ui.component.CardPanel;

public class StatusPanel extends CardPanel {

    public StatusPanel() {
        initialize();
    }

    private void initialize() {
        setLayout(new BorderLayout());
        JLabel title = new JLabel("System Status");
        title.setFont(new Font("Segoe UI", Font.BOLD, 18));
        add(title, BorderLayout.NORTH);

        JPanel panel = new JPanel(new GridLayout(3, 1, 5, 5));
        panel.setOpaque(false);
        panel.add(new JLabel("Database : Connected"));
        panel.add(new JLabel("Current User : Admin"));
        panel.add(new JLabel("Version : 1.0"));
        add(panel, BorderLayout.CENTER);
    }
}
