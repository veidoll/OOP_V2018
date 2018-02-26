package no.hiof.larseknu.javafxdyrepark.model;

import java.time.LocalDate;

public class Dyr {
    private String navn;
    private String art;
    private LocalDate fodselsDato;
    // final ID, som gjør at ID'en til ett dyr ikke kan endres etter det er satt første gang
    private final int ID;
    // static idTeller, denne er "felles" for Dyre-klassen. Så alle objekter vil ha tilgang til den samme verdien
    private static int idTeller = 100;

    public Dyr(String navn, String art, LocalDate fodselsDato) {
        this.navn = navn;
        this.art = art;
        this.fodselsDato = fodselsDato;
        // Setter ID'en og øker idTeller med 1 slik at neste dyr som blir opprettet får en verdi som er 1 høyere
        this.ID = Dyr.idTeller++;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getArt() {
        return art;
    }

    public void setArt(String art) {
        this.art = art;
    }

    public static int getIdTeller() {
        return idTeller;
    }

    public static void setIdTeller(int idTeller) {
        Dyr.idTeller = idTeller;
    }

    public LocalDate getFodselsDato() {
        return fodselsDato;
    }

    public void setFodselsDato(LocalDate fodselsDato) {
        this.fodselsDato = fodselsDato;
    }

    public int getID() {
        return ID;
    }

    @Override
    public String toString() {
        return art + " - " + navn;
    }
}
