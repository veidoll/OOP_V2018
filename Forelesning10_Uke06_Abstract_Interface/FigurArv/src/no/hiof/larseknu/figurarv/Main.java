package no.hiof.larseknu.figurarv;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        // Opprettet og instansierer et rektangelobjekt
        Rektangel rektangelet = new Rektangel(2,8);

        // Oppretter og instansierer et kvadratobjekt
        Kvadrat kvadratet = new Kvadrat(4);

        Sirkel sirkel = new Sirkel(50);

        Rektangel rektangel = new Rektangel(1, 0.5);

        if(Figur.erStorre(rektangelet, kvadratet)) {
            System.out.println(rektangelet + " er størst");
        }
        else
            System.out.println(kvadratet + "er størst");


        ArrayList<Figur> figurListe = new ArrayList<>();

        figurListe.add(rektangelet);
        figurListe.add(kvadratet);
        figurListe.add(sirkel);
        figurListe.add(rektangel);

        System.out.println("\n******Tilfeldig liste:*******");

        for (Figur figur : figurListe)
            System.out.println(figur + " Areal: " + figur.areal() + " Omkrets: " + figur.omkrets());

        Collections.sort(figurListe);

        System.out.println("\n******Sortert liste:*******");

        for (Figur figur : figurListe)
            System.out.println(figur + " Areal: " + figur.areal() + " Omkrets: " + figur.omkrets());

        System.out.println("\n******Tegninger:*******");

        for (Figur enFigur : figurListe) {
            if (enFigur instanceof Tegnbar) {
                ((Tegnbar) enFigur).tegn();
            }
        }


    }



}
