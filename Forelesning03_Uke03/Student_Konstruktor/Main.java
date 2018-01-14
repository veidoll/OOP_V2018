
public class Main {

    public static void main(String[] args) {
		Student nikolaTesla = new Student("Nikola", "Tesla", "336918", "3691833518");
		Student tonyStark = new Student("Tony", "Stark");
		
		System.out.println(nikolaTesla.getFornavn() + " " + nikolaTesla.getEtternavn());	
		System.out.println(tonyStark.getFornavn() + " " + tonyStark.getEtternavn());
		
	}
	
}