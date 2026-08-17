package administrator;

import java.util.ArrayList;
import java.util.Random;

import ars.Filing;
import ars.FlightRunner;

public class Pilots extends Crew {
	
	public int flyingHrs;
	
	ArrayList<Flights> flightList = Filing.readObjectFromFile();

	Random rand = new Random();
	int upperbound = flightList.size();
	
	public Pilots(String fname, String lname, String age, int flyingHrs, String phNum, String email, char gender) {
		super(fname, lname, age, phNum, email, gender);
		this.flyingHrs = flyingHrs;
	}
	
	
	public double getFlyingHrs() {
		return flyingHrs;
	}
	public void setFlyingHrs(int flyingHrs) {
		this.flyingHrs = flyingHrs;
	}
	
	public void Display() {
		System.out.println("____________________________________________");
		System.out.println("First Name: "+super.getFname());
		System.out.println("Last Name: "+super.getLname());
		System.out.println("Age: "+super.getAge());
		System.out.println("Phone Number: "+super.getPhNum());
		System.out.println("Email Address: "+super.getEmail());
		System.out.println("Flying Hours: "+getFlyingHrs());
		System.out.println("Flight Information:");
		int flightInfo = rand.nextInt(upperbound);
		System.out.println("From: "+flightList.get(flightInfo).getStart()+"   to: " + flightList.get(flightInfo).getEnd() );
		System.out.println("Date: "+flightList.get(flightInfo).getDate()+"   Time " + flightList.get(flightInfo).getDeparture() );

		System.out.println("____________________________________________");
		
	}
	
}
