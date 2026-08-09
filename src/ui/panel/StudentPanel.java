package ui.panel;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.time.LocalDate;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import constant.AppConstants;
import controller.StudentController;
import model.Student;
import table.StudentTableModel;

public class StudentPanel extends JPanel {

    private JTextField txtStudentId;
    private JTextField txtFirstName;
    private JTextField txtLastName;
    private JTextField txtMobile;
    private JTextField txtAddress;
    private JTextField txtEmail;

    private JComboBox<String> cmbGender;
    private JComboBox<String> cmbCourse;

    private JButton btnSave, btnUpdate, btnDelete, btnClear;

    private JTextField txtSearch;

    private JTable studentTable;
    private DefaultTableModel tableModel;
    private StudentTableModel studentTableModel;

    private TableRowSorter<StudentTableModel> sorter;

    private StudentController studentController;

    public StudentPanel() {

        studentController = new StudentController();
        initializeUI();
        loadStudents();
    }

    private void initializeUI() {
        setLayout(new BorderLayout(15, 15));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(createHeaderPanel(), BorderLayout.NORTH);
        add(createCenterPanel(), BorderLayout.CENTER);
    }

    private JPanel createHeaderPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        JLabel title = new JLabel("Student Management");
        title.setFont(new Font("Segoe UI", Font.BOLD, 28));
        panel.add(title, BorderLayout.WEST);
        return panel;
    }

    private JPanel createCenterPanel() {
        JPanel panel = new JPanel(new BorderLayout(15, 15));
        panel.add(createFormPanel(), BorderLayout.NORTH);
        panel.add(createTablePanel(), BorderLayout.CENTER);
        return panel;
    }

    private JPanel createFormPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Student Information"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;
        txtStudentId = new JTextField();
        txtFirstName = new JTextField();
        txtLastName = new JTextField();
        txtMobile = new JTextField();
        txtEmail = new JTextField();
        txtAddress = new JTextField();

        cmbGender = new JComboBox<>(new String[] {
                "Select Gender",
                "Male",
                "Female",
                "Other"
        });

        cmbCourse = new JComboBox<>(new String[] {
                "Select Course",
                "B.Sc IT",
                "B.Sc CS",
                "BCA",
                "MCA",
                "BCA"
        });

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

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        btnSave = new JButton("Save");
        btnUpdate = new JButton("Update");
        btnDelete = new JButton("Delete");
        btnClear = new JButton("Clear");

        buttonPanel.add(btnSave);
        buttonPanel.add(btnUpdate);
        buttonPanel.add(btnDelete);
        buttonPanel.add(btnClear);

        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.gridwidth = 2;

        panel.add(buttonPanel, gbc);

        btnSave.addActionListener(e -> saveStudent());

        btnUpdate.addActionListener(e -> updateStudent());

        btnDelete.addActionListener(e -> deleteStudent());

        btnClear.addActionListener(e -> clearForm());

        return panel;
    }

    private void addField(JPanel panel, GridBagConstraints gbc, String label, JComponent component, int row) {
        gbc.gridx = 0;
        gbc.gridy = row;

        gbc.gridwidth = 1;
        panel.add(new JLabel(label), gbc);

        gbc.gridx = 1;
        panel.add(component, gbc);
    }

    private JPanel createTablePanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        JPanel searchPanel = new JPanel(new BorderLayout(10, 10));

        searchPanel.add(new JLabel("Search"), BorderLayout.WEST);
        txtSearch = new JTextField();

        txtSearch.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                searchStudent();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {

                searchStudent();

            }

            @Override
            public void changedUpdate(DocumentEvent e) {

                searchStudent();

            }

        });

        searchPanel.add(txtSearch, BorderLayout.CENTER);
        panel.add(searchPanel, BorderLayout.NORTH);
        String[] columns = {
                "Student ID",
                "First Name",
                "Last Name",
                "Gender",
                "Course",
                "Email",
                "Mobile"
        };

        // tableModel = new DefaultTableModel(columns, 0) {
        // @Override
        // public boolean isCellEditable(int row, int column) {
        // return false;
        // }
        // };

        studentTableModel = new StudentTableModel();

        studentTable = new JTable(studentTableModel);

        sorter = new TableRowSorter<>(studentTableModel);
        studentTable.setRowSorter(sorter);

        studentTable.setRowHeight(28);
        JScrollPane scrollPane = new JScrollPane(studentTable);

        panel.add(scrollPane, BorderLayout.CENTER);
        studentTable.getSelectionModel().addListSelectionListener(e -> loadSelectedStudent());

        return panel;

    }

    private void saveStudent() {
        Student student = createStudentFromForm();
        if (student == null) {
            return;
        }

        try {
            studentController.addStudent(student);
            // JOptionPane.showMessageDialog(this, "Student Save successfully.");
            showSuccess(AppConstants.STUDENT_ADDED);
            loadStudents();
            clearForm();
        } catch (IllegalArgumentException ex) {
            // JOptionPane.showMessageDialog(this, ex.getMessage(), "Validation Error",
            // JOptionPane.ERROR_MESSAGE);
            showError(ex.getMessage());
        }

    }

    private void updateStudent() {
        Student student = createStudentFromForm();
        if (student == null) {
            return;
        }
        try {
            studentController.updateStudent(student);
            // JOptionPane.showMessageDialog(this, "Student Updated successfully.");
            showSuccess(AppConstants.STUDENT_UPDATED);
            loadStudents();
            clearForm();

        } catch (IllegalArgumentException ex) {
            // JOptionPane.showMessageDialog(this, ex.getMessage(), "Validation Error",
            // JOptionPane.ERROR_MESSAGE);
            showError(ex.getMessage());
        }

    }

    private void deleteStudent() {
        String studentId = txtStudentId.getText().trim();
        if (studentId.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please select a student");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this,
                "Delete student" + studentId + "?" + "Confirm Delete" + JOptionPane.YES_NO_OPTION);
        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }
        try {
            studentController.deleteStudent(studentId);
            showSuccess(AppConstants.STUDENT_DELETED);
            loadStudents();
            clearForm();

        } catch (IllegalArgumentException ex) {
            showError(ex.getMessage());
        }
        // if (success) {
        // // JOptionPane.showMessageDialog(this, "Student Deleted Successfully.");

        // } else {
        // JOptionPane.showMessageDialog(this, "Student Not Found", "Error",
        // JOptionPane.ERROR_MESSAGE);
        // }
    }

    private void searchStudent() {
        String keyword = txtSearch.getText().trim();
        List<Student> students = studentController.searchStudents(keyword);
        studentTableModel.setStudents(students);
    }

    private Student createStudentFromForm() {

        String id = txtStudentId.getText().trim();

        String firstName = txtFirstName.getText().trim();

        String lastName = txtLastName.getText().trim();

        String mobile = txtMobile.getText().trim();

        String email = txtEmail.getText().trim();

        String address = txtAddress.getText().trim();

        String gender = (String) cmbGender.getSelectedItem();

        String course = (String) cmbCourse.getSelectedItem();

        if (id.isEmpty() || firstName.isEmpty() || lastName.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Student ID, First Name and Last Name are required.");
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
        student.setDateOfBirth(LocalDate.now());

        return student;
    }

    private void loadStudents() {

        // List<Student> students = studentController.getAllStudents();
        // studentTableModel.setStudents(students);

        refreshTable();

    }

    private void loadSelectedStudent() {

        int viewRow = studentTable.getSelectedRow();

        if (viewRow == -1) {
            return;
        }

        int modelRow = studentTable.convertRowIndexToModel(viewRow);

        Student student = studentTableModel.getStudent(modelRow);

        txtStudentId.setText(student.getStudentId());
        txtFirstName.setText(student.getFirstName());
        txtLastName.setText(student.getLastName());
        txtMobile.setText(student.getMobileNumber());
        txtEmail.setText(student.getEmail());
        txtAddress.setText(student.getAddress());

        cmbGender.setSelectedItem(student.getGender());
        cmbCourse.setSelectedItem(student.getCourse());
    }

    private void showSuccess(String message) {
        JOptionPane.showMessageDialog(this, message, AppConstants.SUCCESS, JOptionPane.INFORMATION_MESSAGE);
    }

    private void showError(String message) {
        JOptionPane.showMessageDialog(this, message, AppConstants.VALIDATION_ERROR, JOptionPane.ERROR_MESSAGE);
    }

    private void refreshTable() {
        List<Student> students = studentController.getAllStudents();
        studentTableModel.setStudents(students);
    }

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

}