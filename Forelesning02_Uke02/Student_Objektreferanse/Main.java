public class Main {

    public static void main(String[] args) {
        // Oppretter og instansierer ett objekt (nikolaTesla) av klassen Student
        Student nikolaTesla = new Student();

        // Setter verdier på objektets "medlemsvariabler" (felter)
        nikolaTesla.fornavn = "Nikola";
        nikolaTesla.etternavn = "Tesla";
        nikolaTesla.studentId = "963318";

        // Bruker instansmetoden printStudentInformasjon på studentobjektet nikolaTesla
        nikolaTesla.printStudentInformasjon();
    }

}
