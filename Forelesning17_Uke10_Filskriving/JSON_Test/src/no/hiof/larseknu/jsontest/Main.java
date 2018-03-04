package no.hiof.larseknu.jsontest;

import com.google.gson.Gson;
import no.hiof.larseknu.jsontest.model.Superhelt;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // Oppretter og instansierer et Gson objekt for JSON behandling
        Gson gson = new Gson();

        // Konverterer et Superhelt-objekt om til JSON (string-representasjon)
        String jsonText = gson.toJson(new Superhelt("Superman", "Clark Kent"));
        // Skriver ut JSON stringen til konsollen
        System.out.println("JSON objekt: " + jsonText);
        // Konverterer JSON-stringen tilbake til et Superhelt-objekt
        Superhelt superman = gson.fromJson(jsonText, Superhelt.class);
        // Skriver ut objektet til konsollen
        System.out.println("Konvertert fra JSON: " + superman);

        // Lager en liste med superhelter
        ArrayList<Superhelt> superheltArrayList = new ArrayList<>();
        // Lager og legger til noen superhelter i listen
        superheltArrayList.add(new Superhelt("Batman", "Bruce Wayne"));
        superheltArrayList.add(new Superhelt("The Hulk", "Bruce Banner"));
        superheltArrayList.add(superman);

        // Konverterer hele listen til JSON
        String jsonTextListe = gson.toJson(superheltArrayList);
        // Skriver ut JSON-en til konsollen
        System.out.println("JSON liste: " + jsonTextListe);

        // Konverterer listen tilbake til en array
        Superhelt[] superheltArray = gson.fromJson(jsonTextListe, Superhelt[].class);
        // Går gjennom elementene i arrayen og skriver ut
        for (Superhelt enHelt : superheltArray) {
            System.out.println("Konvertert fra JSON liste: " + enHelt);
        }
    }
}
