package ui.panel;

import java.awt.GridLayout;

import javax.swing.JPanel;

import controller.CourseController;
import controller.StudentController;
import model.CourseStatistics;
import ui.component.DashboardCard;

public class StatisticsPanel extends JPanel {

    private StudentController studentController;
    private CourseController courseController;

    public StatisticsPanel() {

        studentController = new StudentController();
        courseController = new CourseController();

        initialize();
    }

    private void initialize() {

        setOpaque(false);
        setLayout(new GridLayout(1, 4, 15, 15));

        // Total Students
        int totalStudents = studentController.getStudentCount();

        // Course Statistics
        CourseStatistics statistics = courseController.getStatistics();

        add(new DashboardCard(
                "Students",
                String.valueOf(totalStudents)));

        add(new DashboardCard(
                "Courses",
                String.valueOf(statistics.getTotalCourses())));

        add(new DashboardCard(
                "Highest Fee",
                "₹" + statistics.getHighestFee()));

        add(new DashboardCard(
                "Average Fee",
                "₹" + String.format("%.2f",
                        statistics.getAverageFee())));
    }
}