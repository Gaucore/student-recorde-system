package ui;

import java.awt.*;
import javax.swing.*;

import config.AppConfig;

public class DashboardFrame extends BaseFrame {
    public DashboardFrame() {
        super(AppConfig.APP_NAME);
        initialize();
    }

    private void initialize() {
        setLayout(new BorderLayout());
        JLabel title = new JLabel("Dashboard", SwingConstants.CENTER);

        title.setFont(new Font("Segoe UI", Font.BOLD, 30));
        add(title, BorderLayout.CENTER);
        setVisible(true);
    }
}
