package booking;

import java.util.ArrayList;
import java.util.List;


public class Booking {
	
	public List<Flights> flights = new ArrayList<>();
	private SeatPrices pricelist = new SeatPrices();
	int totalSeatPrice=0;
	public Booking() {
		// The Flights
		flights.add(new Flights("Boing 740", 5,5));
		flights.add(new Flights("AirBuss 320", 5,5));
		flights.add(new Flights("Aroflot 140", 5,5));
		pricelist.setFirstClassTicketPrice(20000);
		pricelist.setSecoundClassTicketPrice(5000);

	}
	
	public boolean checkIfFlightIsAvailable() {
		// TODO Auto-generated method stub
		// Multi flights in the air reports back if availibels
		// Multi tread assagnment
		return true;
	}

	public String bookFlightAndSets(int flightIndex, int passangerClassIndex, int numberOfTickets) {
		System.out.println("Flight: "+flightIndex+" Class: "+passangerClassIndex+" Tickets: "+numberOfTickets);
			
		if(!checkIfFlightIsAvailable())
		{
			return "This flight is not on the ground"; // Up gift 2 med flights in the air
		
		}
		
		int freeFirstClassSeats = flights.get(flightIndex).getFirstClassSeats();
		int freeSecondClassSeats = flights.get(flightIndex).getSecondClassSeats();
		System.out.println("F: "+freeFirstClassSeats+" S: "+freeSecondClassSeats);
		if(passangerClassIndex==0) {
			 // Second Class passangers
			if(freeSecondClassSeats >= numberOfTickets ) {
				flights.get(flightIndex).setSecondClassSeats(freeSecondClassSeats-numberOfTickets);
				totalSeatPrice+=numberOfTickets*pricelist.getSecoundClassTicketPrice();
				return "Boking Flight : "+ flights.get(flightIndex).getFlightType()+"\nSecond Class Seats Booked: "+numberOfTickets+"\nTotal Flight Cost: "+totalSeatPrice;
			}
			else {
				return "There ar only "+freeSecondClassSeats+" SecondClass Tickets Availibel";
			}
		}
		else {
			if (freeFirstClassSeats >= numberOfTickets ){
				// First class passangers
				flights.get(flightIndex).setSecondClassSeats(freeFirstClassSeats-numberOfTickets);
				return "Boking Flight : "+ flights.get(flightIndex).getFlightType()+" First Class Seats Booked: "+numberOfTickets;
			}
			else {
				return "There ar only "+freeFirstClassSeats+" FirstClass Tickets Availibel";
			}
		}
	}

	public String bookFoodMeny() {
		// TODO Auto-generated method stub
		
		return null;
	}

	
	

	

	

}
