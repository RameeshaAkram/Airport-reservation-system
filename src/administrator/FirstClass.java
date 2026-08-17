package administrator;

import extras.Date;
import extras.Time;

public class FirstClass extends Flights {

	public double ticketPrice = 20000;
	
	public FirstClass() {
		super();
	}
	
	public FirstClass(String flightNumber, String planeNumber, Date date, Time departure, Time arrival, String start,
			String end, int seats, double ticketPrice) {
		super(flightNumber, planeNumber, date, departure, arrival, start, end, seats);
		this.ticketPrice = ticketPrice;
	}
	public double getTicketPrice() {
		return ticketPrice;
	}
	public void setTicketPrice(double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	
}
