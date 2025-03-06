package model.person;

import java.time.LocalDate;
import java.util.ArrayList;

import model.Course;
import util.Enums.StudentDegree;

public class Student extends Person {
    private String major;
    private ArrayList<Course> courses;
    private ArrayList<Double> GPAs;
    private int semester;
    private StudentDegree type;
    private String thesisTitle;
    private boolean internshipCompleted = false;
    private boolean TA = false;


    public Student(int id, String fullName, String address, String phone, String email, LocalDate dateOfBirth, String major, StudentDegree type, ArrayList<Course> courses, ArrayList<Double> GPAs, int semester, String thesisTitle, boolean internshipCompleted, boolean TA) {
        super(id, fullName, address, phone, email, dateOfBirth);
        this.major = major;
        this.type = type;
        this.courses = courses;
        this.GPAs = GPAs;
        this.semester = semester;
        this.thesisTitle = thesisTitle;
        this.internshipCompleted = internshipCompleted;
        this.TA = TA;
    }



    public String getMajor() { return major; }
    public ArrayList<Double> getGPAs() { return GPAs; }
    public ArrayList<Course> getCourses() { return courses; }
    public int getSemester() { return semester; }
    public StudentDegree getType() { return type; }
    public String getThesisTitle() { return thesisTitle; }
    public boolean isInternshipCompleted() { return internshipCompleted; }
    public boolean isTA() { return TA; }

    public void setMajor(String major) { this.major = major; }
    public void setGPAs(ArrayList<Double> GPAs) { this.GPAs = (GPAs != null) ? new ArrayList<>(GPAs) : new ArrayList<>(); }
    public void setCourses(ArrayList<Course> courses) { this.courses = (courses != null) ? new ArrayList<>(courses) : new ArrayList<>(); }
    public void setSemester(int semester) { this.semester = semester > 0 ? semester : 1; }
    public void setType(StudentDegree type) { this.type = type; }
    public void setThesisTitle(String thesisTitle) { this.thesisTitle = thesisTitle; }
    public void setInternshipCompleted(boolean internshipCompleted) { this.internshipCompleted = internshipCompleted; }
    public void setTA(boolean TA) { this.TA = TA; }

    public boolean addCourse(Course course) {
        if (course != null) {
            courses.add(course);
            return true;
        }
        return false;
    }

    // Can be moved to StudentService.java


    public double getCGPA() {
        double sum = 0;
        for (double GPA : this.GPAs) { sum += GPA; }
        return sum / this.GPAs.size();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Student{")
          .append("id=").append(getId())
          .append(", fullName='").append(getFullName()).append('\'')
          .append(", dateOfBirth=").append(getDateOfBirth())
          .append(", major='").append(major).append('\'')
          .append(", semester=").append(semester)
          .append(", type='").append(type).append('\'')
          .append(", thesisTitle='").append(thesisTitle != null ? thesisTitle : "N/A").append('\'')
          .append(", internshipCompleted=").append(internshipCompleted ? "Yes" : "No")
          .append(", TA=").append(TA ? "Yes" : "No")
          .append(", courses=").append(courses.size()).append(" courses")
          .append(", GPAs=").append(GPAs.size()).append(" GPAs")
          .append('}');
        return sb.toString();
    }
}