package service;

import model.Student;
import repository.StudentRepository;

import java.util.List;
import exception.ValidationException;
import constant.AppConstants;

public class StudentService {

    private final StudentRepository repository;

    public StudentService() {
        repository = new StudentRepository();
    }

    private void validateStudent(Student student) throws ValidationException {

        if (student == null) {
            throw new ValidationException("Student cannot be null.");
        }

        if (student.getStudentId() == null
                || student.getStudentId().trim().isEmpty()) {
            throw new ValidationException("Student ID is required.");
        }

        if (student.getFirstName() == null
                || student.getFirstName().trim().isEmpty()) {
            throw new ValidationException("First Name is required.");
        }

        if (student.getLastName() == null
                || student.getLastName().trim().isEmpty()) {
            throw new ValidationException("Last Name is required.");
        }

        if (student.getEmail() == null
                || student.getEmail().trim().isEmpty()) {
            throw new ValidationException("Email is required.");
        }

        if (student.getMobileNumber() == null
                || student.getMobileNumber().trim().isEmpty()) {
            throw new ValidationException("Mobile Number is required.");
        }

        if (AppConstants.SELECT_GENDER.equals(student.getGender())) {
            throw new ValidationException("Please select Gender.");
        }

        if (AppConstants.SELECT_COURSE.equals(student.getCourse())) {
            throw new ValidationException("Please select Course.");
        }
    }

    public boolean addStudent(Student student) throws ValidationException {

        validateForAdd(student);

        if (repository.findById(student.getStudentId()) != null) {
            throw new ValidationException("Student ID already exists");
        }

        if (repository.findByEmail(student.getEmail()) != null) {
            throw new ValidationException("Email already exists.");
        }

        if (repository.findByMobile(student.getMobileNumber()) != null) {
            throw new ValidationException("Mobile no. already exists");
        }

        repository.addStudent(student);

        return true;
    }

    public List<Student> getAllStudents() {
        return repository.getAllStudents();
    }

    public boolean updateStudent(Student student) throws ValidationException {
        validateForUpdate(student);
        return repository.updateStudent(student);
    }

    public boolean deleteStudent(String studentId) {
        return repository.deleteStudent(studentId);
    }

    public Student findStudent(String studentId) {
        return repository.findById(studentId);
    }

    public List<Student> searchStudents(String keyword) {
        return repository.searchStudent(keyword);
    }

    private void validateForAdd(Student student) throws ValidationException {
        validateStudent(student);
    }

    private void validateForUpdate(Student student) throws ValidationException {
        validateStudent(student);
    }

}