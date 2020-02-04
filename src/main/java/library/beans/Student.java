package library.beans;

import java.util.Date;

public class Student {

	private Long studentId;
	private String firstName;
	private String lastName;
	private String studentAddress;
	private String studentClass;
	private String mobile;
	private String email;
	private Date dateCreated;

	public Student(Long studentid, String fname,String lname, String studentclass,
			String studentadd, String studentph, String email) {
		this.studentId = studentid;
		this.firstName = fname;
		this.studentClass = studentclass;
		this.studentAddress = studentadd;
		this.mobile = studentph;
		this.email = email;
		
	}

	

	public Student() {
		// TODO Auto-generated constructor stub
	}



	public Long getStudentId() {
		return studentId;
	}



	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}



	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		if(firstName==null){
			firstName="";
		}
		this.firstName = firstName;
	}

	public String getLastName() {
		if(lastName==null){
			lastName="";
		}
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getStudentAddress() {
		return studentAddress;
	}

	public void setStudentAddress(String studentAddress) {
		this.studentAddress = studentAddress;
	}

	public String getStudentClass() {
		return studentClass;
	}

	public void setStudentClass(String studentClass) {
		this.studentClass = studentClass;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}



	public Date getDateCreated() {
		return dateCreated;
	}



	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}



	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", studentAddress="
				+ studentAddress + ", studentClass=" + studentClass
				+ ", mobile=" + mobile + ", email=" + email + ", dateCreated="
				+ dateCreated + "]";
	}
	
}
