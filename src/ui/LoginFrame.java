package ui;

import java.awt.*;
import javax.swing.*;

import ui.component.CardPanel;
import ui.component.FormTextField;
import ui.component.PasswordField;
import ui.component.PrimaryButton;
import ui.component.SecondaryButton;
import ui.component.TitleLabel;

public class LoginFrame extends JFrame {
    private JPanel headerPanel;
    private JPanel loginPanel;
    private JPanel footerPanel;

    // private JLabel lblTitle;
    // private JLabel lblSubtitle;
    // private JLabel lblUsername;
    // private JLabel lblPassword;
    // private JLabel lblVersion;

    // private JTextField txtUsername;
    // private JPasswordField txtPassword;

    // private JButton btnLogin;
    // private JButton btnClear;

    private TitleLabel lblTitle;

    private JLabel lblSubtitle;
    private JLabel lblUsername;
    private JLabel lblPassword;
    private JLabel lblVersion;

    private FormTextField txtUsername;
    private PasswordField txtPassword;

    private PrimaryButton btnLogin;
    private SecondaryButton btnClear;

    public LoginFrame() {
        initializeFrame();
        initializeComponents();
        addComponents();
        registerEvents();
    }

    private void initializeFrame() {
        setTitle("Student Record Storage System");
        setSize(900, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new BorderLayout());
    }

    // private void initializeComponents() {

    // // Panel varaible
    // headerPanel = new JPanel();
    // loginPanel = new JPanel(new GridBagLayout());
    // footerPanel = new JPanel();

    // lblTitle = new JLabel("🎓 STUDENT RECORD SYSTEM");
    // lblSubtitle = new JLabel("Student Management ERP Desktop Software");
    // lblUsername = new JLabel("Username");
    // lblPassword = new JLabel("Password");
    // lblVersion = new JLabel("Version 1.0");

    // txtUsername = new JTextField(20);
    // txtPassword = new JPasswordField(20);

    // btnLogin = new JButton("Login");
    // btnClear = new JButton("Clear");

    // lblTitle.setFont(new Font("SansSerif", Font.PLAIN, 28));
    // lblSubtitle.setFont(new Font("SansSerif", Font.PLAIN, 15));
    // lblUsername.setFont(new Font("SansSerif", Font.PLAIN, 16));
    // lblPassword.setFont(new Font("SansSerif", Font.PLAIN, 16));
    // btnLogin.setFont(new Font("SansSerif", Font.PLAIN, 15));
    // btnClear.setFont(new Font("SansSerif", Font.PLAIN, 15));

    // lblTitle.setForeground(new Color(25, 118, 210));
    // lblSubtitle.setForeground(Color.DARK_GRAY);
    // // headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.Y_AXIS));
    // // lblTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
    // // lblSubtitle.setAlignmentX(Component.CENTER_ALIGNMENT);
    // // headerPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

    // }

    private void initializeComponents() {

        // ---------------- PANELS ---------------- //
        headerPanel = new JPanel();

        loginPanel = new CardPanel();
        loginPanel.setLayout(new GridBagLayout());

        footerPanel = new JPanel();

        // ---------------- LABELS ---------------- //
        lblTitle = new TitleLabel("🎓 STUDENT RECORD SYSTEM");

        lblSubtitle = new JLabel("Student Management ERP Desktop Software");
        lblUsername = new JLabel("Username");
        lblPassword = new JLabel("Password");
        lblVersion = new JLabel("Version 1.0");

        // ---------------- TEXT FIELDS ---------------- //
        txtUsername = new FormTextField(20);
        txtPassword = new PasswordField(20);

        // ---------------- BUTTONS ---------------- //
        btnLogin = new PrimaryButton("Login");
        btnClear = new SecondaryButton("Clear");

        // ---------------- REMAINING STYLING ---------------- //
        lblSubtitle.setFont(new Font("SansSerif", Font.PLAIN, 15));
        lblSubtitle.setForeground(Color.DARK_GRAY);

        lblUsername.setFont(new Font("SansSerif", Font.PLAIN, 16));
        lblPassword.setFont(new Font("SansSerif", Font.PLAIN, 16));
    }

    private void addComponents() {

        headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.Y_AXIS));
        lblTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblSubtitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        headerPanel.add(Box.createHorizontalStrut(20));

        headerPanel.add(lblTitle);
        headerPanel.add(Box.createVerticalStrut(10));
        headerPanel.add(lblSubtitle);
        headerPanel.add(Box.createVerticalStrut(10));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridx = 0;
        gbc.gridy = 0;
        loginPanel.add(lblUsername, gbc);

        gbc.gridx = 1;
        loginPanel.add(txtUsername, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        loginPanel.add(lblPassword, gbc);

        gbc.gridx = 1;
        loginPanel.add(txtPassword, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;

        loginPanel.add(btnLogin, gbc);

        gbc.gridx = 1;

        loginPanel.add(btnClear, gbc);

        // ---------------- FOOTER ----------------//

        footerPanel.add(lblVersion);

        // ---------------- FRAME ----------------//

        add(headerPanel, BorderLayout.NORTH);

        add(loginPanel, BorderLayout.CENTER);

        add(footerPanel, BorderLayout.SOUTH);

    }

    private void registerEvents() {
        btnLogin.addActionListener(e -> login());
        btnClear.addActionListener(e -> clearForm());
    }

    private void login() {
        String username = txtUsername.getText().trim();
        String password = String.valueOf(txtPassword.getPassword());
        if (username.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter username.");
            txtUsername.requestFocus();
            return;
        }
        if (password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter password.");
            txtPassword.requestFocus();
            return;
        }

        if (username.equals("admin") && password.equals("admin123")) {
            JOptionPane.showMessageDialog(this, "Login Successfully.");
            DashboardFrame dashboardFrame = new DashboardFrame();
            dashboardFrame.setVisible(true);

            // Close Login Window
            dispose();

        } else {
            JOptionPane.showMessageDialog(this, "Invalid username and password");
        }

    }

    private void clearForm() {
        txtUsername.setText("");
        txtPassword.setText("");
        txtUsername.requestFocus();
    }
}