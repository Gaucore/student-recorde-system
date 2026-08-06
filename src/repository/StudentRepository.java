// package repository;

// import java.io.File;
// import java.io.FileInputStream;
// import java.io.FileOutputStream;
// import java.io.IOException;
// import java.io.ObjectInputStream;
// import java.io.ObjectOutputStream;
// import java.util.ArrayList;

// import model.Student;

// public class StudentRepository {

//     void saveStudent(ArrayList<Student> students);

//     ArrayList<Student> loadStudents();
//     // private static final String FILE_NAME = "student.ser";

//     // public void saveStudents(ArrayList<Student> students) {
//     // try (ObjectOutputStream out = new ObjectOutputStream(new
//     // FileOutputStream(FILE_NAME))) {
//     // out.writeObject(students);

//     // } catch (IOException e) {
//     // e.printStackTrace();
//     // }
//     // }

//     // @SuppressWarnings("unchecked")
//     // public ArrayList<Student> loadStudents() {
//     // File file = new File(FILE_NAME);
//     // if (!file.exists()) {
//     // return new ArrayList<>();
//     // }
//     // try (ObjectInputStream in = new ObjectInputStream(new
//     // FileInputStream(FILE_NAME))) {
//     // return (ArrayList<Student>) in.readObject();
//     // } catch (Exception e) {
//     // e.printStackTrace();
//     // }
//     // return new ArrayList<>();
//     // }

// }

package repository;

import model.Student;

import java.util.ArrayList;

public interface StudentRepository {

    void saveStudents(ArrayList<Student> students);

    ArrayList<Student> loadStudents();

}