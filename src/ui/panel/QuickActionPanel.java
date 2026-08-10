package ui.panel;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import ui.component.CardPanel;
import ui.component.PrimaryButton;

public class QuickActionPanel extends CardPanel {

    private PrimaryButton btnStudent;
    private PrimaryButton btnCourse;
    private PrimaryButton btnFaculty;
    private PrimaryButton btnFees;

    public QuickActionPanel() {

        initialize();

    }

    private void initialize() {

        setLayout(new BorderLayout(15, 15));

        JLabel title = new JLabel("Quick Actions");
        title.setFont(new Font("Segoe UI", Font.BOLD, 20));

        add(title, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 10));
        buttonPanel.setOpaque(false);

        btnStudent = new PrimaryButton("Add Student");

        btnCourse = new PrimaryButton("Add Course");

        btnFaculty = new PrimaryButton("Add Faculty");

        btnFees = new PrimaryButton("Collect Fees");

        buttonPanel.add(btnStudent);
        buttonPanel.add(btnCourse);
        buttonPanel.add(btnFaculty);
        buttonPanel.add(btnFees);

        add(buttonPanel, BorderLayout.CENTER);

    }

    public PrimaryButton getStudentButton() {
        return btnStudent;
    }

    public PrimaryButton getCourseButton() {
        return btnCourse;
    }

    public PrimaryButton getFacultyButton() {
        return btnFaculty;
    }

    public PrimaryButton getFeesButton() {
        return btnFees;
    }

}