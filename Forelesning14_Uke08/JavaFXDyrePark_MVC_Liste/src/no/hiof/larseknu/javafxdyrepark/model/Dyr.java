package no.hiof.larseknu.javafxdyrepark.model;

import java.time.LocalDate;

public class Dyr {
    private String navn;
    private String art;
    private LocalDate fodselsDato;
    private final int ID;
    private static int idTeller = 100;

    public Dyr(String navn, String art, LocalDate fodselsDato) {
        this.navn = navn;
        this.art = art;
        this.fodselsDato = fodselsDato;
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
}
