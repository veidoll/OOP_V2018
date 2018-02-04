package no.hiof.larseknu.movietime;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;

public class TvSerie {
    private String tittel;
    private String beskrivelse;
    private LocalDate utgivelsesdato;
    private ArrayList<Episode> episodeListe = new ArrayList<>();
    private int gjennomSnittligSpilletid;
    private int antallSesonger;

    public TvSerie(String tittel, String beskrivelse, LocalDate utgivelsesdato) {
        this.tittel = tittel;
        this.beskrivelse = beskrivelse;
        this.utgivelsesdato = utgivelsesdato;
    }

    public void leggTilEpisode(Episode episode) {
        if (antallSesonger+1 < episode.getSesongNummer()) {
            System.out.println("FEIL: Det er ikke mulig å legge til episoder for sesong " + episode.getSesongNummer() + ", den er " + (episode.getSesongNummer()  - antallSesonger) + " høyere enn antallet sesonger");
        }
        else {
            episodeListe.add(episode);
            oppdaterGjennomsnittligSpilletid();

            if (antallSesonger+1 == episode.getSesongNummer())
                antallSesonger++;
        }

    }

    public ArrayList<Episode> hentEpisoderISesong(int sesongNummer) {

        ArrayList<Episode> episoderISesong = new ArrayList<>();


        for (Episode episode : episodeListe) {

            if (episode.getSesongNummer() == sesongNummer) {

                episoderISesong.add(episode);
            }
        }


        return episoderISesong;
    }

    private void oppdaterGjennomsnittligSpilletid() {

        int totalSpilletid = 0;


        for (Episode episode : episodeListe) {
            totalSpilletid += episode.getSpilletid();
        }


        gjennomSnittligSpilletid = totalSpilletid / episodeListe.size();
    }
    
    public String getTittel() {
        return tittel;
    }

    public void setTittel(String tittel) {
        this.tittel = tittel;
    }

    public String getBeskrivelse() {
        return beskrivelse;
    }

    public void setBeskrivelse(String beskrivelse) {
        this.beskrivelse = beskrivelse;
    }

    public LocalDate getUtgivelsesdato() {
        return utgivelsesdato;
    }

    public void setUtgivelsesdato(LocalDate utgivelsesdato) {
        this.utgivelsesdato = utgivelsesdato;
    }

    public ArrayList<Episode> getEpisodeListe() {

        ArrayList<Episode> returEpisodeListe = new ArrayList<>(episodeListe);

        return returEpisodeListe;
    }

    public int getGjennomSnittligSpilletid() {
        return gjennomSnittligSpilletid;
    }

    public int getAntallSesonger() {
        return antallSesonger;
    }

    @Override
    public String toString() {
        return tittel + " - " + utgivelsesdato.getYear();
    }
}