package no.hiof.larseknu.formaterereksempel.formaterere;

public class StorTekstFormaterer implements Formaterer {
    @Override
    public String formater(String tekstSomSkalFormateres) {
        return tekstSomSkalFormateres.toUpperCase();
    }
}
