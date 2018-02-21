package no.hiof.larseknu.studentprosjekt;

import java.util.ArrayList;

public class Student extends Person{
    private String studentId;
    private int alder;
    private ArrayList<Kurs> kurs = new ArrayList<>();
    private static final int MINIMUMSALDER = 18;
    public static final String INSTITUSJON = "Høgskolen i Østfold";

    public Student() {
        this("John", "Doe", 20);
    }

    public Student(String fornavn, String etternavn, int alder) {
        this(fornavn, etternavn, "000000", alder);
    }

    public Student(String fornavn, String etternavn, String studentId) {
        this(fornavn, etternavn, studentId, 20);
    }

    public Student(String fornavn, String etternavn, String studentId, int alder) {
        super(fornavn, etternavn);
        this.studentId = studentId;
        this.alder = alder;

        if (alder < MINIMUMSALDER)
            System.out.println(fornavn + " " + etternavn + " er for ung til å begynne som student.");
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
