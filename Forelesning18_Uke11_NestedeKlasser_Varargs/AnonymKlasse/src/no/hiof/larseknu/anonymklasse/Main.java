package no.hiof.larseknu.anonymklasse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        // Lager en liste med dyr vi har sett på safari
        ArrayList<SafariDyr> dyrSettPaaSafari = new ArrayList<>();

        dyrSettPaaSafari.add(new SafariDyr("Baloo", "Bjørn", 35));
        dyrSettPaaSafari.add(new SafariDyr("Shere Kahn", "Tiger", 56));
        dyrSettPaaSafari.add(new SafariDyr("Baghera", "Panter", 35));
        dyrSettPaaSafari.add(new SafariDyr("Kaa", "Slange", 23));
        dyrSettPaaSafari.add(new SafariDyr("Nils", "HonningGrevling", 23));

        // Skriver ut lista slik vi lagde den, uten noen sortering
        System.out.println("Usortert: " + dyrSettPaaSafari);

        System.out.println("-------------------------");

        // Sorterer lista, siden vi implementerer Comparable, den sorterer på navn
        Collections.sort(dyrSettPaaSafari);
        System.out.println("Sortert: " + dyrSettPaaSafari);

        System.out.println("-------------------------");

        // ArrayList har også en sort metode som tar en Comparator
        // Collections.reverseOrder() gjør at vi får en motsatt sortering av slik vi implemterte via Comparable
        dyrSettPaaSafari.sort(Collections.reverseOrder());
        System.out.println("Sortert baklengs: " + dyrSettPaaSafari);


        System.out.println("-------------------------");

        // Lager en anonym klasse av interfacet Comparator,
        // som gjør det mulig å sortere dyr basert på alder
        Comparator<SafariDyr> aldersComparator = new Comparator<SafariDyr>() {
            @Override
            public int compare(SafariDyr dyr1, SafariDyr dyr2) {
                if (dyr1.getAlder() > dyr2.getAlder())
                    return 1;
                else if (dyr1.getAlder() < dyr2.getAlder())
                    return -1;
                return 0;
            }
        };

        // Gjør selve sorteringen ved hjelp av Comparatoren vi lagde
        dyrSettPaaSafari.sort(aldersComparator);

        System.out.println("Sortert alder stigende: ");
        for (SafariDyr etDyr : dyrSettPaaSafari) {
            System.out.println(etDyr.getNavn() + " - " + etDyr.getAlder());
        }


        System.out.println("-------------------------");

        // Lager en ny anonym klasse, som sorterer basert på alder, motsatt vei
        // Her lager vi den direkte i sort-metoden, fremfor å legge den i et eget objekt
        dyrSettPaaSafari.sort(new Comparator<SafariDyr>() {
            @Override
            public int compare(SafariDyr safariDyr1, SafariDyr safariDyr2) {
                return safariDyr2.getAlder() - safariDyr1.getAlder();
            }
        });

        // Gjør akkurat det samme som sorteringen rett over,
        // bare at vi benytter en reversert versjon av Comparatoren vi lagde et objekt av tidligere
        dyrSettPaaSafari.sort(aldersComparator.reversed());

        System.out.println("Sortert alder synkende: ");
        for (SafariDyr etDyr : dyrSettPaaSafari) {
            System.out.println(etDyr.getNavn() + " - " + etDyr.getAlder());
        }
    }
}
