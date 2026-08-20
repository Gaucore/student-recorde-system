package ui.panel.student;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import table.StudentTableModel;
import ui.component.SearchField;

public class StudentTablePanel extends JPanel {

    private JLabel lblTitle;
    // private SearchField txtSearch;
    private JTable studentTable;
    private StudentTableModel studentTableModel;
    private JScrollPane scrollPane;

    public StudentTablePanel() {
        initialize();
    }

    private void initialize() {
        setLayout(new BorderLayout(10, 10));
        add(createHeader(), BorderLayout.NORTH);
        add(createTable(), BorderLayout.CENTER);

    }

    private JScrollPane createTable() {
        studentTableModel = new StudentTableModel();
        studentTable = new JTable(studentTableModel);
        // studentTable.setRowHeight(40);
        studentTable.getTableHeader()
                .setPreferredSize(
                        new Dimension(0, 42));
        studentTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        studentTable.setShowGrid(false);
        studentTable.setIntercellSpacing(new Dimension(0, 0));
        scrollPane = new JScrollPane(studentTable);
        studentTable.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        scrollPane.setBorder(BorderFactory.createLineBorder(
                new Color(220, 220, 220)));

        studentTable.getTableHeader().setFont(
                new Font("Segoe UI", Font.BOLD, 14));
        studentTable.getTableHeader().setBackground(new Color(33, 150, 243));
        studentTable.getTableHeader().setForeground(Color.WHITE);
        studentTable.getTableHeader().setReorderingAllowed(false);
        studentTable.setRowHeight(34);
        studentTable.setGridColor(new Color(235, 235, 235));
        studentTable.setSelectionBackground(new Color(220, 235, 252));
        studentTable.setSelectionForeground(Color.BLACK);
        studentTable.setShowVerticalLines(false);

        return scrollPane;

    }

    private JPanel createHeader() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setOpaque(false);
        JLabel lbl = new JLabel("Student Records");
        lbl.setFont(new Font("Segoe UI", Font.BOLD, 28));
        panel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        panel.add(lbl, BorderLayout.WEST);
        return panel;
    }
}
