package ui.panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.File;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableRowSorter;

import constant.AppConstants;
import controller.CourseController;
import exception.ValidationException;
import model.Course;
import model.Student;
import table.CourseTableModel;
import table.StudentTableModel;

public class CoursePanel extends JPanel {

        private JTextField txtCourseCode, txtCourseName, txtDuration, txtFees;
        private JButton btnSave, btnUpdate, btnClear, btnDelete;
        private JTextField txtSearch;
        private JTable courseTable;
        private CourseTableModel courseTableModel;
        private TableRowSorter<CourseTableModel> sorter;

        private static final Color PRIMARY_COLOR = new Color(25, 118, 210);
        private static final Color PRIMARY_DARK = new Color(21, 101, 192);

        private static final Color BACKGROUND_COLOR = new Color(245, 247, 250);
        private static final Color PANEL_COLOR = Color.WHITE;

        private static final Color BORDER_COLOR = new Color(210, 215, 222);

        private static final Color TEXT_COLOR = new Color(35, 42, 50);
        private static final Color SECONDARY_TEXT = new Color(100, 110, 120);

        private static final Color TABLE_HEADER_COLOR = new Color(30, 136, 229);
        private static final Color TABLE_HEADER_TEXT = Color.WHITE;

        private JButton btnImport;
        private JButton btnExport;

        private CourseController courseController;

        public CoursePanel() {
                courseController = new CourseController();
                initializeUI();
                loadCourses();
        }

        private void initializeUI() {

                setLayout(new BorderLayout());

                setBackground(BACKGROUND_COLOR);
                // JPanel headerPanel = createHeaderPanel();

                // add(headerPanel, BorderLayout.NORTH);
                JPanel centerPanel = createCenterPanel();
                JScrollPane mainScrollPane = new JScrollPane(centerPanel);
                mainScrollPane.setBorder(null);
                mainScrollPane.setVerticalScrollBarPolicy(
                                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

                mainScrollPane.setHorizontalScrollBarPolicy(
                                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

                mainScrollPane.getVerticalScrollBar().setUnitIncrement(16);

                mainScrollPane.getViewport().setBackground(
                                BACKGROUND_COLOR);

                add(mainScrollPane, BorderLayout.CENTER);
        }

        // private JPanel createHeaderPanel() {
        // JPanel panel = new JPanel(new BorderLayout());
        // JLabel lblTitle = new JLabel("Course Managemet");
        // lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 28));
        // panel.add(lblTitle, BorderLayout.WEST);
        // return panel;
        // }

        private JPanel createCenterPanel() {

                JPanel panel = new JPanel(new BorderLayout(15, 15));
                panel.setOpaque(false);

                panel.setBorder(
                                BorderFactory.createEmptyBorder(
                                                0,
                                                5,
                                                20,
                                                5));

                JPanel formPanel = createFormPanel();
                JPanel tablePanel = createTablePanel();

                panel.add(formPanel, BorderLayout.NORTH);
                panel.add(tablePanel, BorderLayout.CENTER);

                return panel;
        }

        private JPanel createFormPanel() {

                JPanel panel = new JPanel(new GridBagLayout());
                // panel.setPreferredSize(new Dimension(0, 440));
                // panel.setMinimumSize(new Dimension(0, 330));
                panel.setBackground(PANEL_COLOR);
                panel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder(
                                BorderFactory.createLineBorder(
                                                BORDER_COLOR),
                                "Course Information"),
                                BorderFactory.createEmptyBorder(
                                                8,
                                                15,
                                                8,
                                                15)));

                GridBagConstraints gbc = new GridBagConstraints();
                gbc.insets = new Insets(
                                4,
                                6,
                                4,
                                6);
                gbc.fill = GridBagConstraints.HORIZONTAL;
                gbc.weightx = 1;
                // -----------------------------------------------------
                // TEXT FIELDS
                // -----------------------------------------------------
                txtCourseCode = new JTextField();
                txtCourseName = new JTextField();
                txtDuration = new JTextField();
                txtFees = new JTextField();

                styleTextField(txtCourseCode);
                styleTextField(txtCourseName);
                styleTextField(txtDuration);
                styleTextField(txtFees);

                int row = 0;

                addField(
                                panel,
                                gbc,
                                "Course Code",
                                txtCourseCode,
                                row++);

                addField(
                                panel,
                                gbc,
                                "Course Name",
                                txtCourseName,
                                row++);

                addField(
                                panel,
                                gbc,
                                "Duration",
                                txtDuration,
                                row++);

                addField(
                                panel,
                                gbc,
                                "Fees",
                                txtFees,
                                row++);

                JPanel buttonPanel = new JPanel(
                                new FlowLayout(
                                                FlowLayout.LEFT,
                                                8,
                                                3));

                buttonPanel.setOpaque(false);

                btnSave = new JButton("Save");
                btnUpdate = new JButton("Update");
                btnDelete = new JButton("Delete");
                btnClear = new JButton("Clear");

                btnImport = new JButton("Import CSV");
                btnExport = new JButton("Export CSV");

                stylePrimaryButton(btnSave);
                styleSecondaryButton(btnUpdate);
                styleDangerButton(btnDelete);
                styleSecondaryButton(btnClear);
                styleSuccessButton(btnImport);
                styleExportButton(btnExport);

                buttonPanel.add(btnSave);
                buttonPanel.add(btnUpdate);
                buttonPanel.add(btnDelete);
                buttonPanel.add(btnClear);
                buttonPanel.add(btnImport);
                buttonPanel.add(btnExport);

                gbc.gridx = 0;
                gbc.gridy = row;

                gbc.gridwidth = 2;

                gbc.weightx = 1;

                gbc.fill = GridBagConstraints.NONE;

                gbc.anchor = GridBagConstraints.WEST;

                panel.add(
                                buttonPanel,
                                gbc);

                btnSave.addActionListener(
                                e -> saveCourse());

                btnUpdate.addActionListener(
                                e -> updateCourse());

                btnDelete.addActionListener(
                                e -> deleteCourse());

                btnClear.addActionListener(
                                e -> clearForm());

                btnImport.addActionListener(e -> importData());

                btnExport.addActionListener(e -> exportData());

                return panel;
        }

