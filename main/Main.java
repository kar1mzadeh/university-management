package main;

import model.Course;
import model.person.Faculty;
import model.person.Person;
import model.person.Student;
import service.StudentService;
import util.Enums;

import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        StudentService service= new StudentService();

        Student student1 = new Student(1, "Alice Johnson", "123 Main St", "1234567890", "alice@example.com", LocalDate.of(2000, 5, 15), "Computer Science", Enums.StudentDegree.BACHELORS, new ArrayList<>(), new ArrayList<>(), 5, "AI Research", false, false);
        Student student2 = new Student(2, "Bob Smith", "456 Elm St", "9876543210", "bob@example.com", LocalDate.of(1999, 8, 20), "Software Engineering", Enums.StudentDegree.BACHELORS, new ArrayList<>(), new ArrayList<>(), 6, "Cloud Computing", true, true);


        // Create initial course list
        ArrayList<Course> courses = new ArrayList<>();
        Course course1 = new Course("Data Structures", "Study of data structures", 101, 3, 12345, 'C', new ArrayList<>(), new ArrayList<>(), null);
        Course course2 = new Course("Algorithms", "Study of algorithms", 102, 4, 67890, 'B', new ArrayList<>(), new ArrayList<>(), null);
    service.addStudent(student1);
    service.addStudent(student2);
    service.getStudents();
    }

}
