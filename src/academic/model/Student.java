package academic.model;

/**
 * @autor 12S23004 Fernando Alexander Silitonga
 * @autor 12S23044 Gracia Pardede
 */

public class Student {
    private String id;
    private String name;
    private int tahun;
    private String prodi;

    public Student(String id, String name, int tahun, String prodi) {
        this.id= id;
        this.name = name;
        this.tahun = tahun;
        this.prodi = prodi; 
    }
 
    @Override   
    public String toString() {
        return id + "|" + name + "|" + tahun + "|" + prodi;
    }
} 
