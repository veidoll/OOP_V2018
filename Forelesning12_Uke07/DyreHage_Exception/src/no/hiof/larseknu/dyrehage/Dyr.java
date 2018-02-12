package no.hiof.larseknu.dyrehage;

import java.time.LocalDate;

public abstract class Dyr {
    private String navn;
    private final int ID_NUMMER;
    private LocalDate fodselsdag;
    private static int dyreTeller;

    public Dyr(String navn) {
        this(navn, LocalDate.EPOCH);
    }

    public Dyr(String navn, LocalDate fodselsdag) {
        this.navn = navn;
        this.ID_NUMMER = dyreTeller++;
        this.fodselsdag = fodselsdag;
    }

    public int getId() {
        return ID_NUMMER;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public LocalDate getFodselsdag() {
        return fodselsdag;
    }

    public void setFodselsdag(LocalDate fodselsdag) {
        this.fodselsdag = fodselsdag;
    }


}
