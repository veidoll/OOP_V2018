package no.hiof.larseknu.dyrehage.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Dyr {
    private String navn, art;
    private int id;
    private LocalDate fodselsdato;
    public static ArrayList<Dyr> dyrArrayList = new ArrayList<>();

    public Dyr(String navn, String art, int id, LocalDate fodselsdato) {
        this.navn = navn;
        this.art = art;
        this.id = id;
        this.fodselsdato = fodselsdato;

        dyrArrayList.add(this);
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getFodselsdato() {
        return fodselsdato;
    }

    public void setFodselsdato(LocalDate fodselsdato) {
        this.fodselsdato = fodselsdato;
    }

    @Override
    public String toString() {
        return navn + " " +  art;
    }
}
