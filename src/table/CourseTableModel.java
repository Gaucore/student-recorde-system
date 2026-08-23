package table;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Course;
import model.Student;

public class CourseTableModel extends AbstractTableModel {

    private final String[] columns = {
            "Course Code",
            "Course Name",
            "Duration",
            "Fees"
    };

    private List<Course> courses = new ArrayList<>();

    @Override
    public int getRowCount() {
        return courses.size();
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
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 3:
                return Double.class; // Fees column
            default:
                return String.class;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Course course = courses.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return course.getCourseCode();

            case 1:
                return course.getCourseName();

            case 2:
                return course.getDuration();

            case 3:
                return course.getFees();

            default:
                return "";
        }
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
        fireTableDataChanged();
    }

    public Course getCourse(int row) {
        return courses.get(row);
    }
}
