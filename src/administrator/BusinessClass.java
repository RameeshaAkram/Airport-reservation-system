package administrator;

import User.Passenger;
import extras.Date;
import extras.Time;

public class BusinessClass extends Flights {

	public double ticketPrice = 10000;
	
	public BusinessClass() {
		super();
		this.ticketPrice = 10000;
	}
	
	
//	public BusinessClass(String fname, String lname, String phNumber, String email, int age, boolean membership, char gender, double ticketPrice) {
//		super(fname, lname,  phNumber, email, age, membership, gender);
//		this.ticketPrice = ticketPrice;
//	}
	public BusinessClass(String flightNumber, String planeNumber, Date date, Time departure, Time arrival, String start,
			String end, int seats, double ticketPrice) {
		super(flightNumber, planeNumber, date, departure, arrival, start, end, seats);
		this.ticketPrice = ticketPrice;
	}
	
	
	public double getTicketPrice() {
		return this.ticketPrice;
	}
	public void setTicketPrice(double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}



}
