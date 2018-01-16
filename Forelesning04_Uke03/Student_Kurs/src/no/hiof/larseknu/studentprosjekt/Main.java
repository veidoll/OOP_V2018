package no.hiof.larseknu.studentprosjekt;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
    	// Oppretter et studentobjekt med navn albertEinstein
	    Student albertEinstein = new Student("Albert", "Einstein", "454545");

	    // Oppretter to kursobjekter
	    Kurs androidProgrammering = new Kurs("Android-Programmering", "ITF1337", 10);
	    Kurs kvanteFysikk = new Kurs("Kvantefysikk", "ITF9999", 20);

	    // Legger kursene vi har laget til studentobjektet albertEinstein
	    albertEinstein.leggTilKurs(androidProgrammering);
	    albertEinstein.leggTilKurs(kvanteFysikk);

	    // Henter ut albert sine kurs
		ArrayList<Kurs> einsteinsKurs = albertEinstein.getKurs();

		// Ser om han har noen kurs, eller om listen er tom
	    if (einsteinsKurs.size() == 0) {
			System.out.println("Einstein tar ingen kurs");
		}
	    else {
			System.out.println("Einstein tar kursene: ");

			// Går gjennom listen med kurs og skriver ut navnet
			for (int i = 0; i < einsteinsKurs.size(); i++) {
				System.out.println(einsteinsKurs.get(i).getNavn());
			}
		}


		System.out.println("############");

		System.out.println("Bruker Student sin toString():\n" + albertEinstein.toString());
    }
}
