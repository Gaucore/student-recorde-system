package ui;

import java.awt.*;
import javax.swing.*;

import config.AppConfig;
import ui.component.CardPanel;
import ui.component.FormTextField;
import ui.component.PasswordField;
import ui.component.PrimaryButton;
import ui.component.SecondaryButton;
import ui.component.TitleLabel;

public class LoginFrame extends BaseFrame {

    private FormTextField txtUsername;
    private PasswordField txtPassword;

    private PrimaryButton btnLogin;
    private SecondaryButton btnClear;

    public LoginFrame() {

        super(AppConfig.APP_NAME);
        initialize();
    }

    private void initialize() {

        setLayout(new BorderLayout());

        CardPanel card = new CardPanel();

        card.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(10, 10, 10, 10);

        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;

        card.add(new TitleLabel(" STUDENT RECORD STORAGE SYSTEM"), gbc);

        gbc.gridy++;

        JLabel subTitle = new JLabel("Enterprise Desktop ERP Software",
                SwingConstants.CENTER);

        card.add(subTitle, gbc);

        gbc.gridwidth = 1;

        gbc.gridy++;

        card.add(new JLabel("Username"), gbc);

        gbc.gridx = 1;

        txtUsername = new FormTextField(20);

        card.add(txtUsername, gbc);

        gbc.gridx = 0;
        gbc.gridy++;

        card.add(new JLabel("Password"), gbc);

        gbc.gridx = 1;

        txtPassword = new PasswordField(20);

        card.add(txtPassword, gbc);

        gbc.gridx = 0;
        gbc.gridy++;

        btnLogin = new PrimaryButton("Login");

        card.add(btnLogin, gbc);

        gbc.gridx = 1;

        btnClear = new SecondaryButton("Clear");

        card.add(btnClear, gbc);

        JPanel centerPanel = new JPanel(new GridBagLayout());

        centerPanel.add(card);

        add(centerPanel, BorderLayout.CENTER);

        JLabel version = new JLabel("Version " + AppConfig.VERSION,
                SwingConstants.CENTER);

        add(version, BorderLayout.SOUTH);

        registerEvents();

        setVisible(true);

    }

    private void registerEvents() {

        btnClear.addActionListener(e -> {

            txtUsername.setText("");

            txtPassword.setText("");

            txtUsername.requestFocus();

        });

    }
}