        private void styleTextField(
                        JTextField field) {
                field.setFont(
                                new Font(
                                                "Segoe UI",
                                                Font.PLAIN,
                                                14));
                field.setPreferredSize(
                                new Dimension(
                                                250,
                                                34));
                field.setBackground(
                                Color.WHITE);
                field.setForeground(
                                TEXT_COLOR);
                field.setCaretColor(
                                PRIMARY_COLOR);
                field.setBorder(
                                BorderFactory.createCompoundBorder(
                                                BorderFactory.createLineBorder(
                                                                BORDER_COLOR),
                                                BorderFactory.createEmptyBorder(
                                                                5,
                                                                9,
                                                                5,
                                                                9)));
        }

        private void stylePrimaryButton(
                        JButton button) {

                button.setFont(
                                new Font(
                                                "Segoe UI",
                                                Font.BOLD,
                                                13));

                button.setForeground(
                                Color.WHITE);

                button.setBackground(
                                PRIMARY_COLOR);

                button.setPreferredSize(
                                new Dimension(
                                                80,
                                                34));

                button.setFocusPainted(
                                false);

                button.setBorder(
                                BorderFactory.createEmptyBorder(
                                                5,
                                                15,
                                                5,
                                                15));
        }

        private void styleSecondaryButton(
                        JButton button) {

                button.setFont(
                                new Font(
                                                "Segoe UI",
                                                Font.BOLD,
                                                13));

                button.setForeground(
                                TEXT_COLOR);

                button.setBackground(
                                new Color(
                                                235,
                                                238,
                                                242));

                button.setPreferredSize(
                                new Dimension(
                                                80,
                                                34));

                button.setFocusPainted(
                                false);

                button.setBorder(
                                BorderFactory.createLineBorder(
                                                new Color(
                                                                205,
                                                                210,
                                                                216)));
        }

