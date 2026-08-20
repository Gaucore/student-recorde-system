package model;

import java.io.Serializable;

public class Course implements Serializable {

    private String courseCode;
    private String courseName;
    private String duration;
    private double fees;
    private static final long serialVersionUID = 1L;

    public Course(String courseCode, String courseName, String duration, double fees) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.duration = duration;
        this.fees = fees;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public double getFees() {
        return fees;
    }

    public void setFees(double fees) {
        this.fees = fees;
    }

    @Override
    public String toString() {
        return courseCode + " - " + courseName;
    }
}
