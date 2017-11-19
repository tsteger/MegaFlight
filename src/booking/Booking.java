package booking;

import java.util.ArrayList;
import java.util.List;


public class Booking {
	
	public List<Flights> flights = new ArrayList<>();
	private SeatPrices pricelist = new SeatPrices();
	int totalSeatPrice;
	int totalCustomerPrice;
	public Booking() {
		// The Flights
		flights.add(new Flights("Boing 740", 5,5));
		flights.add(new Flights("AirBuss 320", 5,5));
		flights.add(new Flights("Aroflot 140", 5,5));
		pricelist.setFirstClassTicketPrice(20000);
		pricelist.setSecoundClassTicketPrice(5000);
		totalSeatPrice=0;
		totalCustomerPrice=0;
	}
	
	public boolean checkIfFlightIsAvailable() {
		// TODO Auto-generated method stub
		// Multi flights in the air reports back if availibels
		// Multi tread assagnment
		return true;
	}
	public int getTotalFlightCost() {
		return totalSeatPrice;
	}
	public void resetCustomerPrice() {
		totalCustomerPrice=0;
		
	}
	public String bookFlightAndSets(int flightIndex, int passangerClassIndex, int numberOfTickets) {
		System.out.println("Flight: "+flightIndex+" Class: "+passangerClassIndex+" Tickets: "+numberOfTickets);
		int customerPrice=0;	
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
				customerPrice=numberOfTickets*pricelist.getSecoundClassTicketPrice(); // Change to = if only 1 bocking per customer
				totalSeatPrice+=customerPrice;
				totalCustomerPrice+=customerPrice;
				return "Boking Flight : "+ flights.get(flightIndex).getFlightType()+"\nSecond Class Seats Booked: "
						+numberOfTickets+"\nFlight Cost: "+customerPrice+"\nTotal Price : "+totalCustomerPrice;
			}
			else {
				return "There ar only "+freeSecondClassSeats+" SecondClass Tickets Availibel";
			}
		}
		else if (passangerClassIndex==1){
			if (freeFirstClassSeats >= numberOfTickets ){
				// First class passangers
				flights.get(flightIndex).setFirstClassSeats(freeFirstClassSeats-numberOfTickets);
				customerPrice=numberOfTickets*pricelist.getFirstClassTicketPrice();
				totalSeatPrice+=customerPrice;
				totalCustomerPrice+=customerPrice;
				return "Boking Flight : "+ flights.get(flightIndex).getFlightType()+"\nFirst Class Seats Booked: "
						+numberOfTickets+"\nFlight Cost: "+customerPrice+"\nTotal Price : "+totalCustomerPrice;
			}
			else {
				return "There ar only "+freeFirstClassSeats+" FirstClass Tickets Availibel";
			}
		}
		else {
			return "this is no passanger class";
		}
	}

	public String bookFoodMeny() {
		// TODO Auto-generated method stub
		
		return null;
	}

	
	

	

	

}
