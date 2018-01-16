package no.hiof.larseknu.flyoversikt;

public class Fly {
    private int passasjerer;
    private int seter;

    public Fly() {
        seter = 150;
        passasjerer = 0;
    }

    public Fly(int seter) {
        this.seter = seter;
        passasjerer = 0;
    }

    public int getPassasjerer() {
        return passasjerer;
    }

    public int getSeter() {
        return seter;
    }

    public void leggTilEnPassasjer() {
        if (harLedigeSeter())
            passasjerer++;
        else
            ingenLedigeSeter();
    }

    private boolean harLedigeSeter() {
        return passasjerer < seter;
    }

    private void ingenLedigeSeter() {
        System.out.println("Ingen ledige seter tilgjengelig");
    }
}
