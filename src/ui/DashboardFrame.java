package ui;

import java.awt.*;
import javax.swing.*;

import config.AppConfig;
import ui.panel.DashboardPanel;
import ui.panel.SidebarPanel;
import ui.panel.StudentPanel;

public class DashboardFrame extends BaseFrame {
    private SidebarPanel sidebar;
    private JPanel contentPanel;
    private CardLayout cardLayout;

    public DashboardFrame() {
        super(AppConfig.APP_NAME);
        initialize();
    }

    private void initialize() {
        // setLayout(new BorderLayout());
        // JLabel title = new JLabel("Dashboard", SwingConstants.CENTER);

        // title.setFont(new Font("Segoe UI", Font.BOLD, 30));
        // add(title, BorderLayout.CENTER);
        cardLayout = new CardLayout();
        contentPanel = new JPanel(cardLayout);
        sidebar = new SidebarPanel();

        contentPanel.add(new DashboardPanel(), "dashboard");
        contentPanel.add(new StudentPanel(), "students");

        setLayout(new BorderLayout());
        add(sidebar, BorderLayout.WEST);
        add(contentPanel, BorderLayout.CENTER);

        sidebar.btnDashboard.addActionListener(e -> {
            cardLayout.show(contentPanel, "dashboard");
        });

        sidebar.btnStudents.addActionListener(e -> {
            cardLayout.show(contentPanel, "students");
        });

        setVisible(true);
    }
}
