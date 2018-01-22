package no.hiof.larseknu.flyoversikt;

public class Main {

    public static void main(String[] args) {
        // Initialiserer ett flyobjekt med 130 seter
        Fly boing747 = new Fly("Boing-747", 130);

        // Legger til noen passasjerer
        boing747.leggTilEnPassasjer();
        boing747.leggTilEnPassasjer();
        boing747.leggTilEnPassasjer();
        boing747.leggTilEnPassasjer();
        boing747.leggTilEnPassasjer();
        boing747.leggTilEnPassasjer();

        // Skriver ut antallet passasjerer
        System.out.println("Det er " + boing747.getPassasjerer() + " passasjerer på vårt Boing-747");

        // Lager et transportfly med 15 seter og en makslast på 10000.0
        Transportfly an225 = new Transportfly("AN-225", 15, 10000.0);

        // Legger til en pakke
        an225.leggTilEnPakke(5, 5, 5);

        // Skriver ut brukt last
        System.out.println("Brukt last på An-225: " + an225.getBruktLast());

        // Vi kan kalle leggTilEnPassasjer metoden, siden vi extender klasse Fly
        an225.leggTilEnPassasjer();
        an225.leggTilEnPassasjer();
        an225.leggTilEnPassasjer();

        // Vi kan kalle getPassasjerer metoden, siden vi extender klasse Fly
        System.out.println("Antall passasjerer på AN-225: " + an225.getPassasjerer());
    }
}
