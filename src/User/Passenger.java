package User;

import java.io.Serializable;
import java.util.Scanner;

public class Passenger implements Serializable {

	public String fname;
	public String lname;
	public String phNumber;
	public String email;
	public String age;
	public Boolean membership;
	public char gender;
	
	public Passenger() {}
	
	public Passenger(String fname, String lname, String phNumber, String email, String age, String m1, String gender) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.phNumber = phNumber;
		this.email = email;
		this.age = age;
		this.membership = checkMembership(m1);
		this.gender = checkGender(gender);
	}

	private char checkGender(String g) {
		if(g.equals("M"))
			return 'M';
		else
			return 'F';
	}

	private Boolean checkMembership(String m) {
		if(m.equals("Y"))
			return true;
		else
			return false;
	}

	public Passenger(String fname, String lname) {
		this.lname = lname;
		this.fname = fname;
	}

	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getPhNumber() {
		return phNumber;
	}
	public void setPhNumber(String phNumber) {
		this.phNumber = phNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public boolean getMembership() {
		return membership;
	}
	public void setMembership(boolean membership) {
		this.membership = membership;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	
	public String getDetails() {
		return "First Name: "+this.fname+"\nLast Name: "+this.lname+"\nAge: "+this.age+"\nGender: "+this.gender+"\nEmail: "+this.email+"\nPhone Number: "+this.phNumber+"\nMembership Status: "+getMembership();
	}
}
