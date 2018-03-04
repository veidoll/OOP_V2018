package no.hiof.larseknu.flatfil;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        // Filstien til filen vi ønsker å skrive til
        String filsti = "novelle.txt";

        try {
            // Oppretter og instansierer en BufferedReader (slik at vi får bufret lesingen og kan lese en linje av gangen)
            // får info fra InputStreamReader, leser fra InputStream'en som kommer fra System (altså konsollen vår)
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            try (FileWriter filSkriver = new FileWriter(filsti, true)) {
                // En string for å holde på hver linje vi har lest fre konsollen
                String lestTekst = "";

                System.out.println("Skriv tekst ('avslutt' for å avslutte)");

                // Kjør løkke så lenge ikke "avslutt" er skrevet
                while (lestTekst.compareTo("avslutt") != 0) {
                    // Printer et kolon til konsollen
                    System.out.print(": ");
                    // Leser ut teksten som har blitt skrevet og legger de i "lestTekst"
                    lestTekst = bufferedReader.readLine();
                    // Skriver linjen til fil (med linjeskift)
                    filSkriver.write(lestTekst + "\r\n");
                }
                // Fanger opp IOEsception (typisk hvis vi ikke klarte å finne fil eller lignende)
            } catch (IOException ioexc) {
                System.out.println("I/O feil: " + ioexc.getMessage());
            } finally {
                // Passer på å lukke bufferedReaderen vår, uavhengig av om noe gikk feil eller ikke
                bufferedReader.close();
            }
        } catch (IOException iexc) {
            System.err.println(iexc.getMessage());
        }
    }
}
