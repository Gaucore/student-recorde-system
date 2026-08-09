package test;

import controller.StudentController;
import model.Student;

public class StudentControllerTest {

    public static void main(String[] args) {

        StudentController controller = new StudentController();

        Student student = new Student();

        student.setStudentId("ST001");
        student.setFirstName("Gautam");
        student.setLastName("Gaud");
        student.setGender("Male");
        student.setCourse("B.Sc IT");

        boolean result = controller.addStudent(student);

        System.out.println(
                "Student Added: " + result);

        System.out.println(
                controller.getAllStudents());
    }
}