package ui.panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.print.PrinterException;
import java.io.File;
import java.text.MessageFormat;
import java.time.LocalDate;
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
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import constant.AppConstants;
import controller.CourseController;
import controller.StudentController;
import exception.ValidationException;
import model.Course;
import model.Student;
import table.StudentTableModel;

public class StudentPanel extends JPanel {

        // =========================================================
        // COLORS
        // =========================================================

        private static final Color PRIMARY_COLOR = new Color(25, 118, 210);
        private static final Color PRIMARY_DARK = new Color(21, 101, 192);

        private static final Color BACKGROUND_COLOR = new Color(245, 247, 250);
        private static final Color PANEL_COLOR = Color.WHITE;

        private static final Color BORDER_COLOR = new Color(210, 215, 222);

        private static final Color TEXT_COLOR = new Color(35, 42, 50);
        private static final Color SECONDARY_TEXT = new Color(100, 110, 120);

        private static final Color TABLE_HEADER_COLOR = new Color(30, 136, 229);
        private static final Color TABLE_HEADER_TEXT = Color.WHITE;

        // =========================================================
        // COMPONENTS
        // =========================================================

        private JTextField txtStudentId;
        private JTextField txtFirstName;
        private JTextField txtLastName;
        private JTextField txtMobile;
        private JTextField txtAddress;
        private JTextField txtEmail;

        private JComboBox<String> cmbGender;
        private JComboBox<String> cmbCourse;

        private JButton btnSave;
        private JButton btnUpdate;
        private JButton btnDelete;
        private JButton btnClear;

        private JButton btnExport;
        private JButton btnBackup;
        private JButton btnRestore;
        private JButton btnPrint;

        private JTextField txtSearch;

        private JTable studentTable;
        private DefaultTableModel tableModel;
        private StudentTableModel studentTableModel;

        private TableRowSorter<StudentTableModel> sorter;

        private StudentController studentController;
        private CourseController courseController;
        // =========================================================
        // CONSTRUCTOR
        // =========================================================

        public StudentPanel() {

                studentController = new StudentController();
                courseController = new CourseController();

                initializeUI();
                loadCourses();
                loadStudents();
        }

        // =========================================================
        // MAIN UI
        // =========================================================

        // private void initializeUI() {

        // setLayout(new BorderLayout(15, 15));

        // setBorder(
        // BorderFactory.createEmptyBorder(
        // 15,
        // 18,
        // 15,
        // 18));

        // setBackground(BACKGROUND_COLOR);

        // add(createHeaderPanel(), BorderLayout.NORTH);

        // add(createCenterPanel(), BorderLayout.CENTER);
        // }

