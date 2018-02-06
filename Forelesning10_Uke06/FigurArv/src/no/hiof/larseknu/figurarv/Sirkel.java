package no.hiof.larseknu.figurarv;

public class Sirkel extends Figur {
    private double radius;
    private final static String STANDARDFARGE = "Blå";

    public Sirkel(double radius)
    {
        super(STANDARDFARGE);
        this.radius=radius;
    }

    @Override
    public double omkrets() {
        return 2 * Math.PI * radius;
    }

    @Override
    public double areal()
    {
        return Math.PI * radius * radius;
    }



    public double beregnDiameter() {
        return 2 * radius;
    }

    @Override
    public String toString() {
        return "Sirkel med radius " + radius;
    }

    @Override
    public void tegn() {
        System.out.println("   ---");
        System.out.println(" /     \\");
        System.out.println("|       |");
        System.out.println(" \\     /");
        System.out.println("   ---");
    }

}
