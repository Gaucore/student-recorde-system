package controller;

import java.awt.CardLayout;

import javax.swing.JPanel;

public class NavigationController {

    private final CardLayout cardLayout;
    private final JPanel contentPanel;

    public NavigationController(CardLayout cardLayout, JPanel contentPanel) {
        this.cardLayout = cardLayout;
        this.contentPanel = contentPanel;
    }

    public void showDashboard() {
        cardLayout.show(contentPanel, "DASHBOARD");
    }

    public void showStudent() {
        cardLayout.show(contentPanel, "STUDENT");
    }

    public void showCourse() {
        cardLayout.show(contentPanel, "COURSE");
    }

    public void showFacuilty() {
        cardLayout.show(contentPanel, "FACUILTY");
    }

    public void showReport() {
        cardLayout.show(contentPanel, "REPORT");
    }

    public void showSettings() {
        cardLayout.show(contentPanel, "SETTINGS");
    }
}
