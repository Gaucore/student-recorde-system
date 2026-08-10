package ui.panel;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class DashboardPanel extends JPanel {

    public DashboardPanel() {
        initialize();
    }

    private void initialize() {

        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(new StatisticsPanel(), BorderLayout.NORTH);
        add(new QuickActionPanel(), BorderLayout.CENTER);
    }
}
