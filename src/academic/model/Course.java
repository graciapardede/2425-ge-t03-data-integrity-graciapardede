package academic.model;

import java.util.Objects;

public class Course {
    private String id;
    private String name;
    private int credits;
    private String grade;

    // Constructor, getters, and setters

    public Course(String id, String name, int credits, String grade) {
        this.id = id;
        this.name = name;
        this.credits = credits;
        this.grade = grade;
        
    }

    public String getId() {
        return id;
    }

    public int getCreditHours() {
        return credits;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Course course = (Course) obj;
        return id.equals(course.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    
    @Override
    public String toString() {
        return id + "|" + name + "|" + credits + "|" + grade;
    }
}