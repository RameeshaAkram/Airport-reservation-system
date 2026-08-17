package administrator;

import java.util.ArrayList;
import java.util.Random;

import ars.Filing;
import ars.FlightRunner;

public class AirHostess extends Crew {
	ArrayList<Flights> flightList = Filing.readObjectFromFile();

	Random rand = new Random();
	int upperbound = flightList.size();
	
	public AirHostess(String fname, String lname, String age, String phNum, String email, char gender) {
		super(fname, lname, age, phNum, email, gender);
	}
	
	public void Display() {
		System.out.println("____________________________________________");
		System.out.println("First Name: "+super.getFname());
		System.out.println("Last Name: "+super.getLname());
		System.out.println("Age: "+super.getAge());
		System.out.println("Phone Number: "+super.getPhNum());
		System.out.println("Email Address: "+super.getEmail());
		System.out.println("Flight Information:");
		int flightInfo = rand.nextInt(upperbound);
		System.out.println("From: "+flightList.get(flightInfo).Start+"   to: " + flightList.get(flightInfo).End );
		System.out.println("Date: "+flightList.get(flightInfo).date+"   Time " + flightList.get(flightInfo).departure);
		System.out.println("____________________________________________");
		
	}
	
}
