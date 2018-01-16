package no.hiof.larseknu.studentprosjekt;

import java.util.ArrayList;

public class Student {
    private String fornavn;
    private String etternavn;
    private String studentId;
    private ArrayList<Kurs> kurs = new ArrayList<>();

    public Student() {
    }

    public Student(String fornavn, String etternavn) {
        this.fornavn = fornavn;
        this.etternavn = etternavn;
    }

    public Student(String fornavn, String etternavn, String studentId) {
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.studentId = studentId;
    }

    public String getFornavn() {
        return fornavn;
    }

    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }

    public String getEtternavn() {
        return etternavn;
    }

    public void setEtternavn(String etternavn) {
        this.etternavn = etternavn;
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
        return super.toString() + " " + fornavn + " " + etternavn;
    }
}
