package service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import model.Course;

public class CourseFileService {

    private static final String FILE_NAME = "Course.dat";

    public void saveCourse(List<Course> courses) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            out.writeObject(courses);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public List<Course> loadCourses() {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            return new ArrayList<>();
        }
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
            return (List<Course>) in.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public List<Course> importCSV(String fileName) {
        List<Course> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                Course course = new Course(data[0], data[1], data[2], Double.parseDouble(data[3]));
                list.add(course);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void exportCSV(List<Course> courses, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("CourseCode,CourseName,Duration,Fees");
            writer.newLine();
            for (Course course : courses) {
                writer.write(course.getCourseCode() + "," + course.getCourseName() + "," + course.getDuration() + ","
                        + course.getFees());

                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
