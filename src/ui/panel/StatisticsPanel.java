package ui.panel;

import ui.component.DashboardCard;

import javax.swing.*;
import java.awt.*;

public class StatisticsPanel extends JPanel {

    public StatisticsPanel() {

        initialize();

    }

    private void initialize() {

        setOpaque(false);

        setLayout(new GridLayout(1, 4, 15, 15));

        add(new DashboardCard("Students", "152"));

        add(new DashboardCard("Courses", "12"));

        add(new DashboardCard("Faculty", "18"));

        add(new DashboardCard("Pending Fees", "24"));

    }

}