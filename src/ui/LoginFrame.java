package ui;

import java.awt.*;
import javax.swing.*;

import config.AppConfig;
import controller.LoginController;
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

    private LoginController controller;

    public LoginFrame() {

        super(AppConfig.APP_NAME);
        initialize();
    }

    private void initialize() {

        controller = new LoginController();

        setLayout(new BorderLayout());

        CardPanel card = new CardPanel();

        card.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(10, 10, 10, 10);

        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;

        ImageIcon icon = new ImageIcon(getClass().getResource("/icons/logo.png"));

        System.out.println(icon);

        Image image = icon.getImage()
                .getScaledInstance(
                        80,
                        80,
                        Image.SCALE_SMOOTH);

        JLabel logoLabel = new JLabel(
                new ImageIcon(image));

        card.add(logoLabel, gbc);

        gbc.gridy++;

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

        JLabel version = new JLabel("Version " + AppConfig.VERSION, SwingConstants.CENTER);

        add(version, BorderLayout.SOUTH);

        registerEvents();

        setVisible(true);

    }

    private void registerEvents() {

        btnLogin.addActionListener(e -> login());

        btnClear.addActionListener(e -> {
            txtUsername.setText("");
            txtPassword.setText("");
            txtUsername.requestFocus();
        });
    }

    private void login() {
        String username = txtUsername.getText().trim();
        String password = new String(txtPassword.getPassword());

        if (username.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Username is required.");
            txtUsername.requestFocus();
            return;
        }

        if (password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Password is required.");
            txtPassword.requestFocus();
            return;
        }

        boolean success = controller.login(username, password);
        if (success) {
            JOptionPane.showMessageDialog(this, "Login successfully.");
            dispose();
            new DashboardFrame();
        } else {
            JOptionPane.showMessageDialog(this, "Invalid Username or Password.");
        }

    }
}