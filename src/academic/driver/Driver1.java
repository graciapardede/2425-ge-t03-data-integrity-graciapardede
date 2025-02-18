package academic.driver;

import academic.model.Course;
import academic.model.Student;
import academic.model.Enrollment;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Driver1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Course> courses = new ArrayList<>();
        ArrayList<Student> students = new ArrayList<>();
        ArrayList<Enrollment> enrollments = new ArrayList<>();
        HashSet<String> courseIds = new HashSet<>();
        HashSet<String> studentIds = new HashSet<>();
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
                String enrollmentId = parts[1] + "#" + parts[2] + "#" + parts[3] + "#" + parts[4];
                if (!enrollmentIds.contains(enrollmentId)) {
                    enrollments.add(new Enrollment(parts[1], parts[2], parts[3], parts[4]));
                    enrollmentIds.add(enrollmentId);
                }
            }
        }

        courses.sort((c1, c2) -> {
            int creditCompare = Integer.compare(c1.getCreditHours(), c2.getCreditHours());
            return creditCompare != 0 ? creditCompare : c1.getId().compareTo(c2.getId());
        });
        students.sort((s1, s2) -> {
            int yearCompare = Integer.compare(s1.getYear(), s2.getYear());
            return yearCompare != 0 ? yearCompare : s1.getId().compareTo(s2.getId());
        });
        enrollments.sort((e1, e2) -> {
            int courseCompare = e1.getCourseId().compareTo(e2.getCourseId());
            return courseCompare != 0 ? courseCompare : e1.getStudentId().compareTo(e2.getStudentId());
        });

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