        private void initializeUI() {

                setLayout(new BorderLayout());

                setBackground(BACKGROUND_COLOR);

                // ---------------------------------------------------------
                // HEADER
                // ---------------------------------------------------------

                JPanel headerPanel = createHeaderPanel();

                add(headerPanel, BorderLayout.NORTH);

                // ---------------------------------------------------------
                // MAIN CONTENT
                // ---------------------------------------------------------

                JPanel centerPanel = createCenterPanel();

                JScrollPane mainScrollPane = new JScrollPane(centerPanel);

                mainScrollPane.setBorder(null);

                // Vertical scrollbar
                mainScrollPane.setVerticalScrollBarPolicy(
                                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

                // Horizontal scrollbar
                mainScrollPane.setHorizontalScrollBarPolicy(
                                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

                // Smooth scrolling
                mainScrollPane.getVerticalScrollBar().setUnitIncrement(16);

                // Remove viewport background
                mainScrollPane.getViewport().setBackground(
                                BACKGROUND_COLOR);

                add(mainScrollPane, BorderLayout.CENTER);
        }
        // =========================================================
        // HEADER
        // =========================================================

        private JPanel createHeaderPanel() {

                JPanel panel = new JPanel(new BorderLayout());
                panel.setOpaque(false);
                return panel;
        }

        private JPanel createCenterPanel() {

                JPanel panel = new JPanel(
                                new BorderLayout(15, 15));

                panel.setOpaque(false);

                panel.setBorder(
                                BorderFactory.createEmptyBorder(
                                                0,
                                                5,
                                                20,
                                                5));

                JPanel formPanel = createFormPanel();

                JPanel tablePanel = createTablePanel();

                panel.add(
                                formPanel,
                                BorderLayout.NORTH);

                panel.add(
                                tablePanel,
                                BorderLayout.CENTER);

                return panel;
        }
        // =========================================================
        // FORM PANEL
        // =========================================================

        private JPanel createFormPanel() {

                JPanel panel = new JPanel(new GridBagLayout());
                panel.setPreferredSize(new Dimension(0, 440));
                panel.setMinimumSize(new Dimension(0, 330));

                panel.setBackground(PANEL_COLOR);

                panel.setBorder(
                                BorderFactory.createCompoundBorder(

                                                BorderFactory.createTitledBorder(
                                                                BorderFactory.createLineBorder(
                                                                                BORDER_COLOR),
                                                                "Student Information"),

                                                BorderFactory.createEmptyBorder(
                                                                8,
                                                                15,
                                                                8,
                                                                15)));

                GridBagConstraints gbc = new GridBagConstraints();

                // gbc.insets = new Insets(
                // 5,
                // 5,
                // 5,
                // 5);

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

                txtStudentId = new JTextField();
                txtFirstName = new JTextField();
                txtLastName = new JTextField();
                txtMobile = new JTextField();
                txtEmail = new JTextField();
                txtAddress = new JTextField();

                styleTextField(txtStudentId);
                styleTextField(txtFirstName);
                styleTextField(txtLastName);
                styleTextField(txtMobile);
                styleTextField(txtEmail);
                styleTextField(txtAddress);

                // -----------------------------------------------------
                // COMBO BOX
                // -----------------------------------------------------

                cmbGender = new JComboBox<>(
                                new String[] {
                                                "Select Gender",
                                                "Male",
                                                "Female",
                                                "Other"
                                });

                // cmbCourse = new JComboBox<>(
                // new String[] {
                // "Select Course",
                // "B.Sc IT",
                // "B.Sc CS",
                // "BCA",
                // "MCA",
                // "B.Com",
                // "BBA"
                // });

                cmbCourse = new JComboBox<>();

                styleComboBox(cmbGender);
                styleComboBox(cmbCourse);

                // -----------------------------------------------------
                // FIELDS
                // -----------------------------------------------------

                int row = 0;

                addField(
                                panel,
                                gbc,
                                "Student ID",
                                txtStudentId,
                                row++);

                addField(
                                panel,
                                gbc,
                                "First Name",
                                txtFirstName,
                                row++);

                addField(
                                panel,
                                gbc,
                                "Last Name",
                                txtLastName,
                                row++);

                addField(
                                panel,
                                gbc,
                                "Gender",
                                cmbGender,
                                row++);

                addField(
                                panel,
                                gbc,
                                "Course",
                                cmbCourse,
                                row++);

                addField(
                                panel,
                                gbc,
                                "Mobile",
                                txtMobile,
                                row++);

                addField(
                                panel,
                                gbc,
                                "Email",
                                txtEmail,
                                row++);

                addField(
                                panel,
                                gbc,
                                "Address",
                                txtAddress,
                                row++);

                // -----------------------------------------------------
                // BUTTONS
                // -----------------------------------------------------

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

                btnExport = new JButton("Export");

                btnBackup = new JButton("Backup");
                btnRestore = new JButton("Restore");
                btnPrint = new JButton("Print");

                stylePrimaryButton(btnSave);
                styleSecondaryButton(btnUpdate);
                styleDangerButton(btnDelete);
                styleSecondaryButton(btnClear);
                styleSecondaryButton(btnBackup);
                styleExportButton(btnExport);
                stylePrimaryButton(btnRestore);
                stylePrimaryButton(btnPrint);

                buttonPanel.add(btnSave);
                buttonPanel.add(btnUpdate);
                buttonPanel.add(btnDelete);
                buttonPanel.add(btnClear);
                buttonPanel.add(btnBackup);
                buttonPanel.add(btnExport);
                buttonPanel.add(btnRestore);
                buttonPanel.add(btnPrint);

                gbc.gridx = 0;
                gbc.gridy = row;

                gbc.gridwidth = 2;

                gbc.weightx = 1;

                gbc.fill = GridBagConstraints.NONE;

                gbc.anchor = GridBagConstraints.WEST;

                panel.add(
                                buttonPanel,
                                gbc);

                // -----------------------------------------------------
                // ACTION LISTENERS
                // -----------------------------------------------------

                btnSave.addActionListener(
                                e -> saveStudent());

                btnUpdate.addActionListener(
                                e -> updateStudent());

                btnDelete.addActionListener(
                                e -> deleteStudent());

                btnClear.addActionListener(
                                e -> clearForm());

                btnExport.addActionListener(e -> exportData());

                btnBackup.addActionListener(e -> backupData());

                btnRestore.addActionListener(e -> restoreData());
                btnPrint.addActionListener(e -> printStudents());

                return panel;
        }

        // =========================================================
        // FORM FIELD
        // =========================================================

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

        // =========================================================
        // TABLE PANEL
        // =========================================================

        private JPanel createTablePanel() {

                JPanel panel = new JPanel(
                                new BorderLayout(
                                                10,
                                                10));

                panel.setOpaque(false);

                // -----------------------------------------------------
                // SEARCH
                // -----------------------------------------------------

                JPanel searchPanel = new JPanel(
                                new BorderLayout(
                                                10,
                                                0));

                searchPanel.setOpaque(false);

                JLabel searchLabel = new JLabel("Search");

                searchLabel.setFont(
                                new Font(
                                                "Segoe UI",
                                                Font.BOLD,
                                                13));

                searchLabel.setForeground(TEXT_COLOR);

                searchPanel.add(
                                searchLabel,
                                BorderLayout.WEST);

                txtSearch = new JTextField();

                styleSearchField(txtSearch);

                txtSearch.getDocument()
                                .addDocumentListener(
                                                new DocumentListener() {

                                                        @Override
                                                        public void insertUpdate(
                                                                        DocumentEvent e) {

                                                                searchStudent();
                                                        }

                                                        @Override
                                                        public void removeUpdate(
                                                                        DocumentEvent e) {

                                                                searchStudent();
                                                        }

                                                        @Override
                                                        public void changedUpdate(
                                                                        DocumentEvent e) {

                                                                searchStudent();
                                                        }
                                                });

                searchPanel.add(
                                txtSearch,
                                BorderLayout.CENTER);

                panel.add(
                                searchPanel,
                                BorderLayout.NORTH);

                // -----------------------------------------------------
                // TABLE
                // -----------------------------------------------------

                studentTableModel = new StudentTableModel();

                studentTable = new JTable(
                                studentTableModel);

                sorter = new TableRowSorter<>(
                                studentTableModel);

                studentTable.setRowSorter(sorter);

                // -----------------------------------------------------
                // TABLE STYLE
                // -----------------------------------------------------

                studentTable.setFont(
                                new Font(
                                                "Segoe UI",
                                                Font.PLAIN,
                                                13));

                studentTable.setForeground(TEXT_COLOR);

                studentTable.setBackground(Color.WHITE);

                studentTable.setRowHeight(30);

                studentTable.setShowGrid(true);

                studentTable.setGridColor(
                                new Color(
                                                225,
                                                228,
                                                232));

                studentTable.setSelectionBackground(
                                new Color(
                                                225,
                                                239,
                                                255));

                studentTable.setSelectionForeground(
                                TEXT_COLOR);

                studentTable.getTableHeader()
                                .setFont(
                                                new Font(
                                                                "Segoe UI",
                                                                Font.BOLD,
                                                                13));

                studentTable.getTableHeader()
                                .setForeground(
                                                TABLE_HEADER_TEXT);

                studentTable.getTableHeader()
                                .setBackground(
                                                TABLE_HEADER_COLOR);

                studentTable.getTableHeader()
                                .setPreferredSize(
                                                new Dimension(
                                                                0,
                                                                34));

                studentTable.setAutoResizeMode(
                                JTable.AUTO_RESIZE_ALL_COLUMNS);

                JScrollPane scrollPane = new JScrollPane(
                                studentTable);

                scrollPane.setBorder(
                                BorderFactory.createLineBorder(
                                                BORDER_COLOR));

                panel.add(
                                scrollPane,
                                BorderLayout.CENTER);

                studentTable.getSelectionModel()
                                .addListSelectionListener(
                                                e -> loadSelectedStudent());

                return panel;
        }

        // =========================================================
        // TEXT FIELD STYLE
        // =========================================================

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

        // =========================================================
        // SEARCH STYLE
        // =========================================================

        private void styleSearchField(
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
                                                                10,
                                                                5,
                                                                10)));
        }

        // =========================================================
        // COMBO BOX STYLE
        // =========================================================

        private void styleComboBox(
                        JComboBox<String> comboBox) {

                comboBox.setFont(
                                new Font(
                                                "Segoe UI",
                                                Font.PLAIN,
                                                14));

                comboBox.setPreferredSize(
                                new Dimension(
                                                250,
                                                34));

                comboBox.setBackground(
                                Color.WHITE);

                comboBox.setForeground(
                                TEXT_COLOR);
        }

        // =========================================================
        // PRIMARY BUTTON
        // =========================================================

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

        // =========================================================
        // SECONDARY BUTTON
        // =========================================================

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

        private void styleExportButton(JButton button) {
                button.setFont(new Font("Segoe UI", Font.BOLD, 13));
                button.setForeground(Color.WHITE);
                button.setBackground(new Color(255, 153, 0)); // orange
                button.setPreferredSize(new Dimension(130, 34));
                button.setFocusPainted(false);
                button.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));
        }

        // =========================================================
        // DELETE BUTTON
        // =========================================================

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

        // =========================================================
        // SAVE
        // =========================================================

        private void saveStudent() {

                Student student = createStudentFromForm();

                if (student == null) {
                        return;
                }

                try {

                        studentController.addStudent(student);

                        showSuccess(
                                        AppConstants.STUDENT_ADDED);

                        loadStudents();

                        clearForm();

                } catch (ValidationException ex) {

                        showError(
                                        ex.getMessage());
                }
        }

        // =========================================================
        // UPDATE
        // =========================================================

        private void updateStudent() {

                Student student = createStudentFromForm();

                if (student == null) {
                        return;
                }

                try {

                        studentController.updateStudent(student);

                        showSuccess(
                                        AppConstants.STUDENT_UPDATED);

                        loadStudents();

                        clearForm();

                } catch (ValidationException ex) {

                        showError(
                                        ex.getMessage());
                }
        }

        // =========================================================
        // DELETE
        // =========================================================

        private void deleteStudent() {

                String studentId = txtStudentId
                                .getText()
                                .trim();

                if (studentId.isEmpty()) {

                        JOptionPane.showMessageDialog(
                                        this,
                                        "Please select a student");

                        return;
                }

                int confirm = JOptionPane.showConfirmDialog(
                                this,
                                "Delete student " + studentId + "?",
                                "Confirm Delete",
                                JOptionPane.YES_NO_OPTION);

                if (confirm != JOptionPane.YES_OPTION) {
                        return;
                }

                try {

                        studentController.deleteStudent(
                                        studentId);

                        showSuccess(
                                        AppConstants.STUDENT_DELETED);

                        loadStudents();

                        clearForm();

                } catch (IllegalArgumentException ex) {

                        showError(
                                        ex.getMessage());
                }
        }

        // =========================================================
        // SEARCH
        // =========================================================

        private void searchStudent() {

                String keyword = txtSearch
                                .getText()
                                .trim();

                List<Student> students = studentController
                                .searchStudents(keyword);

                studentTableModel
                                .setStudents(students);
        }

        // =========================================================
        // CREATE STUDENT
        // =========================================================

        private Student createStudentFromForm() {

                String id = txtStudentId
                                .getText()
                                .trim();

                String firstName = txtFirstName
                                .getText()
                                .trim();

                String lastName = txtLastName
                                .getText()
                                .trim();

                String mobile = txtMobile
                                .getText()
                                .trim();

                String email = txtEmail
                                .getText()
                                .trim();

                String address = txtAddress
                                .getText()
                                .trim();

                String gender = (String) cmbGender
                                .getSelectedItem();

                String course = (String) cmbCourse
                                .getSelectedItem();

                if (id.isEmpty()
                                || firstName.isEmpty()
                                || lastName.isEmpty()) {

                        JOptionPane.showMessageDialog(
                                        this,
                                        "Student ID, First Name and Last Name are required.");

                        return null;
                }

                Student student = new Student();

                student.setStudentId(id);
                student.setFirstName(firstName);
                student.setLastName(lastName);
                student.setGender(gender);
                student.setCourse(course);
                student.setMobileNumber(mobile);
                student.setEmail(email);
                student.setAddress(address);
                student.setDateOfBirth(
                                LocalDate.now());

                return student;
        }

        // =========================================================
        // LOAD STUDENTS
        // =========================================================

        private void loadStudents() {
                refreshTable();
        }

        private void loadCourses() {
                cmbCourse.removeAllItems();
                cmbCourse.addItem("Select Course");
                List<Course> courses = courseController.getAllCourse();
                for (Course course : courses) {
                        cmbCourse.addItem(course.getCourseName());
                }
        }

        // =========================================================
        // LOAD SELECTED STUDENT
        // =========================================================

        private void loadSelectedStudent() {

                int viewRow = studentTable
                                .getSelectedRow();

                if (viewRow == -1) {
                        return;
                }

                int modelRow = studentTable
                                .convertRowIndexToModel(
                                                viewRow);

                Student student = studentTableModel
                                .getStudent(
                                                modelRow);

                txtStudentId.setText(
                                student.getStudentId());

                txtFirstName.setText(
                                student.getFirstName());

                txtLastName.setText(
                                student.getLastName());

                txtMobile.setText(
                                student.getMobileNumber());

                txtEmail.setText(
                                student.getEmail());

                txtAddress.setText(
                                student.getAddress());

                cmbGender.setSelectedItem(
                                student.getGender());

                cmbCourse.setSelectedItem(
                                student.getCourse());
        }

        // =========================================================
        // SUCCESS
        // =========================================================

        private void showSuccess(
                        String message) {

                JOptionPane.showMessageDialog(
                                this,
                                message,
                                AppConstants.SUCCESS,
                                JOptionPane.INFORMATION_MESSAGE);
        }

        // =========================================================
        // ERROR
        // =========================================================

        private void showError(
                        String message) {

                JOptionPane.showMessageDialog(
                                this,
                                message,
                                AppConstants.VALIDATION_ERROR,
                                JOptionPane.ERROR_MESSAGE);
        }

        // =========================================================
        // REFRESH TABLE
        // =========================================================

        private void refreshTable() {

                List<Student> students = studentController
                                .getAllStudents();

                studentTableModel
                                .setStudents(students);
        }

        // =========================================================
        // CLEAR FORM
        // =========================================================

        private void clearForm() {
                txtStudentId.setText("");
                txtFirstName.setText("");
                txtLastName.setText("");
                txtMobile.setText("");
                txtEmail.setText("");
                txtAddress.setText("");
                cmbCourse.setSelectedIndex(0);
                cmbGender.setSelectedIndex(0);
                studentTable.clearSelection();
        }

        private void exportData() {
                JFileChooser chooser = new JFileChooser();
                chooser.setSelectedFile(new File("student.csv"));
                int option = chooser.showSaveDialog(this);
                if (option == JFileChooser.APPROVE_OPTION) {
                        studentController.exportStudent(chooser.getSelectedFile().getAbsolutePath());
                        JOptionPane.showMessageDialog(this, "student Exported Successfully.");
                }
        }

        private void backupData() {
                try {
                        studentController.backupStudents();
                        JOptionPane.showMessageDialog(this, "Student backup created successfully.");
                } catch (Exception ex) {
                        JOptionPane.showMessageDialog(this, ex.getMessage(), "Backup Error", JOptionPane.ERROR_MESSAGE);
                }
        }

        private void restoreData() {
                try {
                        studentController.restoreCourse();
                        JOptionPane.showMessageDialog(this, "Student  restored successfully.");
                } catch (Exception ex) {
                        JOptionPane.showMessageDialog(this, ex.getMessage(), "Backup Error", JOptionPane.ERROR_MESSAGE);
                }
        }

        private void printStudents() {
                try {
                        MessageFormat header = new MessageFormat("Student Report");
                        MessageFormat footer = new MessageFormat("Page {0}");
                        boolean complete = studentTable.print(JTable.PrintMode.FIT_WIDTH, header, footer);
                        if (complete) {
                                showSuccess("Printing completed");
                        } else {
                                showError("Printing cancelled.");
                        }
                } catch (PrinterException ex) {
                        showError(ex.getMessage());
                }
        }
}