package no.hiof.larseknu.figurarv;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Rektangel rektangelet = new Rektangel(5, 6);

        Sirkel sirkelen = new Sirkel(5);

        // Bruker statisk metode fra klassen Figur, siden den er statisk trenger vi ikke en instans av klassen først
        if (Figur.erStorre(rektangelet, sirkelen)) {
            System.out.println(rektangelet + " er større enn " + sirkelen);
        }
        else {
            System.out.println(sirkelen + " er større enn " + rektangelet);
        }

        // Oppretter og instansierer ett figurobjekt
        Figur figurObjekt = new Figur();

        // Bruker den ikke-statiske metoden for å sammenligne to figurer, vi må da ha en instans av figurklassen for å gjøre dette
        if (figurObjekt.erStorreMetodeSomIkkeErStatisk(rektangelet, sirkelen)) {
            System.out.println(rektangelet + " er større enn " + sirkelen);
        }
        else {
            System.out.println(sirkelen + " er større enn " + rektangelet);
        }
    }

}
