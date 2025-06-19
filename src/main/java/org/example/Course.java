package org.example;

/**
 * Course class:
 * Represents a course with a list of study topics.
 */
import java.util.List;

/**
 * A Course contains a name and a list of topics it covers.
 */
public class Course {
    private final String name;
    private final List<String> topics;

    /**
     * Constructs a course with a name and list of topics.
     *
     * @param name   the course name
     * @param topics the list of topics the course covers
     */
    public Course(String name, List<String> topics) {
        this.name = name;
        this.topics = topics;
    }

    public String getName() {
        return name;
    }

    public List<String> getTopics() {
        return topics;
    }

}
