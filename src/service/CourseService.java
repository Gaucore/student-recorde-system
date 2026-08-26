package service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import exception.ValidationException;
import model.Course;
import model.CourseStatistics;
import util.BackupManager;
import validation.CourseValidator;

public class CourseService {

    private final CourseFileService fileService = new CourseFileService();

    // private final List<Course> courses = new ArrayList<>();
    private List<Course> courses;
    private final CourseValidator validator = new CourseValidator();

    public CourseService() {
        courses = fileService.loadCourses();
    }

    // Add Course ;
    public void addCourse(Course course) throws ValidationException {
        validator.validate(course);
        for (Course c : courses) {
            if (c.getCourseCode().equalsIgnoreCase(course.getCourseCode())) {
                throw new ValidationException("Course Code already exists.");
            }
        }
        courses.add(course);
        fileService.saveCourse(courses);
    }

    // Get All Courses;
    public List<Course> getAllCourse() {
        return courses;
    }

    public int getCourseCount() {
        return courses.size();
    }

    // search Course;
    // Search Course
    public List<Course> searchCourses(String keyword) {

        List<Course> result = new ArrayList<>();

        if (keyword == null || keyword.trim().isEmpty()) {
            result.addAll(courses);
            return result;
        }

        keyword = keyword.toLowerCase().trim();

        for (Course course : courses) {

            if (course.getCourseCode().toLowerCase().contains(keyword)
                    || course.getCourseName().toLowerCase().contains(keyword)
                    || course.getDuration().toLowerCase().contains(keyword)
                    || String.valueOf(course.getFees()).contains(keyword)) {

                result.add(course);
            }
        }

        return result;
    }

    // update Course;
    public void updateCourse(Course updatedCourse) throws ValidationException {
        validator.validate(updatedCourse);

        for (int i = 0; i < courses.size(); i++) {
            Course course = courses.get(i);
            if (course.getCourseCode()
                    .equalsIgnoreCase(updatedCourse.getCourseCode())) {
                courses.set(i, updatedCourse);
                fileService.saveCourse(courses);
                return;
            }
        }
        throw new ValidationException("Course not found.");
    }

    // Delete Course
    public boolean deleteCourse(String courseCode) {
        boolean removed = courses.removeIf(course -> course.getCourseCode().equals(courseCode));

        if (removed) {
            fileService.saveCourse(courses);
        }

        return removed;
    }

    // import csv

    public void importCourses(String fileName) throws ValidationException {
        List<Course> imported = fileService.importCSV(fileName);
        for (Course course : imported) {
            boolean exists = false;
            for (Course c : courses) {
                if (c.getCourseCode().equalsIgnoreCase(course.getCourseCode())) {
                    exists = true;
                    break;
                }
            }
            if (!exists) {
                validator.validate(course);
                courses.add(course);
            }
        }

        fileService.saveCourse(courses);

    }

    public void exportCourses(String fileName) {
        fileService.exportCSV(courses, fileName);
    }

    public void sortByCourseName() {
        Collections.sort(courses, Comparator.comparing(Course::getCourseName));
    }

    public void sortByFees() {
        Collections.sort(courses, Comparator.comparing(Course::getFees));
    }

    public void sortByDuration() {
        Collections.sort(courses, Comparator.comparing(Course::getDuration));
    }

    public CourseStatistics getStatistics() {
        if (courses.isEmpty()) {
            return new CourseStatistics(0, 0, 0, 0);
        }

        double highest = courses.get(0).getFees();
        double lowest = courses.get(0).getFees();

        double total = 0;
        for (Course course : courses) {
            double fee = course.getFees();
            total += fee;
            if (fee > highest) {
                highest = fee;
            }
            if (fee < lowest) {
                lowest = fee;
            }
        }

        double average = total / courses.size();

        return new CourseStatistics(courses.size(), highest, lowest, average);
    }

    public void backupCourses() throws IOException {
        BackupManager.backupFile("Course.dat", "course_backup.dat");
    }

    public void restoreCourse() throws IOException {
        BackupManager.restoreFile("course_backup.dat", "Course.dat");
    }

}
