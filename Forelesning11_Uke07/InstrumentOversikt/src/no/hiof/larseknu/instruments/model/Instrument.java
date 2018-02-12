package no.hiof.larseknu.instruments.model;

public abstract class Instrument {
    private String navn;

    public Instrument(String navn) {
        this.navn = navn;
    }

    public abstract void play();

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }
}
