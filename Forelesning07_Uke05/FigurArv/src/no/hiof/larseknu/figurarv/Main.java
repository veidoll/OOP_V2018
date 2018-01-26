package no.hiof.larseknu.figurarv;

public class Main {

    public static void main(String[] args) {
        Rektangel rektangel = new Rektangel(4,5);

        Kvadrat kvadrat = new Kvadrat(3);

        Sirkel sirkel = new Sirkel(3);

        Rektangel rektangel2 = new Kvadrat(4);

        System.out.println(rektangel + "    Areal: " + rektangel.areal()+"   Omkrets: " + rektangel.omkrets());
        System.out.println(kvadrat + "    Areal: " + kvadrat.areal() + "   Omkrets: " + kvadrat.omkrets() );
        System.out.println(sirkel + "    Areal: " + sirkel.areal() + "   Omkrets: " + sirkel.omkrets() );
        System.out.println(rektangel2 + "    Areal: " + rektangel2.areal() + "   Omkrets: " + rektangel2.omkrets());

        System.out.println(rektangel);
        System.out.println(kvadrat);
        System.out.println(sirkel);

        if (erStorre(rektangel, kvadrat) == true) {
            System.out.println(rektangel + " er størst");
        }
        else {
            System.out.println(kvadrat + " er størst");
        }
    }

    private static boolean erStorre(Figur figur1, Figur figur2)
    {
        return figur1.areal() > figur2.areal();
    }
}
