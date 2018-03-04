package no.hiof.larseknu.csvskriver;

import no.hiof.larseknu.csvskriver.model.Superhelt;

import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Superhelt> superheltArrayList = new ArrayList<>();

        superheltArrayList.add(new Superhelt("Superman", "Clark Kent"));
        superheltArrayList.add(new Superhelt("Hulk", "Bruce Banner"));
        superheltArrayList.add(new Superhelt("Batman", "Bruce Wayne"));

        File kilde = new File("superheltregister.csv");

        try (BufferedWriter bufretSkriver = new BufferedWriter(new FileWriter(kilde))) {
            // Går igjennom alle superhelter i superheltlisten
            for(Superhelt enSuperhelt: superheltArrayList) {
                // Skriver fornavn og alterego til filen avskilt med ";"
                bufretSkriver.write( enSuperhelt.getNavn() + ";" + enSuperhelt.getAlterEgo() );
                // Skriver et linjeskift
                bufretSkriver.newLine();
            }
        } catch (FileNotFoundException e) {
            // Skriver ut feilmelding om filen ikke finnes
            System.out.println(e);
        } catch (IOException e) {
            // skriver ut feilmelding om det oppstår feil ved skriving til fil
            System.out.println(e);
        }
    }
}