        private void styleSuccessButton(JButton button) {
                button.setFont(new Font("Segoe UI", Font.BOLD, 13));
                button.setForeground(Color.WHITE);
                button.setBackground(new Color(40, 167, 69)); // green
                button.setPreferredSize(new Dimension(130, 34));
                button.setFocusPainted(false);
                button.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));
        }

        private void styleExportButton(JButton button) {
                button.setFont(new Font("Segoe UI", Font.BOLD, 13));
                button.setForeground(Color.WHITE);
                button.setBackground(new Color(255, 153, 0)); // orange
                button.setPreferredSize(new Dimension(130, 34));
                button.setFocusPainted(false);
                button.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));
        }

        private void styleDangerButton(
                        JButton button) {

                button.setFont(
                                new Font(
                                                "Segoe UI",
                                                Font.BOLD,
                                                13));

                button.setForeground(
                                Color.WHITE);

                button.setBackground(
                                new Color(
                                                220,
                                                53,
                                                69));

                button.setPreferredSize(
                                new Dimension(
                                                80,
                                                34));

                button.setFocusPainted(
                                false);

                button.setBorder(
                                BorderFactory.createEmptyBorder(
                                                5,
                                                15,
                                                5,
                                                15));
        }

        private void addField(
                        JPanel panel,
                        GridBagConstraints gbc,
                        String label,
                        JComponent component,
                        int row) {

                gbc.gridx = 0;
                gbc.gridy = row;

                gbc.gridwidth = 1;

                gbc.weightx = 0;

                gbc.fill = GridBagConstraints.NONE;

                JLabel lbl = new JLabel(label);

                lbl.setFont(
                                new Font(
                                                "Segoe UI",
                                                Font.PLAIN,
                                                14));

                lbl.setForeground(TEXT_COLOR);

                lbl.setPreferredSize(
                                new Dimension(
                                                110,
                                                35));

                panel.add(
                                lbl,
                                gbc);

                gbc.gridx = 1;

                gbc.gridy = row;

                gbc.weightx = 1;

                gbc.fill = GridBagConstraints.HORIZONTAL;

                panel.add(
                                component,
                                gbc);
        }

        private void styleSearchField(JTextField field) {

                field.setFont(new Font("Segoe UI", Font.PLAIN, 14));

                field.setPreferredSize(new Dimension(250, 34));

                field.setBackground(Color.WHITE);

                field.setForeground(TEXT_COLOR);

                field.setCaretColor(PRIMARY_COLOR);

                field.setBorder(BorderFactory.createCompoundBorder(
                                BorderFactory.createLineBorder(BORDER_COLOR),
                                BorderFactory.createEmptyBorder(5, 10, 5, 10)));
        }

        private JPanel createTablePanel() {

                JPanel panel = new JPanel(new BorderLayout(10, 10));
                panel.setOpaque(false);

                // =====================================================
                // SEARCH PANEL
                // =====================================================

                JPanel searchPanel = new JPanel(new BorderLayout(10, 0));
                searchPanel.setOpaque(false);

                JLabel searchLabel = new JLabel("Search");
                searchLabel.setFont(new Font("Segoe UI", Font.BOLD, 13));
                searchLabel.setForeground(TEXT_COLOR);

                searchPanel.add(searchLabel, BorderLayout.WEST);

                txtSearch = new JTextField();
                styleSearchField(txtSearch);

                txtSearch.getDocument().addDocumentListener(new DocumentListener() {

                        @Override
                        public void insertUpdate(javax.swing.event.DocumentEvent e) {
                                searchCourse();
                        }

                        @Override
                        public void removeUpdate(javax.swing.event.DocumentEvent e) {
                                searchCourse();
                        }

                        @Override
                        public void changedUpdate(javax.swing.event.DocumentEvent e) {
                                searchCourse();
                        }
                });

                searchPanel.add(txtSearch, BorderLayout.CENTER);

                panel.add(searchPanel, BorderLayout.NORTH);

                // =====================================================
                // TABLE
                // =====================================================

                courseTableModel = new CourseTableModel();

                courseTable = new JTable(courseTableModel);

                sorter = new TableRowSorter<>(courseTableModel);

                courseTable.setRowSorter(sorter);

                // =====================================================
                // TABLE STYLE
                // =====================================================

                courseTable.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                courseTable.setForeground(TEXT_COLOR);
                courseTable.setBackground(Color.WHITE);

                courseTable.setRowHeight(30);

                courseTable.setShowGrid(true);
                courseTable.setGridColor(new Color(225, 228, 232));

                courseTable.setSelectionBackground(new Color(225, 239, 255));
                courseTable.setSelectionForeground(TEXT_COLOR);

                courseTable.getTableHeader().setFont(
                                new Font("Segoe UI", Font.BOLD, 13));

                courseTable.getTableHeader().setForeground(TABLE_HEADER_TEXT);

                courseTable.getTableHeader().setBackground(TABLE_HEADER_COLOR);

                courseTable.getTableHeader().setPreferredSize(
                                new Dimension(0, 34));

                courseTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

                JScrollPane scrollPane = new JScrollPane(courseTable);

                scrollPane.setBorder(
                                BorderFactory.createLineBorder(BORDER_COLOR));

                panel.add(scrollPane, BorderLayout.CENTER);

                // =====================================================
                // ROW SELECTION
                // =====================================================

                courseTable.getSelectionModel().addListSelectionListener(
                                e -> loadSelectedCourse());

                return panel;
        }

        private void loadSelectedCourse() {

                int viewRow = courseTable.getSelectedRow();

                if (viewRow == -1) {
                        return;
                }

                int modelRow = courseTable.convertRowIndexToModel(viewRow);

                Course course = courseTableModel.getCourse(modelRow);

                txtCourseCode.setText(course.getCourseCode());
                txtCourseName.setText(course.getCourseName());
                txtDuration.setText(course.getDuration());
                txtFees.setText(String.valueOf(course.getFees()));
        }

        private void loadCourses() {
                List<Course> courses = courseController.getAllCourse();
                courseTableModel.setCourses(courses);
        }

        private void saveCourse() {
                Course course = createCourseFromForm();

                if (course == null) {
                        return;
                }

                try {
                        courseController.addCourse(course);
                        JOptionPane.showMessageDialog(this, "Course Added Successfully.");
                        loadCourses();
                        clearForm();
                } catch (ValidationException e) {
                        JOptionPane.showMessageDialog(this, e.getMessage(), "Validation Error",
                                        JOptionPane.ERROR_MESSAGE);
                }

        }

        private Course createCourseFromForm() {
                String code = txtCourseCode.getText().trim();
                String name = txtCourseName.getText().trim();
                String duration = txtDuration.getText().trim();
                String feesText = txtFees.getText().trim();
                if (code.isEmpty() || name.isEmpty() || duration.isEmpty() || feesText.isEmpty()) {
                        JOptionPane.showMessageDialog(this, "All Fields are required.");
                        return null;
                }

                double fees;
                try {
                        fees = Double.parseDouble(feesText);

                } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(this, e.getMessage(), "Validation Error",
                                        JOptionPane.ERROR_MESSAGE);
                        return null;
                }
                return new Course(code, name, duration, fees);
        }

        private void updateCourse() {

                Course course = createCourseFromForm();
                if (course == null) {
                        return;
                }

                try {
                        courseController.updateCourse(course);
                        JOptionPane.showMessageDialog(this, "Course Updated Successfully.");
                        loadCourses();
                        clearForm();
                } catch (ValidationException e) {
                        JOptionPane.showMessageDialog(this, e.getMessage(), "Validation Error",
                                        JOptionPane.ERROR_MESSAGE);
                }

        }

        private void deleteCourse() {
                int row = courseTable.getSelectedRow();
                if (row == -1) {
                        JOptionPane.showMessageDialog(this, "Please Select a course field.");
                        return;
                }

                int modelRow = courseTable.convertRowIndexToModel(row);
                Course course = courseTableModel.getCourse(modelRow);
                int confirm = JOptionPane.showConfirmDialog(this, "Delete Course : " + course.getCourseName() + "?",
                                "Confirm Delete", JOptionPane.YES_NO_OPTION);
                if (confirm != JOptionPane.YES_OPTION) {
                        return;
                }

                boolean deleted = courseController.deleteCourse(course.getCourseCode());
                if (deleted) {
                        loadCourses();
                        clearForm();
                        JOptionPane.showMessageDialog(this, "Course deleted successfully.");
                } else {
                        JOptionPane.showMessageDialog(this, "Course not found.");
                }

        }

        private void importData() {
                JFileChooser chooser = new JFileChooser();
                int result = chooser.showOpenDialog(this);
                if (result == JFileChooser.APPROVE_OPTION) {
                        try {
                                courseController.importCourses(chooser.getSelectedFile().getAbsolutePath());
                                loadCourses();
                                JOptionPane.showMessageDialog(this, "Course Imported Successfully.");
                        } catch (ValidationException ex) {
                                JOptionPane.showMessageDialog(this, ex.getMessage());
                        }
                }
        }

        private void exportData() {
                JFileChooser chooser = new JFileChooser();
                chooser.setSelectedFile(new File("courses.csv"));
                int option = chooser.showSaveDialog(this);
                if (option == JFileChooser.APPROVE_OPTION) {
                        courseController.exportCourses(chooser.getSelectedFile().getAbsolutePath());
                        JOptionPane.showMessageDialog(this, "Courses Exported Successfully.");
                }
        }

        private void searchCourse() {

        }

        private void clearForm() {
                txtCourseCode.setText("");
                txtCourseName.setText("");
                txtDuration.setText("");
                txtFees.setText("");
                courseTable.clearSelection();
        }
}
