package no.hiof.larseknu.figurarv;

public abstract class Figur implements Tegnbar, Comparable<Figur> {

    private String farge;

    public Figur(String farge) {
        this.farge = farge;
    }

    public abstract double omkrets();

    public abstract double areal();

    @Override
    public int compareTo(Figur sammenLigningsFigur) {
        /*if (this.areal() > sammenLigningsFigur.areal())
            return 1;
        else if (this.areal() < sammenLigningsFigur.areal())
            return -1;
        else {
            if (this.omkrets() > sammenLigningsFigur.omkrets())
                return 1;
            else if (this.omkrets() < sammenLigningsFigur.omkrets())
                return -1;
            else
                return 0;
        }*/

        int returVerdi = (int) (this.areal() - sammenLigningsFigur.areal());

        if (returVerdi == 0)
            returVerdi = (int) (this.omkrets() - sammenLigningsFigur.omkrets());

        return returVerdi;
    }

    public static boolean erStorre(Figur figur1, Figur figur2) {

        return figur1.areal() > figur2.areal();
    }

    public String getFarge() {
        return farge;
    }

    public void setFarge(String farge) {
        this.farge = farge;
    }
}
