package no.hiof.larseknu.figurarv;

public class Rektangel extends Figur {
    private double side1;
    private double side2;
    private static final String STANDARDFARGE = "Grønn";

    public Rektangel(double side1, double side2) {
        super(STANDARDFARGE);
        this.side1 = side1;
        this.side2 = side2;
    }

    public Rektangel(double side1, double side2, String farge) {
        super(farge);
        this.side1 = side1;
        this.side2 = side2;
    }

    @Override
    public double omkrets() {
        return side1 * 2 + side2 * 2;
    }

    @Override
    public double areal() {
        return side1 * side2;
    }

    @Override
    public void tegn() {
        System.out.println(" --------");
        System.out.println("|        |");
        System.out.println("|        |");
        System.out.println(" --------");
    }

    public double getSide1() {
        return side1;
    }

    public double getSide2() {
        return side2;
    }

    public final void setSide1(double side1) {
        this.side1 = side1;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }



    @Override
    public String toString() {
        return "Rektangel med sidene " + side1 + " " + side2;
    }


}
