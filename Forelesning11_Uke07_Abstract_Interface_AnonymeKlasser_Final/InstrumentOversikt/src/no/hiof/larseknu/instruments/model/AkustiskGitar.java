package no.hiof.larseknu.instruments.model;

public class AkustiskGitar extends StrengeInstrument {

    public AkustiskGitar(String navn, int antallStrenger) {
        super(navn, antallStrenger);
    }

    @Override
    public void play() {
        System.out.println(super.getNavn() + " spiller akustisk lyd fra lydbiblioteket på " + super.getAntallStrenger() + " strenger");
    }
}
