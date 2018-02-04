package no.hiof.larseknu.flyoversikt;

public class Transportfly extends Fly {
    private double maksLast;
    private double bruktLast;

    public Transportfly() {
        this.maksLast = 10000.0;
    }

    public Transportfly(double maksLast) {
        this.maksLast = maksLast;
    }

    public Transportfly(String modell, int seter, double maksLast) {
        super(modell, seter);
        this.maksLast = maksLast;
    }

    public double getBruktLast() {
        return bruktLast;
    }

    public void leggTilEnPakke(double hoyde, double bredde, double dybde) {
        double storrelse = hoyde * bredde * dybde;

        if (harLedigLagringsPlass(storrelse))
            bruktLast += storrelse;
        else
            ingenLedigPlass();
    }

    private boolean harLedigLagringsPlass(double storrelse) {
        return bruktLast + storrelse <= maksLast;
    }

    private void ingenLedigPlass() {
        System.out.println("Du vil overskride makslast");
    }

    @Override
    public String toString() {
        return super.toString() + " Med en brukt last på " + bruktLast + "m^3 av makslast " + maksLast + "m^3";
    }
}
