package org.example;
/**
 * StudentTopicCliDemo class
 * Console app that reads students and their courses,
 * flattens the course topics using flatMap, and summarizes them.
 */
import java.util.*;
import java.util.stream.Collectors;

/**
 * Demonstrates how to use flatMap and a custom Collector
 * to aggregate and summarize course topics per student.
 */
public class StudentTopicCliDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Student> students = new ArrayList<>();

        System.out.print("Enter number of students: ");
        int studentCount = Integer.parseInt(scanner.nextLine());

        // Step 1: Input student and course data
        for (int i = 0; i < studentCount; i++) {
            System.out.println("\n--- Student " + (i + 1) + " ---");
            System.out.print("Name: ");
            String studentName = scanner.nextLine();

            List<Course> courses = new ArrayList<>();
            System.out.print("Number of courses: ");
            int courseCount = Integer.parseInt(scanner.nextLine());

            for (int j = 0; j < courseCount; j++) {
                System.out.println("Course " + (j + 1) + " name: ");
                String courseName = scanner.nextLine();

                System.out.print("Number of topics in " + courseName + ": ");
                int topicCount = Integer.parseInt(scanner.nextLine());

                List<String> topics = new ArrayList<>();
                for (int k = 0; k < topicCount; k++) {
                    System.out.print("Topic " + (k + 1) + ": ");
                    topics.add(scanner.nextLine());
                }

                courses.add(new Course(courseName, topics));
            }

            students.add(new Student(studentName, courses));
        }

        // Step 2: Initialize the custom collector
        TopicSummaryCollector topicCollector = new TopicSummaryCollector();

        // Step 3: For each student, use flatMap to flatten nested topic lists
        // and apply the custom collector to produce a formatted topic summary
        System.out.println("\n===== Topics per Student =====");
        for (Student student : students) {
            String topicSummary = student.getCourses().stream()
                    // flatMap flattens List<Course> → Stream<String> of topics
                    .flatMap(course -> course.getTopics().stream())
                    .collect(topicCollector); // Use custom collector to format output

            System.out.println(student.getName() + ": " + topicSummary);
        }

        scanner.close();

    }
}
