package ui.panel;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import ui.component.CardPanel;

public class ActivityPanel extends CardPanel {

    public ActivityPanel() {
        initialize();
    }

    private void initialize() {
        setLayout(new BorderLayout(10, 10));
        JLabel title = new JLabel("Recent Activity");
        title.setFont(new Font("Segoe UI", Font.BOLD, 20));
        add(title, BorderLayout.NORTH);
        JPanel activityPanel = new JPanel(new GridLayout(4, 1, 5, 5));
        activityPanel.setOpaque(false);

        activityPanel.add(new JLabel("✓ Student Added"));
        activityPanel.add(new JLabel("✓ Fee Collected"));
        activityPanel.add(new JLabel("✓ New Admission"));
        activityPanel.add(new JLabel("✓ Faculty Updated"));

        add(activityPanel, BorderLayout.CENTER);
    }
}