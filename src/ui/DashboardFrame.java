package ui;

import java.awt.*;
import javax.swing.*;

import config.AppConfig;
import ui.panel.CoursePanel;
import ui.panel.DashboardPanel;
import ui.panel.HeaderPanel;
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

        cardLayout = new CardLayout();
        contentPanel = new JPanel(cardLayout);
        sidebar = new SidebarPanel();

        contentPanel.add(new DashboardPanel(), "dashboard");
        contentPanel.add(new StudentPanel(), "students");
        contentPanel.add(new CoursePanel(), "Course");

        HeaderPanel header = new HeaderPanel();
        setLayout(new BorderLayout());

        add(header, BorderLayout.NORTH);

        add(sidebar, BorderLayout.WEST);

        add(contentPanel, BorderLayout.CENTER);

        sidebar.btnDashboard.addActionListener(e -> {
            cardLayout.show(contentPanel, "dashboard");
        });

        sidebar.btnStudents.addActionListener(e -> {
            cardLayout.show(contentPanel, "students");
        });

        sidebar.btnCourses.addActionListener(e -> {
            cardLayout.show(contentPanel, "Course");
        });

        setVisible(true);
    }

}
