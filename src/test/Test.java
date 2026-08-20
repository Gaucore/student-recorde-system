package test;

import controller.LoginController;
import model.Course;
import service.CourseService;

public class Test {

    public static void main(String[] args) {
        CourseService courseService = new CourseService();

        Course course = new Course("BCA", "Bachelor of Computer Applications", "3 Years", 85000);

        courseService.addCourse(course);

        System.out.println("All Courses:");
        System.out.println(courseService.getAllCourse());

        System.out.println("Search Result:");
        System.out.println(courseService.searchCourses("BCA"));

        Course updated = new Course("BCA", "BCA Updated", "4 Years", 90000);

        boolean isUpdated = courseService.updateCourse(updated);
        System.out.println("Updated: " + isUpdated);

        System.out.println("After Update:");
        System.out.println(courseService.getAllCourse());

        boolean isDeleted = courseService.deleteCourse("BCA");
        System.out.println("Deleted: " + isDeleted);

        System.out.println("After Delete:");
        System.out.println(courseService.getAllCourse());
    }

}
