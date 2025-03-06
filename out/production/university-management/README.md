# university-management
Java application by CSCI 1202 Spring 2025 students of ADA University

## Class Diagram for `model.person` Package

The following class diagram represents the structure of the classes in the `model.person` package:

```mermaid
classDiagram
    class Person {
        +int id
        +String fullName
        +String address
        +String phone
        +String email
        +LocalDate dateOfBirth
        +int getAge()
        +boolean equals(Object o)
        +String toString()
    }

    class Faculty {
        +School school
        +Department department
        +FacultyType position
        +Room office
        +LocalDate hireDate
        +ArrayList~Course~ coursesTaught
        +boolean programDirector
        +boolean dean
        +boolean isProfessor()
        +void assignCourse(Course course)
        +String toString()
    }

    class Staff {
        +double salary
        +String status
        +String position
        +String department
        +Room office
        +String toString()
    }

    class Student {
        +String major
        +ArrayList~Course~ courses
        +ArrayList~Double~ GPAs
        +int semester
        +StudentDegree type
        +String thesisTitle
        +boolean internshipCompleted
        +boolean TA
        +boolean addCourse(Course course)
        +boolean withdrawFromCourse(int courseId)
        +double getCGPA()
        +String toString()
    }

    class TeachingAssistant {
        +Student student
        +ArrayList~Course~ coursesAssisted
        +Faculty supervisor
        +String evaluation
        +boolean addAssistedCourse(Course course)
        +boolean withdrawFromAssistedCourse(int courseId)
        +String toString()
    }

    Person <|-- Faculty
    Person <|-- Staff
    Person <|-- Student
    Student "1" o-- "*" Course : enrolls in
    Faculty "1" o-- "*" Course : teaches
    TeachingAssistant "1" o-- "1" Student : is
    TeachingAssistant "1" o-- "1" Faculty : supervised by
    TeachingAssistant "1" o-- "*" Course : assists in
