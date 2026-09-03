package ui.panel.student;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ui.component.SearchField;

public class StudentHeaderPanel extends JPanel {

    private JLabel lblTitle;
    private JLabel lblSubtitle;

    private SearchField txtSearch;

    public StudentHeaderPanel() {
        initialize();
        setPreferredSize(new Dimension(0, 85));
    }

    private void initialize() {

        setOpaque(false);

        setLayout(new BorderLayout(15, 0));
        setBorder(BorderFactory.createEmptyBorder(0, 5, 18, 5));
        JPanel leftPanel = new JPanel();
        leftPanel.setOpaque(false);
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        lblTitle = new JLabel("Student Management");
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 30));
        lblSubtitle = new JLabel("Manage student records and admissions");
        lblSubtitle.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        lblSubtitle.setForeground(Color.GRAY);
        leftPanel.add(lblTitle);
        leftPanel.add(Box.createVerticalStrut(5));
        leftPanel.add(lblSubtitle);
        JPanel searchPanel = new JPanel();
        searchPanel.setOpaque(false);
        searchPanel.setLayout(new BoxLayout(searchPanel, BoxLayout.Y_AXIS));
        JLabel lblSearch = new JLabel("Search");
        lblSearch.setFont(new Font("Segoe UI", Font.BOLD, 13));
        lblSearch.setAlignmentX(LEFT_ALIGNMENT);

        txtSearch = new SearchField(14);
        txtSearch.setMaximumSize(txtSearch.getPreferredSize());
        txtSearch.setAlignmentX(LEFT_ALIGNMENT);

        searchPanel.add(Box.createVerticalStrut(2)); // move slightly down
        searchPanel.add(lblSearch);
        searchPanel.add(Box.createVerticalStrut(5));
        searchPanel.add(txtSearch);

        add(leftPanel, BorderLayout.WEST);
        add(searchPanel, BorderLayout.EAST);

    }

    public SearchField getSearchField() {

        return txtSearch;

    }

}