
public class Student {
    // "medlemsvariabler" (fields)
    public String fornavn;
    public String etternavn;
    public int alder;
    public String studentId;

    // Instansmetode som printer informasjon om data i klassen selv
    public void printStudentInformasjon() {
        System.out.println(fornavn + " " + etternavn);
    }
}
