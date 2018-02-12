package no.hiof.larseknu.formaterereksempel.formaterere;

public class CamelCaseFormaterer implements Formaterer {
    @Override
    public String formater(String tekstSomSkalFormateres) {
        StringBuilder stringBygger = new StringBuilder();
        for( String oneString : tekstSomSkalFormateres.split(" ") )
        {
            stringBygger.append( oneString.substring(0,1).toUpperCase() );
            stringBygger.append( oneString.substring(1).toLowerCase() );
            stringBygger.append(" ");
        }

        return stringBygger.toString();
    }
}
