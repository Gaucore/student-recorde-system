// package ui.panel.student;

// import java.awt.Color;
// import java.awt.Dimension;
// import java.awt.FlowLayout;
// import java.awt.GridBagConstraints;
// import java.awt.GridBagLayout;
// import java.awt.Insets;

// import javax.swing.BorderFactory;
// import javax.swing.JComboBox;
// import javax.swing.JComponent;
// import javax.swing.JLabel;
// import javax.swing.JPanel;

// import ui.component.FormTextField;
// import ui.component.PrimaryButton;
// import ui.component.SecondaryButton;

// public class StudentFormPanel extends JPanel {
//     private FormTextField txtStudentId;
//     private FormTextField txtFirstName, txtLastName;
//     private FormTextField txtMobile;
//     private FormTextField txtEmail;
//     private FormTextField txtAddress;
//     private JComboBox<String> cmbGender;
//     private JComboBox<String> cmbCourse;

//     private PrimaryButton btnSave;
//     private SecondaryButton btnUpdate;
//     private SecondaryButton btnDelete;
//     private SecondaryButton btnClear;

//     public StudentFormPanel() {

//         initialize();

//     }

//     private void initialize() {
//         setLayout(new GridBagLayout());
//         setBorder(
//                 BorderFactory.createCompoundBorder(
//                         BorderFactory.createTitledBorder(
//                                 BorderFactory.createLineBorder(
//                                         new Color(220, 220, 220)),
//                                 "Student Information"),
//                         BorderFactory.createEmptyBorder(
//                                 25,
//                                 25,
//                                 25,
//                                 25)));
//         setBackground(java.awt.Color.WHITE);
//         setPreferredSize(new Dimension(520, 0));
//         createComponent();
//         buildForm();
//     }

//     private void createComponent() {
//         txtStudentId = new FormTextField(18);
//         txtFirstName = new FormTextField(18);
//         txtLastName = new FormTextField(18);
//         txtMobile = new FormTextField(18);
//         txtEmail = new FormTextField(18);
//         txtAddress = new FormTextField(18);
//         cmbGender = new JComboBox<String>(new String[] {
//                 "Select Gender",
//                 "Male",
//                 "Female"
//         });
//         cmbGender.setPreferredSize(new Dimension(300, 40));
//         cmbCourse = new JComboBox<>(new String[] {
//                 "Select Course",
//                 "B.Sc IT",
//                 "B.Sc CS",
//                 "BCA",
//                 "MCA",
//                 "B.Com",
//                 "BBA"
//         });
//         cmbCourse.setPreferredSize(new Dimension(300, 40));

//         btnSave = new PrimaryButton("Save");
//         btnUpdate = new SecondaryButton("Update");
//         btnDelete = new SecondaryButton("Delete");
//         btnClear = new SecondaryButton("Clear");

//     }

//     private void buildForm() {

//         GridBagConstraints gbc = new GridBagConstraints();
//         gbc.insets = new Insets(8, 8, 8, 8);
//         gbc.anchor = GridBagConstraints.WEST;
//         gbc.fill = GridBagConstraints.HORIZONTAL;
//         gbc.weightx = 1;
//         int row = 0;

//         addField(this, gbc, "Student ID", txtStudentId, row++);
//         addField(this, gbc, "First Name", txtFirstName, row++);
//         addField(this, gbc, "Last Name", txtLastName, row++);
//         addField(this, gbc, "Gender", cmbGender, row++);
//         addField(this, gbc, "Course", cmbCourse, row++);
//         addField(this, gbc, "Mobile", txtMobile, row++);
//         addField(this, gbc, "Email", txtEmail, row++);
//         addField(this, gbc, "Address", txtAddress, row++);

//         JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
//         buttonPanel.setOpaque(false);

//         buttonPanel.add(btnSave);
//         buttonPanel.add(btnUpdate);
//         buttonPanel.add(btnDelete);
//         buttonPanel.add(btnClear);

//         gbc.gridx = 0;
//         gbc.gridy = row;
//         gbc.gridwidth = 2;
//         gbc.weightx = 1;
//         gbc.fill = GridBagConstraints.NONE;

//         add(buttonPanel, gbc);

//         gbc.gridy = row + 1;
//         gbc.weighty = 1;
//         add(new JPanel(), gbc);
//     }

//     private void addField(JPanel panel, GridBagConstraints gbc, String title, JComponent component, int row) {
//         gbc.gridx = 0;
//         gbc.gridy = row;
//         gbc.weightx = 0;
//         gbc.fill = GridBagConstraints.NONE;
//         gbc.anchor = GridBagConstraints.WEST;

