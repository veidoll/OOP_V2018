package no.hiof.larseknu.studentprosjekt;

import java.util.ArrayList;

public class Student extends Person{
    private String studentId;
    private ArrayList<Kurs> kurs = new ArrayList<>();

    public Student() {
        this("John", "Doe");
    }

    public Student(String fornavn, String etternavn) {
        this(fornavn, etternavn, "000000");
    }

    public Student(String fornavn, String etternavn, String studentId) {
        super(fornavn, etternavn);
        this.studentId = studentId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public ArrayList<Kurs> getKurs() {
        return kurs;
    }

    public void leggTilKurs(Kurs kurs) {
        this.kurs.add(kurs);
    }

    @Override
    public String toString() {
        return studentId + " - " + super.toString();
    }
}
