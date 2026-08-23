package controller;

import java.util.List;

import exception.ValidationException;
import model.Student;
import service.StudentService;

public class StudentController {

    private final StudentService studentService;

    public StudentController() {
        studentService = new StudentService();
    }

    public boolean addStudent(Student student) throws ValidationException {
        return studentService.addStudent(student);
    }

    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    public Student findStudent(String studentId) {
        return studentService.findStudent(studentId);
    }

    public boolean updateStudent(Student student) throws ValidationException {
        return studentService.updateStudent(student);
    }

    public boolean deleteStudent(String studentId) {
        return studentService.deleteStudent(studentId);
    }

    public List<Student> searchStudents(String keyword) {
        return studentService.searchStudents(keyword);
    }

    public void exportStudent(String fileName) {
        studentService.exportStudent(fileName);
    }

    public int getStudentCount() {
        return studentService.getStudentCount();
    }

}
