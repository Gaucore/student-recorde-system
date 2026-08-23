package model;

public class CourseStatistics {
    private int totalCourses;
    private double highestFee;
    private double lowestFee;
    private double averageFee;

    public CourseStatistics(int totalCourses, double highestFee, double lowestFee, double averageFee) {
        this.totalCourses = totalCourses;
        this.highestFee = highestFee;
        this.lowestFee = lowestFee;
        this.averageFee = averageFee;
    }

    public int getTotalCourses() {
        return totalCourses;
    }

    public double getHighestFee() {
        return highestFee;
    }

    public double getLowestFee() {
        return lowestFee;
    }

    public double getAverageFee() {
        return averageFee;
    }

}