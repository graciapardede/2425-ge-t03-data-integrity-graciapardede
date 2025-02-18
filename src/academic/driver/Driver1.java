package academic.driver;

import academic.model.Course;
import academic.model.Student;
import academic.model.Enrollment;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Driver1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Course> courses = new ArrayList<>();
        ArrayList<Student> students = new ArrayList<>();
        ArrayList<Enrollment> enrollments = new ArrayList<>();

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("---")) {
                break;
            }

            String[] parts = input.split("#");
            if (parts.length < 5) continue;

            String command = parts[0];

            if (command.equals("course-add") && parts.length == 5) {
                Course newCourse = new Course(parts[1], parts[2], Integer.parseInt(parts[3]), parts[4]);
                if (!courses.contains(newCourse)) {
                    courses.add(newCourse);
                }
            } 
            else if (command.equals("student-add") && parts.length == 5) {
                Student newStudent = new Student(parts[1], parts[2], Integer.parseInt(parts[3]), parts[4]);
                if (!students.contains(newStudent)) {
                    students.add(newStudent);
                }
            } 
            else if (command.equals("enrollment-add") && parts.length == 5) {
                Enrollment newEnrollment = new Enrollment(parts[1], parts[2], parts[3], parts[4]);
                if (!enrollments.contains(newEnrollment)) {
                    enrollments.add(newEnrollment);
                }
            }
        }

        // Sort courses by credit hours first, then alphabetically by ID
        Collections.sort(courses, Comparator.comparingInt(Course::getCreditHours).thenComparing(Course::getId));
        // Sort students by year first, then alphabetically by ID
        Collections.sort(students, Comparator.comparingInt(Student::getYear).thenComparing(Student::getId));
        // Sort enrollments by course ID and then by student ID
        Collections.sort(enrollments, Comparator.comparing(Enrollment::getCourseId).thenComparing(Enrollment::getStudentId));

        for (Course course : courses) {
            System.out.println(course);
        }
        for (Student student : students) {
            System.out.println(student);
        }
        for (Enrollment enrollment : enrollments) {
            System.out.println(enrollment);
        }

        scanner.close();
    }
}