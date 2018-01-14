
public class Main {

    public static void main(String[] args) {
		Student nikolaTesla = new Student("Nikola", "Tesla", "336918", "3691823593");

		nikolaTesla.setStudentId("36918");
		
		System.out.println(nikolaTesla.getFornavn() + " " + nikolaTesla.getEtternavn());
		System.out.println(nikolaTesla.getFodselsNummer());
		
	}
	
}