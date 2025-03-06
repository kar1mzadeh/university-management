package model.person;

import java.util.ArrayList;
import model.Course;
import model.Room;
import model.Department;
import model.School;
import util.Enums.FacultyType;
import java.time.LocalDate;

public class Faculty extends Person {
    private School school;
    private Department department;
    private FacultyType position;
    private Room office;
    private LocalDate hireDate;
    private ArrayList<Course> coursesTaught;
    private boolean programDirector = false;
    private boolean dean = false;

    public Faculty(int id, String fullName, String address, String phone, String email, LocalDate dateOfBirth, School school, Department department, FacultyType position, Room office, LocalDate hireDate, boolean availability) {
        super(id, fullName, address, phone, email, dateOfBirth);
        this.school = school;
        this.department = department;
        this.position = position;
        this.office = office;
        this.hireDate = hireDate;
        this.coursesTaught = new ArrayList<>();
    }
    public Faculty(int id, String fullName, String address, String phone, String email, LocalDate dateOfBirth,
                   School school, Department department, FacultyType position, Room office, LocalDate hireDate,
                   ArrayList<Course> coursesTaught, boolean programDirector, boolean dean) {
        super(id, fullName, address, phone, email, dateOfBirth);
        this.school = school;
        this.department = department;
        this.position = position;
        this.office = office;
        this.hireDate = hireDate;
        this.coursesTaught = (coursesTaught != null) ? new ArrayList<>(coursesTaught) : new ArrayList<>();
        this.programDirector = programDirector;
        this.dean = dean;
    }

    public Faculty(int id, String fullName, LocalDate dateOfBirth) {
        super(id, fullName, dateOfBirth);
    }


    public School getSchool() { return school; }
    public Department getDepartment() { return department; }
    public FacultyType getPosition() { return position; }
    public Room getOfficeLocation() { return office; }
    public LocalDate getHireDate() { return hireDate; }
    public ArrayList<Course> getCoursesTaught() { return coursesTaught; }

    public void setSchool(School school) { this.school = school; }
    public void setDepartment(Department department) { this.department = department; }
    public void setPosition(FacultyType position) { this.position = position; }
    public void setOfficeLocation(Room office) { this.office = office; }
    public void setHireDate(LocalDate hireDate) { this.hireDate = hireDate; }
    public void setProgramDirector(boolean programDirector) { this.programDirector = programDirector; }
    public void setDean(boolean dean) { this.dean = dean; }

    public boolean isProgramDirector() { return programDirector; }
    public boolean isDean() { return dean; }
    public boolean isProfessor() {
        return position == FacultyType.PROFESSOR_IN_PRACTICE || 
               position == FacultyType.FULL_PROFESSOR || 
               position == FacultyType.ASSOCIATE_PROFESSOR || 
               position == FacultyType.ASSISTANT_PROFESSOR;
    }

    public void assignCourse(Course course) {
        if (course == null) {
            System.out.println("Invalid course. Cannot assign null.");
            return;
        }
        if (!coursesTaught.contains(course)) {
            coursesTaught.add(course);
            System.out.println("\"" + course.getTitle() + "\" has been assigned to " + this.getFullName());
        } else {
            System.out.println(this.getFullName() + " is already assigned to \"" + course.getTitle() + "\"");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString())
          .append("\nSchool: ").append(school)
          .append("\nDepartment: ").append(department)
          .append("\nPosition: ").append(position)
          .append("\nOffice: ").append(office)
          .append("\nHire Date: ").append(hireDate)
          .append("\nCourses Taught: ");
        if (coursesTaught.isEmpty()) {
            sb.append("None");
        } else {
            for (Course course : coursesTaught) {
                sb.append("\n - ").append(course.getTitle());
            }
        }
        return sb.toString();
    }
}
