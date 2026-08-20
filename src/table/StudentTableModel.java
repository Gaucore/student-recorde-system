package table;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Student;

public class StudentTableModel extends AbstractTableModel {

    private final String[] columns = {
            "ID",
            "First Name",
            "Last Name",
            "Gender",
            "Course",
            "Mobile",
            "Email"
    };

    private List<Student> students = new ArrayList<>();

    @Override

    public int getRowCount() {
        return students.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    @Override
    public Object getValueAt(
            int rowIndex,
            int columnIndex) {

        Student student = students.get(rowIndex);

        switch (columnIndex) {

            case 0:
                return student.getStudentId();

            case 1:
                return student.getFirstName();

            case 2:
                return student.getLastName();

            case 3:
                return student.getGender();

            case 4:
                return student.getCourse();

            case 5:
                return student.getMobileNumber();

            case 6:
                return student.getEmail();

            default:
                return "";

        }

    }

    public void setStudents(List<Student> students) {
        this.students = new ArrayList<>(students);
        fireTableDataChanged();
    }

    public Student getStudent(int row) {
        return students.get(row);
    }

}