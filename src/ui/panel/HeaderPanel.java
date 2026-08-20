package ui.panel;

import config.Theme;
import ui.LoginFrame;
import ui.component.PrimaryButton;
import ui.component.TitleLabel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HeaderPanel extends JPanel {

    private JLabel lblLogo;

    private TitleLabel lblTitle;
    private JLabel lblSubtitle;

    private JLabel lblWelcome;
    private JLabel lblDate;
    private JLabel lblTime;

    private PrimaryButton btnLogout;

    private JPanel leftPanel;
    private JPanel rightPanel;
    private JPanel titlePanel;

    public HeaderPanel() {

        initialize();

    }

    private void initialize() {

        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(0, 90));
        setBackground(Theme.PRIMARY);
        setBorder(new EmptyBorder(10, 20, 10, 20));

        buildLeft();

        buildRight();

        add(leftPanel, BorderLayout.WEST);
        add(rightPanel, BorderLayout.EAST);

        // startClock();

    }

    private void buildLeft() {

        leftPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 5));
        leftPanel.setOpaque(false);

        lblLogo = new JLabel();

        ImageIcon icon = new ImageIcon(getClass().getResource("/icons/logo.png"));

        Image img = icon.getImage().getScaledInstance(55, 55, Image.SCALE_SMOOTH);

        lblLogo.setIcon(new ImageIcon(img));

        titlePanel = new JPanel();
        titlePanel.setOpaque(false);
        titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.Y_AXIS));

        lblTitle = new TitleLabel("Student Record Management System");
        lblTitle.setForeground(Color.WHITE);
        lblTitle.setHorizontalAlignment(SwingConstants.LEFT);

        lblSubtitle = new JLabel("Enterprise Desktop ERP");
        lblSubtitle.setForeground(new Color(230, 230, 230));
        lblSubtitle.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        titlePanel.add(lblTitle);
        titlePanel.add(lblSubtitle);

        leftPanel.add(lblLogo);
        leftPanel.add(titlePanel);

    }

    private void buildRight() {

        rightPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 10));
        rightPanel.setOpaque(false);

        lblWelcome = new JLabel("Welcome, Gautam");
        lblWelcome.setForeground(Color.WHITE);
        lblWelcome.setFont(new Font("Segoe UI", Font.BOLD, 15));

        btnLogout = new PrimaryButton("Logout");
        // btnLogout.addActionListener(e ->{

        // });
        btnLogout.setBackground(Theme.DANGER);
        btnLogout.setForeground(Color.WHITE);
        btnLogout.setFocusPainted(false);
        btnLogout.setBorderPainted(false);
        btnLogout.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Small button size
        btnLogout.setPreferredSize(new Dimension(90, 32));

        rightPanel.add(lblWelcome);
        rightPanel.add(btnLogout);
    }

    // private void startClock() {

    // Timer timer = new Timer(1000, e -> {
    // Date date = new Date();
    // lblDate.setText(new SimpleDateFormat("dd MMM yyyy").format(date));
    // lblTime.setText(new SimpleDateFormat("hh:mm:ss a").format(date));
    // });

    // timer.setInitialDelay(0);

    // timer.start();

    // }

}