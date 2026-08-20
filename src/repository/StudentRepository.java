package repository;

import model.Course;
import model.Student;

import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class StudentRepository {

    private List<Student> students;

    private static final String FILE_NAME = "data/student.dat";

    public StudentRepository() {
        students = new ArrayList<>();
        loadFromFile();
    }

    public void addStudent(Student student) {
        students.add(student);
        saveToFile();
    }

    public List<Student> getAllStudents() {
        return students;
    }

    public Student findById(String studentId) {
        for (Student student : students) {
            if (student.getStudentId().equals(studentId)) {
                return student;
            }

        }
        return null;
    }

    public Student findByEmail(String email) {
        for (Student student : students) {
            if (student.getEmail() != null && student.getEmail().equalsIgnoreCase(email)) {
                return student;
            }
        }

        return null;
    }

    public Student findByMobile(String mobile) {
        for (Student student : students) {
            if (student.getMobileNumber() != null && student.getMobileNumber().equals(mobile)) {
                return student;
            }
        }

        return null;
    }

    public boolean deleteStudent(String studentId) {
        Student student = findById(studentId);
        if (student != null) {
            students.remove(student);
            saveToFile();
            return true;
        }
        return false;
    }

    public boolean updateStudent(Student updateStudent) {
        Student existing = findById(updateStudent.getStudentId());

        if (existing != null) {
            existing.setFirstName(updateStudent.getFirstName());
            existing.setLastName(updateStudent.getLastName());
            existing.setGender(updateStudent.getGender());
            existing.setAddress(updateStudent.getAddress());
            existing.setCourse(updateStudent.getCourse());
            existing.setDateOfBirth(updateStudent.getDateOfBirth());
            existing.setEmail(updateStudent.getEmail());
            existing.setMobileNumber(updateStudent.getMobileNumber());

            saveToFile();

            return true;
        }
        return false;
    }

    public List<Student> searchStudent(String keyword) {
        List<Student> result = new ArrayList<>();

        if ((keyword == null || keyword.trim().isEmpty())) {
            result.addAll(students);
            return result;
        }

        keyword = keyword.toLowerCase();
        for (Student student : students) {
            if (student.getStudentId().toLowerCase().contains(keyword)
                    || student.getFirstName().toLowerCase().contains(keyword)
                    || student.getLastName().toLowerCase().contains(keyword)
                    || student.getCourse().toLowerCase().contains(keyword)) {
                result.add(student);
            }
        }

        return result;
    }

    private void saveToFile() {
        try {
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(FILE_NAME));
            output.writeObject(students);
            output.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    private void loadFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            return;
        }
        try {
            ObjectInputStream input = new ObjectInputStream(new FileInputStream(file));
            students = (ArrayList<Student>) input.readObject();
            input.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // public List<Course> importCSV(String fileName) {
    // List<Course> list = new ArrayList<>();
    // try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
    // String line;
    // br.readLine();
    // while ((line = br.readLine()) != null) {
    // String[] data = line.split(",");
    // Course course = new Course(data[0], data[1], data[2],
    // Double.parseDouble(data[3]));
    // list.add(course);
    // }
    // } catch (Exception e) {
    // e.printStackTrace();
    // }
    // return list;
    // }

    public void exportCSV(List<Student> students, String fileName) {

        if (students == null || students.isEmpty()) {
            System.out.println("No students available to export.");
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {

            writer.write("Student ID,First Name,Last Name,Gender,Course,Mobile,Email,Address");
            writer.newLine();

            for (Student student : students) {
                writer.write(
                        student.getStudentId() + "," +
                                student.getFirstName() + "," +
                                student.getLastName() + "," +
                                student.getGender() + "," +
                                student.getCourse() + "," +
                                student.getMobileNumber() + "," +
                                student.getEmail() + "," +
                                student.getAddress());

                writer.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}