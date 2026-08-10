package ui.component;

import config.Theme;

import javax.swing.*;
import java.awt.*;

public class DashboardCard extends CardPanel {

    private JLabel lblTitle;
    private JLabel lblValue;

    public DashboardCard(String title, String value) {

        initialize(title, value);

    }

    private void initialize(String title, String value) {

        setLayout(new BorderLayout());

        setPreferredSize(new Dimension(180, 110));

        lblTitle = new JLabel(title);
        lblTitle.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        lblTitle.setForeground(Color.GRAY);

        lblValue = new JLabel(value);
        lblValue.setFont(new Font("Segoe UI", Font.BOLD, 32));
        lblValue.setForeground(Theme.PRIMARY);

        add(lblTitle, BorderLayout.NORTH);
        add(lblValue, BorderLayout.CENTER);

    }

    public void setValue(String value) {
        lblValue.setText(value);
    }

}