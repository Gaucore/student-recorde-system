package ui.panel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import controller.CourseController;
import controller.StudentController;
import model.Course;
import ui.chart.BarChartPanel;
import ui.chart.PieChartPanel;

public class DashboardPanel extends JPanel {

        private StudentController studentController;
        private CourseController courseController;

        private BarChartPanel barChartPanel;
        private PieChartPanel pieChartPanel;

        public DashboardPanel() {

                studentController = new StudentController();
                courseController = new CourseController();

                initialize();

                loadCharts();

        }

        private void initialize() {

                setLayout(new BorderLayout(15, 15));

                setBorder(
                                BorderFactory.createEmptyBorder(15, 15, 15, 15));

                add(
                                new StatisticsPanel(),
                                BorderLayout.NORTH);

                JPanel chartContainer = new JPanel(new GridLayout(1, 2, 20, 20));
                chartContainer.setPreferredSize(new Dimension(900, 400));

                chartContainer.setOpaque(false);

                barChartPanel = new BarChartPanel();

                pieChartPanel = new PieChartPanel();

                chartContainer.add(barChartPanel);

                chartContainer.add(pieChartPanel);

                add(
                                chartContainer,
                                BorderLayout.CENTER);

                add(
                                new StatusPanel(),
                                BorderLayout.SOUTH);

        }

        private void loadCharts() {
                Map<String, Double> courseData = new LinkedHashMap<>();
                for (Course course : courseController.getAllCourses()) {
                        courseData.put(
                                        course.getCourseName(),
                                        course.getFees());
                }

                barChartPanel.setChartData(courseData);
                Map<String, Integer> studentData = new LinkedHashMap<>();

                studentData.put(
                                "Male",
                                studentController.getMaleStudentCount());

                studentData.put(
                                "Female",
                                studentController.getFemaleStudentCount());

                studentData.put(
                                "Other",
                                studentController.getOtherStudentCount());

                pieChartPanel.setChartData(studentData);

        }

}