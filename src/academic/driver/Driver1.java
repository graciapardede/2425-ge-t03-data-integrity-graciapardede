package academic.driver;

import academic.model.Course;
import academic.model.Student;
import academic.model.Enrollment;
import java.util.ArrayList;
import java.util.HashSet; // Use HashSet to prevent duplicates
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Set; // Import Set

public class Driver1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Use Sets to automatically handle duplicates
        Set<Course> courses = new HashSet<>();
        Set<Student> students = new HashSet<>();
        Set<Enrollment> enrollments = new HashSet<>();

        while (scanner.hasNextLine()) { // Check if there's a next line
            String input = scanner.nextLine();
            if (input.equals("---")) {
                break;
            }

            String[] parts = input.split("\\|"); // Split using |

            if (parts.length < 5) continue;

            String command = parts[0];

            if (command.equals("10S1002") && parts.length == 4) { // Course
                Course newCourse = new Course(parts[0], parts[1], Integer.parseInt(parts[2]), parts[3]);
                courses.add(newCourse);
            } else if (command.matches("\\d{8}") && parts.length == 4) { // Student (8 digits)
                Student newStudent = new Student(parts[0], parts[1], Integer.parseInt(parts[2]), parts[3]);
                students.add(newStudent);
            } else if (parts.length == 5) { // Enrollment (no specific command)
                Enrollment newEnrollment = new Enrollment(parts[0], parts[1], parts[2], parts[3]);
                enrollments.add(newEnrollment);
            }
        }

        // Convert Sets to ArrayLists for sorting
        ArrayList<Course> sortedCourses = new ArrayList<>(courses);
        ArrayList<Student> sortedStudents = new ArrayList<>(students);
        ArrayList<Enrollment> sortedEnrollments = new ArrayList<>(enrollments);


        Collections.sort(sortedCourses, Comparator.comparingInt(Course::getCreditHours).thenComparing(Course::getId));
        Collections.sort(sortedStudents, Comparator.comparingInt(Student::getYear).thenComparing(Student::getId));
        Collections.sort(sortedEnrollments, Comparator.comparing(Enrollment::getCourseId).thenComparing(Enrollment::getStudentId));

        for (Course course : sortedCourses) {
            System.out.println(course);
        }
        for (Student student : sortedStudents) {
            System.out.println(student);
        }
        for (Enrollment enrollment : sortedEnrollments) {
            System.out.println(enrollment);
        }

        scanner.close();
    }
}