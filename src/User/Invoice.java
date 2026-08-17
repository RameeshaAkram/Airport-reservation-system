package User;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

import administrator.BusinessClass;
import administrator.FirstClass;
import administrator.Flights;
import ars.Filing;
import ars.FlightRunner;

public class Invoice implements Serializable{

	public static double totalBill;
	public String flightClass;
	public Passenger P;
	public String flightNumber;
	
	public Invoice(Passenger p, String c, Flights fN) {
		this.P = p;
		this.flightClass = c;
		this.flightNumber = fN.flightNumber;
		this.totalBill = ticketPrice(p);
	}
	public Invoice(){

	}
	
	public void invoice(ArrayList<Flights> flightList, int i, Passenger p, double ticketPrice) {

		System.out.println(p.getAge());
		System.out.println("\n--------------------I N V O I C E--------------------");
		System.out.println("Passenger Details: \n"+p.getDetails());
		System.out.println("Flight number: "+flightList.get(i).getFlightNumber());
		System.out.println("Plane number: "+flightList.get(i).getPlaneNumber());
		System.out.println("From: "+flightList.get(i).getStart());
		System.out.println("To: "+flightList.get(i).getEnd());
		System.out.println("Date: "+flightList.get(i).getDate());
		System.out.println("Time of Departure: "+flightList.get(i).getDeparture());
		System.out.println("Time of Arrival: "+flightList.get(i).getArrival());
		System.out.println("-----------------------------------------------------");
		System.out.println("Total: "+this.totalBill);
		System.out.println("-----------------------------------------------------\n");
	}

	public double ticketPrice(Passenger p){
		int ticketPrice = 10000;
		if(p.membership){
			ticketPrice -= 2000;
		}
		if(this.flightClass.equals("business")){
			ticketPrice += 5000;
		}
		return ticketPrice;
	}
}
	