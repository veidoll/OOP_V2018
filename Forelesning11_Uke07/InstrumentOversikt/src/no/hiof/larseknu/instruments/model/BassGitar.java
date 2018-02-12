package no.hiof.larseknu.instruments.model;

public class BassGitar extends StrengeInstrument {

    public BassGitar(String navn, int antallStrenger) {
        super(navn, antallStrenger);
    }

    @Override
    public void play() {
        System.out.println(super.getNavn() + " spiller heftig bass fra lydbiblioteket på " + super.getAntallStrenger() + " strenger");
    }
}
