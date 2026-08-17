package administrator;

import java.io.Serializable;

public class Crew implements Serializable {

	public String fname;
	public String lname;
	public String age;
	public String phNum;
	public String email;
	public char gender;
	
	public Crew() {} 
	
	public Crew( String fname, String lname, String age, String phNum, String email, char gender) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.age = age;
		this.phNum = phNum;
		this.email = email;
		this.gender = gender;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getPhNum() {
		return phNum;
	}

	public void setPhNum(String phNum) {
		this.phNum = phNum;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
