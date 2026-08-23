package controller;

import java.util.List;

import exception.ValidationException;
import model.Course;
import model.CourseStatistics;
import model.Student;
import service.CourseService;

public class CourseController {

    private final CourseService courseService;

    public CourseController() {
        courseService = new CourseService();
    }

    public void addCourse(Course course) throws ValidationException {
        courseService.addCourse(course);
    }

    public List<Course> getAllCourse() {
        return courseService.getAllCourse();
    }

    public void updateCourse(Course course) throws ValidationException {
        courseService.updateCourse(course);
    }

    public boolean deleteCourse(String courseId) {
        return courseService.deleteCourse(courseId);
    }

    public List<Course> searchCourse(String keyword) {
        return courseService.searchCourses(keyword);
    }

    public void importCourses(String fileName) throws ValidationException {
        courseService.importCourses(fileName);
    }

    public void exportCourses(String fileName) {
        courseService.exportCourses(fileName);
    }

    public void sortByCourseName() {
        courseService.sortByCourseName();
    }

    public void sortByFees() {
        courseService.sortByFees();
    }

    public void sortByDuration() {
        courseService.sortByDuration();
    }

    public List<Course> getAllCourses() {
        return courseService.getAllCourse();
    }

    public int getCourseCount() {
        return courseService.getCourseCount();
    }

    public CourseStatistics getStatistics() {
        return courseService.getStatistics();
    }
}
