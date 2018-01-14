
public class Main {

    public static void main(String[] args) {
		Student student1 = new Student("Andreas", "Hansen");
		Student student2 = student1;
		
		student1.setEtternavn("Johansen");
		
		System.out.println("Student1: " + student1.getFornavn() + " " + student1.getEtternavn());	
		System.out.println("Student2: " + student2.getFornavn() + " " + student2.getEtternavn());
	}
	
}