package no.hiof.larseknu.studentprosjekt;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

	    // Oppretter to kursobjekter
	    Kurs androidProgrammering = new Kurs("Android-Programmering", "ITF1337", 10);
	    Kurs kvanteFysikk = new Kurs("Kvantefysikk", "ITF9999", 20);


	    // Skriver ut litt kursinformasjon
		System.out.println(androidProgrammering.getNavn() + " har " + androidProgrammering.getStudiePoeng() + " studiepoeng.");

		System.out.println(kvanteFysikk.getNavn() + " har emnekode: " + kvanteFysikk.getKode());


    }
}
