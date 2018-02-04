package no.hiof.larseknu.movietime;

public class Episode {
    private int episodeNummer;
    private int sesongNummer;
    private String tittel;
    private int spilletid;

    public Episode(int episodeNummer, int sesongNummer, String tittel) {
        this.episodeNummer = episodeNummer;
        this.sesongNummer = sesongNummer;
        this.tittel = tittel;
    }

    public Episode(int episodeNummer, int sesongNummer, String tittel, int spilletid) {
        this.episodeNummer = episodeNummer;
        this.sesongNummer = sesongNummer;
        this.tittel = tittel;
        this.spilletid = spilletid;
    }

    public int getEpisodeNummer() {
        return episodeNummer;
    }

    public void setEpisodeNummer(int episodeNummer) {
        this.episodeNummer = episodeNummer;
    }

    public int getSesongNummer() {
        return sesongNummer;
    }

    public void setSesongNummer(int sesongNummer) {
        this.sesongNummer = sesongNummer;
    }

    public String getTittel() {
        return tittel;
    }

    public void setTittel(String tittel) {
        this.tittel = tittel;
    }

    public int getSpilletid() {
        return spilletid;
    }

    public void setSpilletid(int spilletid) {
        this.spilletid = spilletid;
    }

    @Override
    public String toString() {
        return tittel + " - S" + sesongNummer + "E" + episodeNummer;
    }
}
