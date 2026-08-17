package User;

import java.io.Serializable;
import java.util.ArrayList;

import administrator.Flights;
import ars.Filing;
import ars.FlightRunner;

public class AvailableFlights implements Serializable {


	ArrayList<Flights> flights = Filing.readObjectFromFile();
	
	public void displayAllFlights() {
		System.out.println("Available flights: ");
		for(Flights flight: flights) {
			if(flight.seats < 100) {
				System.out.println(flight.getFlights());
			}
		}
		System.out.println("Not available flights: ");
		for(Flights flight: flights) {
			if(flight.seats == 100) {
				System.out.println(flight.getFlights());
			}
		}
	}
	
}
