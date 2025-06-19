package org.example;
/**
 * Student class
 * Represents a student with a name and list of enrolled courses.
 */
import java.util.List;


/**
 * A Student has a name and a list of enrolled courses.
 */
public class Student {
    private final String name;
    private final List<Course> courses;

    /**
     * Constructs a student with a name and list of courses.
     *
     * @param name    the student name
     * @param courses the list of courses the student is enrolled in
     */
    public Student(String name, List<Course> courses) {
        this.name = name;
        this.courses = courses;
    }

    public String getName() {
        return name;
    }

    public List<Course> getCourses() {
        return courses;
    }
}
