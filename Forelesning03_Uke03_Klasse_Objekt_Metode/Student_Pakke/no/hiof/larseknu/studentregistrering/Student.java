package no.hiof.larseknu.studentregistrering;

public class Student {
    private String fornavn;
    private String etternavn;
    private String studentId;
	private String fodselsNummer;
	
	public Student () {	}
	
	public Student (String fornavn, String etternavn) {
		this.fornavn = fornavn;
		this.etternavn = etternavn;
	}
	
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
		this.studentId = studentId;
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
