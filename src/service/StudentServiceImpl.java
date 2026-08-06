package service;

import model.Student;
import repository.StudentRepository;
import repository.StudentRepositoryImpl;

import java.util.ArrayList;
import java.util.List;

public class StudentServiceImpl
        implements StudentService {

    private final StudentRepository repository = new StudentRepositoryImpl();
    private final ArrayList<Student> students;

    public StudentServiceImpl() {
        students = repository.loadStudents();
    }

    @Override
    public boolean addStudent(Student student) {
        if (searchStudent(student.getRollNo()) != null) {
            return false;
        }
        students.add(student);
        repository.saveStudents(students);
        return true;
    }

    @Override
    public List<Student> getAllStudents() {
        return students;
    }

    @Override
    public Student searchStudent(int rollNo) {
        for (Student student : students) {
            if (student.getRollNo() == rollNo) {
                return student;
            }
        }
        return null;
    }

    @Override
    public boolean updateStudent(Student updatedStudent) {
        Student existing = searchStudent(updatedStudent.getRollNo());
        if (existing == null) {
            return false;
        }
        existing.setName(updatedStudent.getName());
        existing.setCourse(updatedStudent.getCourse());
        existing.setMarks(updatedStudent.getMarks());
        existing.setMobile(updatedStudent.getMobile());
        existing.setEmail(updatedStudent.getEmail());
        repository.saveStudents(students);
        return true;
    }

    @Override
    public boolean deleteStudent(int rollNo) {
        Student student = searchStudent(rollNo);
        if (student == null) {
            return false;
        }

        students.remove(student);
        repository.saveStudents(students);
        return true;
    }

}