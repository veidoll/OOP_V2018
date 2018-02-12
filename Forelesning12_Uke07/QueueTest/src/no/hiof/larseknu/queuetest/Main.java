package no.hiof.larseknu.queuetest;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class Main {

    public static void main(String[] args) {
        // vi har også andre typer collections enn lister
        // noen av disse kan være med på å yte kontroll

        // la oss se på queue - kø
        // Om vi ønsker funksjonalitet hvor vi tar vare på elementer
        // i en kø, slik at vi ikke kan hente/fjerne andre elementer
        // enn det første vi la til. Dette kalles FIFO - First In First Out

        // denne implementasjonen av en kø sier hva maks lengde skal være på køen
        ArrayBlockingQueue<String> dyreNavneKo = new ArrayBlockingQueue<>(5);

        // her legger vi til elementer i køen
        dyreNavneKo.offer("Sjimpanse(Arne)");
        dyreNavneKo.offer("Katt(Nala)");
        dyreNavneKo.offer("Hund(Dent)");
        dyreNavneKo.offer("Panda(Trine)");
        dyreNavneKo.offer("HonningGrevnling(Nils)");


        System.out.println(dyreNavneKo);

        // det eneste elementet vi da kan hente er det første -> Per
        // til dette sier vi at vi poller elementer fra køen

        // la oss hente "Per"
        System.out.println(dyreNavneKo.poll());

        // la oss se hva som er igjen i stabelen etter at vi poppet hilde av stabelen
        System.out.println(dyreNavneKo); // her ser vi da at han er fjernet

        // vi kan velge å se på elementet som ligger først uten at den fjernes ved å sniktitte på den
        System.out.println(dyreNavneKo.peek());

        System.out.println(dyreNavneKo); // vi ser da at kari ikke er fjernet
    }
}
