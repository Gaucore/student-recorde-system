package service;

import model.Student;

import java.util.List;

public interface StudentService {
    boolean addStudent(Student student);

    List<Student> getAllStudents();

    Student searchStudent(int rollNo);

    boolean updateStudent(Student student);

    boolean deleteStudent(int rollNo);
}