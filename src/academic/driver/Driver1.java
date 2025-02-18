package academic.driver;

/**
 * @autor 12S23004 Fernando Alexander Silitonga
 * @autor 12S23044 Gracia Pardede
 */

import academic.model.Course;
import academic.model.Student;
import academic.model.Enrollment;
import java.util.ArrayList;
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
                boolean exists = false;
                for (Course course : courses) {
                    if (course.equals(newCourse)) {
                        exists = true;
                        break;
                    }
                }
                if (!exists) {
                    courses.add(newCourse);
                }
            } 
            else if (command.equals("student-add") && parts.length == 5) {
                Student newStudent = new Student(parts[1], parts[2], Integer.parseInt(parts[3]), parts[4]);
                boolean exists = false;
                for (Student student : students) {
                    if (student.equals(newStudent)) {
                        exists = true;
                        break;
                    }
                }
                if (!exists) {
                    students.add(newStudent);
                }
            } 
            else if (command.equals("enrollment-add") && parts.length == 5) {
                Enrollment newEnrollment = new Enrollment(parts[1], parts[2], parts[3], parts[4]);
                boolean exists = false;
                for (Enrollment enrollment : enrollments) {
                    if (enrollment.equals(newEnrollment)) {
                        exists = true;
                        break;
                    }
                }
                if (!exists) {
                    enrollments.add(newEnrollment);
                }
            }
        }

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
