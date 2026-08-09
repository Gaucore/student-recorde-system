package ui.panel;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class DashboardPanel extends JPanel {

    public DashboardPanel() {
        initialize();
    }

    private void initialize() {

        setLayout(new BorderLayout());
        JLabel lb1 = new JLabel("Dashboard", SwingConstants.CENTER);
        lb1.setFont(new Font("Segoe UI", Font.BOLD, 30));
        add(lb1, BorderLayout.CENTER);

    }
}
