package no.hiof.larseknu.flyoversikt;

public class Main {

    public static void main(String[] args) {
        // Oppretter og initialiserer ett flyobjekt med 130 seter
        Fly boing747 = new Fly("Boing-747", 130);

        // Legger til noen passasjerer
        boing747.leggTilEnPassasjer();
        boing747.leggTilEnPassasjer();
        boing747.leggTilEnPassasjer();
        boing747.leggTilEnPassasjer();
        boing747.leggTilEnPassasjer();
        boing747.leggTilEnPassasjer();

        // Skriver ut antallet seter
        System.out.println("Det er " + boing747.getSeter() + " seter på vårt Boing-747");
        // Skriver ut antallet passasjerer
        System.out.println("Det er " + boing747.getPassasjerer() + " passasjerer på vårt Boing-747");
    }
}
