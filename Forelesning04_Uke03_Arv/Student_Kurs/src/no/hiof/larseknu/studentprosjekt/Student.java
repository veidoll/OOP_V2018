package no.hiof.larseknu.studentprosjekt;

import java.util.ArrayList;

public class Student {
    private String fornavn;
    private String etternavn;
    private String studentId;
    private Kurs kurs;

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

    public Student(String fornavn, String etternavn, String studentId, Kurs kurs) {
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.studentId = studentId;
        this.kurs = kurs;
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

    public Kurs getKurs() {
        return kurs;
    }

    public void setKurs(Kurs kurs) {
        this.kurs = kurs;
    }
}
