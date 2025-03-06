package service;

import model.Course;
import model.person.Student;
import util.Enums;

import java.time.LocalDate;
import java.util.ArrayList;

public class StudentService {

    ArrayList<Student> students;
    ArrayList<Course >courses;
    public void addStudent(Student student)
    {
        if(student != null)
        {
            students.add(student);
        }
        else System.out.println("The student is  null");
    }
    public void updateStudent(int id, Student newStudentData) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                Student existingStudent = students.get(i);

                existingStudent.setAddress(newStudentData.getAddress());
                existingStudent.setPhone(newStudentData.getPhone());
                existingStudent.setEmail(newStudentData.getEmail());
                existingStudent.setMajor(newStudentData.getMajor());
                existingStudent.setSemester(newStudentData.getSemester());
                existingStudent.setCourses(newStudentData.getCourses());
                existingStudent.setGPAs(newStudentData.getGPAs());
                existingStudent.setThesisTitle(newStudentData.getThesisTitle());
                existingStudent.setInternshipCompleted(newStudentData.isInternshipCompleted());
                existingStudent.setTA(newStudentData.isTA());
                existingStudent.setType(newStudentData.getType());

                System.out.println("Student with ID " + id + " has been updated.");
                return;
            }
        }
        System.out.println("Student with ID " + id + " not found.");
    }

    public void deleteStudent(int id){
        if(students.get(id) !=null)
        {
            students.remove(id);
        }
        else System.out.println("There is no student with such Id ");
    }

    public boolean withdrawFromCourse(int courseId) {
        return courses.removeIf(course -> course.getCourseCode() == courseId);
    }
    public boolean addCourse(Course course)
    {
        if(course != null && courses.containsAll(course.getPrerequisites()))
        {
            courses.add(course);
            return true;
        }
        System.out.println("It has a prerequisites or it is null");
        return false;
    }
    public void deleteCourse(int id)
    {
        if(courses.get(id) !=null)
        {
            courses.remove(id);
        }
        else System.out.println("There is no course with such Id ");
    }
    public void updateCourse(int courseCode, Course newCourseData) {
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getCourseCode() == courseCode) {
                Course existingCourse = courses.get(i);

                // Update fields from newCourseData
                existingCourse.setTitle(newCourseData.getTitle());
                existingCourse.setDescription(newCourseData.getDescription());
                existingCourse.setCredits(newCourseData.getCredits());
                existingCourse.setCRN(newCourseData.getCRN());
                existingCourse.setPassingGrade(newCourseData.getPassingGrade());
                existingCourse.setPrerequisiteCourses(newCourseData.getPrerequisites());
                existingCourse.setStudents(newCourseData.getStudents());
                existingCourse.setTeacher(newCourseData.getTeacher());

                System.out.println("Course with code " + courseCode + " has been updated.");
                return;
            }
        }
        System.out.println("Course with code " + courseCode + " not found.");
    }
    public void getStudents()
    {
        System.out.println(students);
    }

}
