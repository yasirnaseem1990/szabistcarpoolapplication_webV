package domain;

import java.sql.Blob;

public class User implements java.io.Serializable{
	private Long userid;
	private String name;
	private String email;
	private String cnicno;
	private String mobileno;
	private String password;
	private String universityregno;
	private String semester;
	private String department;
	private String rating;
//	private int fkRoleId;
	private String verificationKey;
	private Long verificationStatu;
	private Blob userpicture;
	
	public Long getUserid() {
		return userid;
	}
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCnicno() {
		return cnicno;
	}
	public void setCnicno(String cnicno) {
		this.cnicno = cnicno;
	}
	public String getMobileno() {
		return mobileno;
	}
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUniversityregno() {
		return universityregno;
	}
	public void setUniversityregno(String universityregno) {
		this.universityregno = universityregno;
	}
	public String getSemester() {
		return semester;
	}
	public void setSemester(String semester) {
		this.semester = semester;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getVerificationKey() {
		return verificationKey;
	}
	public void setVerificationKey(String verificationKey) {
		this.verificationKey = verificationKey;
	}
	public Long getVerificationStatu() {
		return verificationStatu;
	}
	public void setVerificationStatu(Long verificationStatu) {
		this.verificationStatu = verificationStatu;
	}
	public Blob getUserpicture() {
		return userpicture;
	}
	public void setUserpicture(Blob userpicture) {
		this.userpicture = userpicture;
	}

}