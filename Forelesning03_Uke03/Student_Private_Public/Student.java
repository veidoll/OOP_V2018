public class Student {
    private String fornavn;
    private String etternavn;
    private String studentId;
	private String fodselsNummer;
	
	public Student (String fornavn, String etternavn, String studentId, String fodselsNummer) {
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.studentId = studentId;
		this.fodselsNummer = fodselsNummer;
	}
	
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
		if (studentId.length() == 6) {
            System.out.println("StudentId: " + studentId);
            this.studentId = studentId;
        }
        else {
            System.out.println("ERROR: StudentId må inneholde nøyaktig 6 tegn");
        }
    }

    public String getFornavn() {
        return fornavn;
    }

    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }

    public String getEtternavn() {
        return etternavn;
    }

    public void setEtternavn(String etternavn) {
        this.etternavn = etternavn;
    }
	
	public String getFodselsNummer() {
		return fodselsNummer;
	}
}
