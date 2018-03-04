package no.hiof.larseknu.csvleser;

import no.hiof.larseknu.csvleser.model.Superhelt;

import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Superhelt> superheltArrayList = new ArrayList<>();

        // Lager et File-objekt
        File kilde = new File("superheltregister.csv");

        try (BufferedReader bufretLeser = new BufferedReader(new FileReader(kilde))) {
            // Lager variabel å holde på hver tekstlinje
            String linje;

            // Løkken går så lenge det finnes linjer
            while( (linje = bufretLeser.readLine()) != null ){
                // Deler opp teksten på tegnet ";" -> dette resulterer i an array som heter deler
                // index 0 -> fornavn
                // index 1 -> etternavn
                String[] deler = linje.split(";");

                // Lager nytt kundeobjekt med denne informasjonen
                Superhelt k = new Superhelt(deler[0], deler[1]);

                // Legger til denne superhelten i listen
                superheltArrayList.add(k);
            }

            // Skriver ut listen med superhelter til konsoll
            System.out.println(superheltArrayList);
        } catch (FileNotFoundException e) {
            // Skriver ut feilmelding om filen ikke finnes
            System.out.println(e);
        } catch (IOException e) {
            // skriver ut feilmelding om det oppstår feil ved skriving til fil
            System.out.println(e);
        }
    }
}
