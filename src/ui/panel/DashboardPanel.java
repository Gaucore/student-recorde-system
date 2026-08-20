package ui.panel;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class DashboardPanel extends JPanel {

    public DashboardPanel() {
        initialize();
    }

    private void initialize() {

        setLayout(new BorderLayout(20, 20));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(new StatisticsPanel(), BorderLayout.NORTH);
        JPanel center = new JPanel(new GridLayout(1, 2, 20, 20));
        center.setOpaque(false);
        center.add(new QuickActionPanel());
        center.add(new ActivityPanel());
        add(center, BorderLayout.CENTER);
        add(new StatusPanel(), BorderLayout.SOUTH);
    }
}
