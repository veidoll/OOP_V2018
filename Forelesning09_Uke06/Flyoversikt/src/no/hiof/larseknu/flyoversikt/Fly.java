package no.hiof.larseknu.flyoversikt;

public class Fly {
    private String modell;
    private int passasjerer;
    private int seter;
    private static int totaltAntallPassasjerer;

    public Fly() {
        seter = 150;
        passasjerer = 0;
    }

    public Fly(String modell) {
        this.modell = modell;
    }

    public Fly(int seter) {
        this.seter = seter;
        passasjerer = 0;
    }

    public Fly(String modell, int seter) {
        this.modell = modell;
        this.seter = seter;
        passasjerer = 0;
    }

    public int getPassasjerer() {
        return passasjerer;
    }

    public int getSeter() {
        return seter;
    }

    public String getModell() {
        return modell;
    }

    public static int getTotaltAntallPassasjerer() {
        return totaltAntallPassasjerer;
    }

    public void leggTilEnPassasjer() {
        // Sjekker om vi har noen ledige seter
        if (harLedigeSeter()) {
            // Øker feltvariabelen passasjer som tilhører instansen av klassen med 1
            passasjerer++;
            // Øker klassevariabelen (statiske feltvariabelen) totaltAntallPassasjerer som tilhører selve klassen med 1
            totaltAntallPassasjerer++;
        }
        else
            ingenLedigeSeter();
    }

    private boolean harLedigeSeter() {
        return passasjerer < seter;
    }

    private void ingenLedigeSeter() {
        System.out.println("Ingen ledige seter tilgjengelig");
    }

    @Override
    public String toString() {
        return "Flyet " + modell + " har " + seter + " seter og " + passasjerer + " passasjerer.";
    }
}
