package ui.panel;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import config.Theme;
import ui.component.MenuButton;

public class SidebarPanel extends JPanel {

    public MenuButton btnDashboard;
    public MenuButton btnStudents;
    public MenuButton btnCourses;
    public MenuButton btnFaculty;
    public MenuButton btnFees;
    public MenuButton btnLibrary;
    public MenuButton btnReports;
    public MenuButton btnSettings;
    public MenuButton btnLogout;

    public SidebarPanel() {
        initialize();
    }

    private void initialize() {

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        setPreferredSize(new Dimension(230, 0));

        setBackground(Theme.SIDEBAR);

        setBorder(BorderFactory.createEmptyBorder(20, 15, 20, 15));

        JLabel lblMenu = new JLabel("MAIN MENU");
        lblMenu.setForeground(Color.WHITE);
        lblMenu.setFont(new Font("Segoe UI", Font.BOLD, 13));
        lblMenu.setAlignmentX(Component.LEFT_ALIGNMENT);

        btnDashboard = new MenuButton("Dashboard");
        btnStudents = new MenuButton("Students");
        btnCourses = new MenuButton("Courses");
        btnFaculty = new MenuButton("Faculty");
        btnFees = new MenuButton("Fees");
        btnLibrary = new MenuButton("Library");
        btnReports = new MenuButton("Reports");
        btnSettings = new MenuButton("Settings");
        btnLogout = new MenuButton("Logout");
        add(lblMenu);
        add(Box.createVerticalStrut(20));
        add(btnDashboard);
        add(Box.createVerticalStrut(8));
        add(btnStudents);
        add(Box.createVerticalStrut(8));
        add(btnCourses);
        add(Box.createVerticalStrut(8));
        add(btnFaculty);
        add(Box.createVerticalStrut(8));
        add(btnFees);
        add(Box.createVerticalStrut(8));
        add(btnLibrary);
        add(Box.createVerticalStrut(8));
        add(btnReports);
        add(Box.createVerticalStrut(8));
        add(btnSettings);
        add(Box.createVerticalGlue());
        add(btnLogout);
    }
}