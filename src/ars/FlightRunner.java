package ars;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import administrator.Flights;
import extras.Date;
import extras.Time;


public class FlightRunner {

	public static void main(String[] args) {
		Flights[] flights = new Flights[] {
				new Flights("22", "PK404", new Date("02", "06", "2021"), new Time("23", "30"), new Time("00", "00"), "Karachi", "Islamabad", 60),
				new Flights("23", "PK405", new Date("03", "07", "2021"), new Time("03", "00"), new Time("04", "00"), "Karachi", "Quetta", 52),
				new Flights("24", "PK406", new Date("04", "05", "2021"), new Time("08", "00"), new Time("09", "00"), "Karachi", "Peshawar", 51),
				new Flights("25", "PK407", new Date("07", "04", "2021"), new Time("21", "30"), new Time("22", "00"), "Karachi", "Lahore", 30),
				new Flights("26", "PK408", new Date("23", "06", "2021"), new Time("20", "00"), new Time("21", "00"), "Karachi", "Multan", 0),
				new Flights("12", "PK409", new Date("02", "06", "2021"), new Time("19", "00"), new Time("20", "00"), "Karachi", "Islamabad", 20),
				new Flights("13", "PK404", new Date("30", "06", "2021"), new Time("18", "00"), new Time("19", "00"), "Islamabad", "Karachi", 30),
				new Flights("45", "PK405", new Date("12", "06", "2021"), new Time("13", "00"), new Time("14", "00"), "Islamabad", "Multan", 24),
				new Flights("56", "PK406", new Date("07", "04", "2021"), new Time("03", "30"), new Time("04", "00"), "Islamabad", "Lahore", 31),
				new Flights("67", "PK407", new Date("08", "05", "2021"), new Time("01", "00"), new Time("02", "00"), "Islamabad", "Peshawar", 20),
				new Flights("66", "PK408", new Date("09", "07", "2021"), new Time("00", "00"), new Time("02", "00"), "Islamabad", "Quetta", 0),
				new Flights("65", "PK409", new Date("08", "06", "2021"), new Time("06", "00"), new Time("08", "00"), "Lahore", "Karachi", 80),
				new Flights("78", "PK404", new Date("03", "06", "2021"), new Time("08", "30"), new Time("09", "00"), "Lahore", "Islamabad", 90),
				new Flights("79", "PK405", new Date("02", "08", "2021"), new Time("09", "00"), new Time("10", "00"), "Lahore", "Multan", 100),
				new Flights("33", "PK406", new Date("05", "06", "2021"), new Time("10", "00"), new Time("11", "00"), "Lahore", "Quetta", 10),
				new Flights("34", "PK407", new Date("04", "05", "2021"), new Time("12", "00"), new Time("13", "00"), "Lahore", "Peshawar", 100),
				new Flights("35", "PK408", new Date("25", "04", "2021"), new Time("15", "00"), new Time("16", "00"), "Peshawar", "Karachi", 100),
				new Flights("36", "PK409", new Date("27", "04", "2021"), new Time("16", "00"), new Time("17", "00"), "Peshawar", "Multan", 50),
				new Flights("37", "PK404", new Date("15", "04", "2021"), new Time("15", "30"), new Time("17", "00"), "Peshawar", "Islamabad", 45),
				new Flights("38", "PK405", new Date("17", "05", "2021"), new Time("12", "00"), new Time("14", "00"), "Peshawar", "Lahore", 99),
				new Flights("39", "PK406", new Date("12", "06", "2021"), new Time("14", "00"), new Time("15", "00"), "Peshawar", "Quetta", 89),
				new Flights("89", "PK407", new Date("22", "05", "2021"), new Time("00", "00"), new Time("02", "00"), "Quetta", "Karachi", 45),
				new Flights("90", "PK408", new Date("23", "05", "2021"), new Time("04", "30"), new Time("07", "00"), "Quetta", "Islamabad", 33),
				new Flights("91", "PK409", new Date("24", "05", "2021"), new Time("06", "00"), new Time("07", "00"), "Quetta", "Lahore", 22),
				new Flights("92", "PK404", new Date("17", "04", "2021"), new Time("08", "00"), new Time("09", "00"), "Quetta", "Multan", 100),
				new Flights("44", "PK405", new Date("18", "07", "2021"), new Time("08", "00"), new Time("09", "00"), "Quetta", "Peshawar", 90),
				new Flights("45", "PK406", new Date("19", "07", "2021"), new Time("02", "30"), new Time("03", "00"), "Quetta", "Karachi", 22),
				new Flights("46", "PK407", new Date("13", "07", "2021"), new Time("03", "00"), new Time("06", "00"), "Multan", "Karachi", 30),
				new Flights("47", "PK408", new Date("12", "08", "2021"), new Time("20", "00"), new Time("21", "00"), "Multan", "Islamabad", 60),
				new Flights("48", "PK409", new Date("20", "08", "2021"), new Time("23", "30"), new Time("00", "00"), "Multan", "Quetta", 80),
				new Flights("49", "PK404", new Date("10", "05", "2021"), new Time("21", "00"), new Time("00", "00"), "Multan", "Lahore", 26),
				new Flights("50", "PK405", new Date("29", "04", "2021"), new Time("22", "00"), new Time("00", "00"), "Multan", "Peshawar", 87),
		};
		
		ArrayList<Flights> flightsList = new ArrayList<Flights>();
		
		for(int i=0; i < flights.length; i++)
		{
			flightsList.add(flights[i]);
		}

		Filing f = new Filing();
		f.writeObjectToFile(flightsList);
	}
}
