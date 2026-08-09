package ui.panel;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import ui.component.MenuButton;

public class SidebarPanel extends JPanel {

    public MenuButton btnDashboard;
    public MenuButton btnStudents;

    public SidebarPanel() {
        initialize();
    }

    private void initialize() {

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(220, 0));

        btnDashboard = new MenuButton("Dashboard");
        btnStudents = new MenuButton("Students");

        add(Box.createVerticalStrut(30));

        add(btnDashboard);
        add(Box.createVerticalStrut(10));

        add(btnStudents);
    }
}