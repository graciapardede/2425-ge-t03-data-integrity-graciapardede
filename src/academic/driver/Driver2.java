package academic.driver;

import academic.model.Course;
import academic.model.Student;
import academic.model.Enrollment;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class Driver2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList<Course> courses = new LinkedList<>();
        LinkedList<Student> students = new LinkedList<>();
        LinkedList<Enrollment> enrollments = new LinkedList<>();
        HashSet<String> courseIds = new HashSet<>();
        LinkedHashSet<String> studentIds = new LinkedHashSet<>();
        HashSet<String> enrollmentIds = new HashSet<>();

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
                if (!courseIds.contains(courseId)) {
                    System.out.println("invalid course|" + courseId);
                } else if (!studentIds.contains(studentId)) {
                    System.out.println("invalid student|" + studentId);
                } else {
                    String enrollmentId = courseId + "#" + studentId + "#" + parts[3] + "#" + parts[4];
                    if (!enrollmentIds.contains(enrollmentId)) {
                        enrollments.add(new Enrollment(courseId, studentId, parts[3], parts[4]));
                        enrollmentIds.add(enrollmentId);
                    }
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

        // Sort enrollments by course ID and then by student ID
        enrollments.sort((e1, e2) -> {
            int courseCompare = e1.getCourseId().compareTo(e2.getCourseId());
            return courseCompare != 0 ? courseCompare : e1.getStudentId().compareTo(e2.getStudentId());
        });

        // Print sorted enrollments
        for (Enrollment enrollment : enrollments) {
            System.out.println(enrollment);
        }

        scanner.close();
    }
}