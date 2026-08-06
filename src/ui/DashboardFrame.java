package ui;

import java.awt.*;
import javax.swing.*;

import controller.NavigationController;
import ui.panel.HeaderPanel;

public class DashboardFrame extends JFrame {
    public DashboardFrame() {

        setTitle("Dashboard");
        setSize(1000, 650);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // JLabel lblTitle = new JLabel("Welcome to Dashboard");
        // lblTitle.setFont(new Font("SansSerif", Font.BOLD, 30));
        // lblTitle.setHorizontalAlignment(SwingConstants.CENTER);

        HeaderPanel headerPanel = new HeaderPanel();

        // CardLayout cardLayout = new CardLayout();
        // JPanel contentPanel =new JPanel(cardLayout);

        // NavigationController navigationController new
        // NavigationController(cardLayout, contentPanel);

        add(headerPanel);

        setVisible(true);
    }
}
