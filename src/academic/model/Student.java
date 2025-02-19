package academic.model;

/**
 * @autor 12S23004 Fernando Alexander Silitonga
 * @autor 12S23044 Gracia Pardede
 */

import java.util.Objects;

public class Student {
    private String id;
    private String name;
    private int year;
    private String major;
    

    // Constructor, getters, and setters

    public Student(String id, String name, int year, String major) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.major = major;
    }

    public String getId() {
        return id;
    }

    public int getYear() {
        return year;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Student student = (Student) obj;
        return id.equals(student.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return id + "|" + name + "|" + year + "|" + major;
    }
}