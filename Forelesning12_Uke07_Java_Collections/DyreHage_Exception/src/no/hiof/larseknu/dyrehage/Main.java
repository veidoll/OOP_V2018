package no.hiof.larseknu.dyrehage;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {
        Dyrepark kristiansandDyrepark = new Dyrepark("Kristiansand Dyrepark");

        HonningGrevling honningGrevlingenJon = new HonningGrevling("Jon", LocalDate.of(2013, 3, 2));
        Sjimpanse sjimpansenArne = new Sjimpanse("Arne", LocalDate.of(2014, 4, 13), 60);
        Panda pandaenTrine = new Panda("Trine", LocalDate.of(2017, 3, 17), "Hvit");

        kristiansandDyrepark.leggTilEttDyrIDyreparken(honningGrevlingenJon);
        kristiansandDyrepark.leggTilEttDyrIDyreparken(sjimpansenArne);
        kristiansandDyrepark.leggTilEttDyrIDyreparken(pandaenTrine);

        honningGrevlingenJon.drepteEnSlangeTil();
        sjimpansenArne.setIq(50);
        // Trine graderte rett før hun ble 1 år
        pandaenTrine.setKungFuBelteFarge("Gult");

        System.out.println(sjimpansenArne.getId());

        kristiansandDyrepark.skrivAlleMedBursdagAngittMaanedTilFil(3, "/testen/bursdager_mars.txt");
    }


}
