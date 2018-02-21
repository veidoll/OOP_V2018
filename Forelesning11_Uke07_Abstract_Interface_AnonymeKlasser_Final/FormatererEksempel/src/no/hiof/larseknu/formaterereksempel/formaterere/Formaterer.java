package no.hiof.larseknu.formaterereksempel.formaterere;

public interface Formaterer {
    // Public static final er egentlig implicitt, så vi trenger egentlig ikke skrive det
    // En konstantvariabel, skrives normalt sett med kun UPPERCASE
    String STANDARD_TEKST = "Bear with me!";

    // Public abstract er implicitt, så vi trenger egentlig ikke skrive det
    // En metode som tar en string, og returnerer en formatert versjon av stringen
    public abstract String formater(String tekstSomSkalFormateres);
}
