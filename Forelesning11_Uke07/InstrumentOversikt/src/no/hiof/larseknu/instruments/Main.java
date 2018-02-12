package no.hiof.larseknu.instruments;

import no.hiof.larseknu.instruments.model.AkustiskGitar;
import no.hiof.larseknu.instruments.model.BassGitar;

public class Main {

    public static void main(String[] args) {
        AkustiskGitar fenderPM1 = new AkustiskGitar("Fender PM1", 6);
        AkustiskGitar fenderPM2 = new AkustiskGitar("Fender PM2", 6);

        BassGitar warwickCorvette = new BassGitar("Warwick Corvette", 4);

        fenderPM1.play();
        fenderPM2.play();
        warwickCorvette.play();

    }
}