//         JLabel lbl = new JLabel(title);
//         lbl.setPreferredSize(new Dimension(120, 38));

//         panel.add(lbl, gbc);

//         // Text Field
//         gbc.gridx = 1;
//         gbc.gridy = row; // <-- THIS WAS YOUR BUG
//         gbc.weightx = 1;
//         gbc.fill = GridBagConstraints.HORIZONTAL;

//         panel.add(component, gbc);
//     }

// }

package ui.panel.student;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

import ui.component.FormTextField;
import ui.component.PrimaryButton;
import ui.component.SecondaryButton;

public class StudentFormPanel extends JPanel {

    private FormTextField txtStudentId;
    private FormTextField txtFirstName;
    private FormTextField txtLastName;
    private FormTextField txtMobile;
    private FormTextField txtEmail;
    private FormTextField txtAddress;

    private JComboBox<String> cmbGender;
    private JComboBox<String> cmbCourse;

    private PrimaryButton btnSave;
    private SecondaryButton btnUpdate;
    private SecondaryButton btnDelete;
    private SecondaryButton btnClear;

    public StudentFormPanel() {

        initialize();

    }

    private void initialize() {

        setBackground(Color.WHITE);

        setLayout(new GridBagLayout());

        Border outer = BorderFactory.createLineBorder(
                new Color(220, 220, 220));

        Border inner = BorderFactory.createEmptyBorder(
                20, 20, 20, 20);

        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder(
                        outer,
                        "Student Information"),
                inner));

        createComponents();

        buildForm();

    }

    private void createComponents() {

        Dimension fieldSize = new Dimension(320, 40);

        txtStudentId = new FormTextField(20);
        txtFirstName = new FormTextField(20);
        txtLastName = new FormTextField(20);
        txtMobile = new FormTextField(20);
        txtEmail = new FormTextField(20);
        txtAddress = new FormTextField(20);

        txtStudentId.setPreferredSize(fieldSize);
        txtFirstName.setPreferredSize(fieldSize);
        txtLastName.setPreferredSize(fieldSize);
        txtMobile.setPreferredSize(fieldSize);
        txtEmail.setPreferredSize(fieldSize);
        txtAddress.setPreferredSize(fieldSize);
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
                "BBA"
        });

        Font comboFont = new Font("Segoe UI", Font.PLAIN, 14);

        cmbGender.setFont(comboFont);
        cmbCourse.setFont(comboFont);

        cmbGender.setPreferredSize(fieldSize);
        cmbCourse.setPreferredSize(fieldSize);

        btnSave = new PrimaryButton("Save");
        btnUpdate = new SecondaryButton("Update");
        btnDelete = new SecondaryButton("Delete");
        btnClear = new SecondaryButton("Clear");
    }

    private void buildForm() {

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(12, 12, 12, 12);

        gbc.anchor = GridBagConstraints.WEST;

        int row = 0;

        addField(gbc, "Student ID", txtStudentId, row++);
        addField(gbc, "First Name", txtFirstName, row++);
        addField(gbc, "Last Name", txtLastName, row++);
        addField(gbc, "Gender", cmbGender, row++);
        addField(gbc, "Course", cmbCourse, row++);
        addField(gbc, "Mobile", txtMobile, row++);
        addField(gbc, "Email", txtEmail, row++);
        addField(gbc, "Address", txtAddress, row++);

        addButtonPanel(gbc, row);

    }

    private JLabel createLabel(String text) {
        JLabel label = new JLabel(text);

        label.setFont(new Font("Segoe UI", Font.BOLD, 14));
        label.setForeground(new Color(70, 70, 70));
        label.setPreferredSize(new Dimension(120, 40));

        return label;

    }

    private void addField(
            GridBagConstraints gbc,
            String label,
            JComponent component,
            int row) {

        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.weightx = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.NONE;

        add(createLabel(label), gbc);

        gbc.gridx = 1;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        add(component, gbc);
    }

    private void addButtonPanel(GridBagConstraints gbc, int row) {

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        buttonPanel.setOpaque(false);

        buttonPanel.add(btnSave);
        buttonPanel.add(btnUpdate);
        buttonPanel.add(btnDelete);
        buttonPanel.add(btnClear);

        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.gridwidth = 2;
        gbc.weightx = 1;
        gbc.weighty = 0;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.WEST;

        add(buttonPanel, gbc);
    }
}