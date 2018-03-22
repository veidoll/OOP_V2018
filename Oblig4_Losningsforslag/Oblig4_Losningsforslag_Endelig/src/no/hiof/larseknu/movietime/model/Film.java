package no.hiof.larseknu.movietime.model;

import java.time.LocalDate;

// En film "er en" produksjon, så derfor har vi satt at den extender Produksjon
// Vi får dermed med alle egenskapene fra Produksjon "gratis"
public class Film extends Produksjon implements Comparable<Film> {

    public Film(String tittel, String beskrivelse, int spilletid, LocalDate utgivelsesdato, Person regisor) {
        // Kaller superkontruktøren (som tilhører Produksjon), vi "sender" da tittel, beskrivelse, spilletid, utgivelsesdato og regisor videre
        super(tittel, beskrivelse, spilletid, utgivelsesdato, regisor);
    }

    public Film() {
        super();
    }

    @Override
    public String toString() {
        // super - nøkkelordet her er strengt tatt ikke nødvendig, men det gjør det tydelig at metodene tilhører superklassen
        return super.getTittel() + (super.getUtgivelsesdato() != LocalDate.MIN ? " (" + super.getUtgivelsesdato().getYear() + ")" :"");// + (super.getSpilletid() > 0 ? super.getSpilletid() + " minutter" : "");

    }

    @Override
    public int compareTo(Film sammenligningsFilm) {
        // Vi sammenligner tittelen til filmene, som er en String. Så vi drar også nytte av String sin egen compareTo metode
        return this.getTittel().compareTo(sammenligningsFilm.getTittel());
    }
}
