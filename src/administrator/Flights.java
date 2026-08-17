package administrator;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import User.Passenger;
import extras.Date;
import extras.Time;

public class Flights implements Serializable {

	Passenger p;
	public String flightNumber;
	public String planeNumber;
	public Date date;
	public Time departure;
	public Time arrival;
	public String Start; // Flight start city
	public String End; // Flight end city
	public int seats;
	
	public Flights() {}
	public Flights(Passenger p, String flightNumber, String planeNumber, Date date, Time departure, Time arrival, String start,
			String end, int seats) {
		this.p = p;
		this.flightNumber = flightNumber;
		this.planeNumber = planeNumber;
		this.date = date;
		this.departure = departure;
		this.arrival = arrival;
		this.Start = start;
		this.End = end;
		this.seats = seats;
	}
	
	public Flights(String flightNumber, String planeNumber, Date date, Time departure, Time arrival, String start,
			String end, int seats) {
		this.flightNumber = flightNumber;
		this.planeNumber = planeNumber;
		this.date = date;
		this.departure = departure;
		this.arrival = arrival;
		this.Start = start;
		this.End = end;
		this.seats = seats;
	}

	public void setP(Passenger p) {
		this.p = p;
	}
	
	public Passenger getP() {
		return this.p;
	}
	
	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	
	public String getPlaneNumber() {
		return planeNumber;
	}
	public void setPlaneNumber(String planeNumber) {
		this.planeNumber = planeNumber;
	}
	public String getDate() { return date.toString(); }
	public void setDate(Date date) {
		this.date = date;
	}
	public String getDeparture() {
		return departure.toString();
	}
	public void setDeparture(Time departure) {
		this.departure = departure;
	}
	public String getArrival() {
		return arrival.toString();
	}
	public void setArrival(Time arrival) {
		this.arrival = arrival;
	}
	public String getStart() { return this.Start; }
	public void setStart(String start) {
		this.Start = start;
	}
	public String getEnd() {
		return this.End;
	}
	public void setEnd(String end) {
		this.End = end;
	}
	public int getSeats() {
		return this.seats;
	}
	public void setSeats(int seats) {
		this.seats = seats;
	}
	
	public String getFlights() {
		return this.flightNumber+" | "+this.planeNumber+" | "+this.date+" | "+this.departure+" | "+
		this.arrival+" | "+this.Start+" | "+this.End+" | "+this.seats;
	}

	public static boolean check_time(String t){
		if(t.length() == 5){
			return true;
		}
		return false;
	}
	public static boolean check_date(String date){
		if(date.length() == 10){
			return true;
		}
		return false;
	}



	public boolean checkFlights(Flights f){
		if(check_date(f.date.toString()) && check_time(f.departure.toString()) && check_time(f.arrival.toString())){
			return true;
		}
		return false;
	}


}
