package no.hiof.larseknu.studentprosjekt;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
    	// Oppretter et studentobjekt med navn albertEinstein
	    Student albertEinstein = new Student("Albert", "Einstein", "454545");

	    // Oppretter to kursobjekter
	    Kurs androidProgrammering = new Kurs("Android-Programmering", "ITF1337", 10);

	    // Legger kursene vi har laget til studentobjektet albertEinstein
	    albertEinstein.setKurs(androidProgrammering);

	    // Henter ut albert sitt kurs
		Kurs einsteinsKurs = albertEinstein.getKurs();

		// Skriver ut kurset albert tar
	    System.out.println(albertEinstein.getFornavn() + " " + albertEinstein.getEtternavn()
		+ " tar kurset " + albertEinstein.getKurs().getNavn());
    }
}
