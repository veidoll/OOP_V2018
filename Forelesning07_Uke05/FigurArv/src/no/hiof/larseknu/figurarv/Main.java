package no.hiof.larseknu.figurarv;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // Opprettet og instansierer et rektangelobjekt
        Rektangel rektangelet = new Rektangel(4,5);

        // Oppretter og instansierer et kvadratobjekt
        Kvadrat kvadratet = new Kvadrat(3);

        // Oppretter og instansierer et sirkelobjekt
        Sirkel sirkelen = new Sirkel(3);

        // Oppretter et rektangelobjekt, instansierer den som et kvadrat
        Rektangel rektangelet2 = new Kvadrat(4);

        // Skriver ut en linje med * for å skille utskriftene i terminalen
        System.out.println("\n********Vanlig utskrift fra objekter**********");

        // Skriver ut infromasjon om figurene vi har laget
        // Først figuren selv (toString blir benyttet i "bakgrunn"), så areal og omkrets
        System.out.println(rektangelet + "    Areal: " + rektangelet.areal()+"   Omkrets: " + rektangelet.omkrets());
        System.out.println(kvadratet + "    Areal: " + kvadratet.areal() + "   Omkrets: " + kvadratet.omkrets() );
        System.out.println(sirkelen + "    Areal: " + sirkelen.areal() + "   Omkrets: " + sirkelen.omkrets() );
        System.out.println(rektangelet2 + "    Areal: " + rektangelet2.areal() + "   Omkrets: " + rektangelet2.omkrets());

        // Skriver ut en linje med * for å skille utskriftene i terminalen
        System.out.println("\n*********Hvilken er størst?**********");

        // Sjekker om rektangelet er større enn kvadratet ved hjelp av metoden "erStorre"
        // Skriver så ut hvilken som er størst
        if (erStorre(rektangelet, kvadratet)) {
            System.out.println(rektangelet + " er størst");
        }
        else {
            System.out.println(kvadratet + " er størst");
        }



        // Lager en arrat som kan fylles med figurobjekter, plass til 4 stykker
        Figur[] figurArray = new Figur[4];

        // Legger til objekter som arver fra klassen figur
        figurArray[0] = rektangelet;
        figurArray[1] = kvadratet;
        figurArray[2] = sirkelen;
        figurArray[3] = rektangelet2;
        // Kan ikke legge til flere figurer i arrayen, derfor kommentert bort:
        // figurArray[4] = rektangelet;

        // Skriver ut en linje med * for å skille utskriftene i terminalen
        System.out.println("\n********Utskrift fra Array*********");

        // Lager en løkke som kjører like mange ganger som lengden til figurArray
        for (int i = 0; i < figurArray.length; i++) {
            System.out.println(figurArray[i].toString());
        }



        // Initialiserer en array med inter, med 12 tall som representerer månedene
        // Gir verdier til alle elementene i arrayet med en gang
        int[] maaneder = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };

        // Oppretter og instansierer et arraylisteobjekt som skal inneholde figurer
        ArrayList<Figur> figurArrayListe = new ArrayList<>();

        // Legger til figurobjekter til arraylisten
        figurArrayListe.add(rektangelet);
        figurArrayListe.add(kvadratet);
        figurArrayListe.add(sirkelen);
        figurArrayListe.add(rektangelet2);

        // Skriver ut en linje med * for å skille utskriftene i terminalen
        System.out.println("\n*******Utskrift fra ArrayList********");

        // Går gjennom listen ved hjelp av foreach og skriver ut informasjon om figuren
        for (Figur enFigur : figurArrayListe) {
            System.out.println(enFigur);

            // Undersøker om figuren er av instans Sirkel
            if (enFigur instanceof Sirkel) {
                // Hvis den er det, typecaster vi den til et Sirkel-objekt for å få tilgang til metoder
                Sirkel enSirkel = (Sirkel)enFigur;
                // Benytter beregnDiameter metoden vi få har tilgjengelig og skriver den ut
                System.out.println("Sirkelens diameter er: " + enSirkel.beregnDiameter());
            }
        }

        // Skriver ut en linje med * for å skille utskriftene i terminalen
        System.out.println("*****************************");

        // Lager en string med nummeret 42
        String meningenMedLivet = "42";
        // Benytter parseInt metoden i klassen Integer til å konvertere fra string til int
        int bareEtTall = Integer.parseInt(meningenMedLivet);


        // Lager en int med timeLonn
        int timeLonn = 150;
        // Gjør en implicit typecast til en double
        double faktiskTimeLonn = timeLonn;

        // Lager en double med alder
        double alder = 8.5;
        // Gjør en explicit typecast til int
        int ordentligAlder = (int)alder;
    }

    private static boolean erStorre(Figur figur1, Figur figur2)
    {
        return figur1.areal() > figur2.areal();
    }
}
