package validation;

import exception.ValidationException;
import model.Course;

public class CourseValidator {
    public void validate(Course course) throws ValidationException {

        if (course.getCourseCode() == null || course.getCourseCode().trim().isEmpty()) {
            throw new ValidationException("Course Code is required.");
        }

        if (course.getCourseName() == null || course.getCourseName().trim().isEmpty()) {
            throw new ValidationException("Course name is required.");
        }

        if (course.getFees() <= 0) {
            throw new ValidationException("Fees must be greater than zero.");
        }

        if (course.getDuration() == null || course.getDuration().trim().isEmpty()) {
            throw new ValidationException("Course duration is required");
        }

        if (!course.getDuration().matches("^[0-9]+\\s*(Month|Months|Year|Years)$")) {
            throw new ValidationException("Duration should be like '3 Months' or '1 Year'.");
        }

        if (course.getFees() > 500000) {
            throw new ValidationException("Fees amount is too large.");
        }

        course.setCourseCode(course.getCourseCode().trim());
        course.setCourseName(course.getCourseName());
        course.setDuration(course.getDuration().trim());
    }
}