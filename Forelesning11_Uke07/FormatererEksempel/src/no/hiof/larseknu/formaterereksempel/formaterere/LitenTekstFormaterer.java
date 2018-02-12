package no.hiof.larseknu.formaterereksempel.formaterere;

public class LitenTekstFormaterer implements Formaterer {
    @Override
    public String formater(String tekstSomSkalFormateres) {
        return tekstSomSkalFormateres.toLowerCase();
    }
}
