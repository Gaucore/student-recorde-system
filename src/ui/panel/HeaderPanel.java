package ui.panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.Timer;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ui.component.PrimaryButton;
import ui.component.TitleLabel;

public class HeaderPanel extends JPanel {

    private JLabel lblLogo;
    private TitleLabel lblTitle;
    private JLabel lblSubtitle;

    // Right side

    private JLabel lblWelcome, lblDate, lblTime;

    // Button
    private PrimaryButton btnLogout;

    private JPanel leftPanel;
    private JPanel rightPanel;

    public HeaderPanel() {
        initializeComponents();
        buildLayout();
        startClock();
    }

    private void initializeComponents() {
        setLayout(new BorderLayout());
        setBackground(new Color(25, 118, 210));
        setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));
        leftPanel = new JPanel();
        rightPanel = new JPanel();
        leftPanel.setOpaque(false);
        rightPanel.setOpaque(false);
        lblLogo = new JLabel("🎓");
        lblLogo.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 36));
        lblTitle = new TitleLabel("Student Record Storage System");
        lblTitle.setForeground(Color.WHITE);
        lblSubtitle = new JLabel("Enterprise Desktop ERP Software");
        lblSubtitle.setForeground(Color.WHITE);
        lblWelcome = new JLabel("Welcome, Admin");
        lblWelcome.setForeground(Color.WHITE);
        lblDate = new JLabel();
        lblDate.setForeground(Color.WHITE);
        lblTime = new JLabel();
        lblTime.setForeground(Color.WHITE);
        btnLogout = new PrimaryButton("Logout");

    }

    private void buildLeftPanel() {
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        leftPanel.add(lblLogo);
        leftPanel.add(lblTitle);
        leftPanel.add(lblSubtitle);
    }

    private void buildLayout() {
        buildLeftPanel();
        buildRightPanel();

        add(leftPanel, BorderLayout.WEST);
        add(rightPanel, BorderLayout.EAST);
    }

    private void startClock() {

        Timer timer = new Timer(1000, e -> {
            Date date = new Date();
            lblTime.setText(new SimpleDateFormat("hh:mm:ss a").format(date));
            lblDate.setText(new SimpleDateFormat("dd MMM yyyy").format(date));
        });
        timer.start();
    }

    private void buildRightPanel() {
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        lblWelcome.setAlignmentX(Component.RIGHT_ALIGNMENT);
        lblTime.setAlignmentX(Component.RIGHT_ALIGNMENT);
        lblDate.setAlignmentX(Component.RIGHT_ALIGNMENT);
        btnLogout.setAlignmentX(Component.RIGHT_ALIGNMENT);
        rightPanel.add(lblWelcome);
        rightPanel.add(Box.createVerticalStrut(5));
        rightPanel.add(lblTime);
        rightPanel.add(lblDate);
        rightPanel.add(Box.createVerticalStrut(10));
        rightPanel.add(btnLogout);

    }

}
