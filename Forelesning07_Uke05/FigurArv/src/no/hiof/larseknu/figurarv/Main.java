package no.hiof.larseknu.figurarv;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Rektangel rektangelet = new Rektangel(4,5);

        Kvadrat kvadratet = new Kvadrat(3);

        Sirkel sirkelen = new Sirkel(3);

        Rektangel rektangelet2 = new Kvadrat(4);

        System.out.println(rektangelet + "    Areal: " + rektangelet.areal()+"   Omkrets: " + rektangelet.omkrets());
        System.out.println(kvadratet + "    Areal: " + kvadratet.areal() + "   Omkrets: " + kvadratet.omkrets() );
        System.out.println(sirkelen + "    Areal: " + sirkelen.areal() + "   Omkrets: " + sirkelen.omkrets() );
        System.out.println(rektangelet2 + "    Areal: " + rektangelet2.areal() + "   Omkrets: " + rektangelet2.omkrets());

        System.out.println(rektangelet);
        System.out.println(kvadratet);
        System.out.println(sirkelen);

        Rektangel rektangel2 = new Rektangel(3, 5);
        Kvadrat kvadrat2 = (Kvadrat)rektangel2;


        if (erStorre(rektangelet, kvadratet)) {
            System.out.println(rektangelet + " er størst");
        }
        else {
            System.out.println(kvadratet + " er størst");
        }


        ArrayList<Figur> figurArrayList = new ArrayList<>();

        figurArrayList.add(rektangelet);
        figurArrayList.add(kvadratet);
        figurArrayList.add(sirkelen);
        figurArrayList.add(rektangelet2);

        for (Figur enFigur : figurArrayList) {
            //System.out.println(enFigur.toString());
        }

        Figur[] figurArray = new Figur[4];

        figurArray[0] = rektangelet;
        figurArray[1] = kvadratet;
        figurArray[2] = sirkelen;


        int[] maaneder = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };

        for (int maaned : maaneder)
            System.out.println(maaned);

        for (Figur enFigur : figurArray) {
            System.out.println(enFigur);

            if (enFigur instanceof Sirkel) {
                Sirkel enSirkel = (Sirkel)enFigur;
                System.out.println("Sirkelens diameter er: " + enSirkel.beregnDiameter());
            }
        }


        /*// Går gjennom alle elementene i en liste og skriver ut areal
        for (int i = 0; i < figurArray.length; i++) {
            // Lager en ny referanse til objektet vi skal jobbe med
            Figur enFigur = figurArray[i];
            // Skriver ut arealet til figuren
            System.out.println(enFigur.areal());
        }

        // Går gjennom alle elementene i en liste og skriver ut areal
        for (Figur enFigur : figurArray) {
            // Skriver ut arealet til figuren
            System.out.println(enFigur.areal());
        }*/


        String meningenMedLivet = "42";
        int bareEtTall = Integer.parseInt(meningenMedLivet);


        double alder = 8.5;
        int ordentligAlder = (int)alder;
    }

    private static boolean erStorre(Figur figur1, Figur figur2)
    {
        return figur1.areal() > figur2.areal();
    }
}
