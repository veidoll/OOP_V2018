package no.hiof.larseknu.instruments.model;

public abstract class StrengeInstrument extends Instrument {
    private int antallStrenger;

    public StrengeInstrument(String navn, int antallStrenger) {
        super(navn);
        this.antallStrenger = antallStrenger;
    }

    public int getAntallStrenger() {
        return antallStrenger;
    }

    public void setAntallStrenger(int antallStrenger) {
        this.antallStrenger = antallStrenger;
    }
}
