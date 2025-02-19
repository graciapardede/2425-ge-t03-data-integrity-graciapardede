package academic.driver;

/**
 * @autor 12S23004 Fernando Alexander Silitonga
 * @autor 12S23044 Gracia Pardede
 */

import academic.model.Course;
import academic.model.Student;
import academic.model.Enrollment;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class Driver1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList<Course> courses = new LinkedList<>();
        LinkedList<Student> students = new LinkedList<>();
        LinkedList<Enrollment> enrollments = new LinkedList<>();
        LinkedHashSet<String> courseIds = new LinkedHashSet<>();
        LinkedHashSet<String> studentIds = new LinkedHashSet<>();
        LinkedHashSet<String> enrollmentIds = new LinkedHashSet<>();

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("---")) {
                break;
            }

            String[] parts = input.split("#");
            if (parts.length < 5) continue;

            String command = parts[0];

            if (command.equals("course-add") && parts.length == 5) {
                if (!courseIds.contains(parts[1])) {
                    courses.add(new Course(parts[1], parts[2], Integer.parseInt(parts[3]), parts[4]));
                    courseIds.add(parts[1]);
                }
            } 
            else if (command.equals("student-add") && parts.length == 5) {
                if (!studentIds.contains(parts[1])) {
                    students.add(new Student(parts[1], parts[2], Integer.parseInt(parts[3]), parts[4]));
                    studentIds.add(parts[1]);
                }
            } 
            else if (command.equals("enrollment-add") && parts.length == 5) {
                String courseId = parts[1];
                String studentId = parts[2];
                String enrollmentId = courseId + "#" + studentId + "#" + parts[3] + "#" + parts[4];
                if (!enrollmentIds.contains(enrollmentId)) {
                    enrollments.add(new Enrollment(courseId, studentId, parts[3], parts[4]));
                    enrollmentIds.add(enrollmentId);
                }
            }
        }

        // Reverse the order of courses
        Collections.reverse(courses);

        // Print reversed courses
        for (Course course : courses) {
            System.out.println(course);
        }

        // Print students in the order they were added
        for (Student student : students) {
            System.out.println(student);
        }

        // Print enrollments in the order they were added
        for (Enrollment enrollment : enrollments) {
            System.out.println(enrollment);
        }

        scanner.close();
    }
}
