package academic.model;

import java.util.Objects;

public class Enrollment {
    private String courseId;
    private String studentId;
    private String academicYear;
    private String semester;

    // Constructor, getters, and setters

    public Enrollment(String courseId, String studentId, String academicYear, String semester) {
        this.courseId = courseId;
        this.studentId = studentId;
        this.academicYear = academicYear;
        this.semester = semester;
    }

    public String getCourseId() {
        return courseId;
    }

    public String getStudentId() {
        return studentId;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Enrollment enrollment = (Enrollment) obj;
        return courseId.equals(enrollment.courseId) && studentId.equals(enrollment.studentId) &&
               academicYear.equals(enrollment.academicYear) && semester.equals(enrollment.semester);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseId, studentId, academicYear, semester);
    }

    @Override
    public String toString() {
        return courseId + "|" + studentId + "|" + academicYear + "|" + semester + "|None";
    }
}