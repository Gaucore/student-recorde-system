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
                setLayout(new GridLayout(2, 3, 15, 15));

                int totalStudents = studentController.getStudentCount();

                int totalMaleStudents = studentController.getMaleStudentCount();
                int totalFemaleStudents = studentController.getFemaleStudentCount();

                CourseStatistics statistics = courseController.getStatistics();

                add(new DashboardCard(
                                "Total Students",
                                String.valueOf(totalStudents)));

                add(new DashboardCard(
                                "Total Courses",
                                String.valueOf(statistics.getTotalCourses())));

                add(new DashboardCard(
                                "Male Students",
                                String.valueOf(totalMaleStudents)));

                add(new DashboardCard(
                                "Female Students",
                                String.valueOf(totalFemaleStudents)));

                add(new DashboardCard(
                                "Highest Fee",
                                "₹" + statistics.getHighestFee()));

                add(new DashboardCard(
                                "Average Fee",
                                "₹" + String.format("%.2f",
                                                statistics.getAverageFee())));
        }
}