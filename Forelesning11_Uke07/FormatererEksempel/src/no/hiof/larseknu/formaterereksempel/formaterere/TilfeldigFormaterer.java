package no.hiof.larseknu.formaterereksempel.formaterere;

import java.util.Random;

public class TilfeldigFormaterer implements Formaterer {


    @Override
    public String formater(String tekstSomSkalFormateres) {

        StringBuilder stringBygger = new StringBuilder();
        Random tilfeldigTrueFalse = new Random();
        boolean gjorBokstavStor = true;
        for(char enChar : tekstSomSkalFormateres.toCharArray() )
        {
            gjorBokstavStor = tilfeldigTrueFalse.nextBoolean();

            if (gjorBokstavStor)
                stringBygger.append(Character.toUpperCase(enChar));
            else
                stringBygger.append(Character.toLowerCase(enChar));
        }

        return stringBygger.toString();
    }
}
