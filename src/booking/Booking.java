package booking;

import java.util.ArrayList;
import java.util.List;

public class Booking {
	//---- Flights thread ---------------------------------------
	FlightsInTheAirThread runable = new FlightsInTheAirThread();
	Thread th;// = new Thread(runable);
	
	//-----------------------------------------------------------
	public List<Flight> flights = new ArrayList<>();
	private SeatPrices pricelist = new SeatPrices();
	int totalSeatPrice;
	int totalCustomerPrice;
	boolean airplaneIsInTheAir;
	
	public Booking() {
		// The Flights
		flights.add(new Flight("ARN - GOT MegaFlight 1440", new AirPlane(10), 5));
		flights.add(new Flight("ARN - GOT MegaFlight 1450", new AirPlane(10), 5));
		flights.add(new Flight("ARN - GOT MegaFlight 1460", new AirPlane(10), 5));
		
		pricelist.setFirstClassTicketPrice(20000);
		pricelist.setSecoundClassTicketPrice(5000);
		
		totalSeatPrice=0;
		totalCustomerPrice=0;
		airplaneIsInTheAir=false;
	}
	
	
	public boolean checkIfFlightIsAvailable() {
		// TODO Auto-generated method stub
		// Multi-flights in the air reports back if available
		// Multi-thread assignment
		return airplaneIsInTheAir;
	}
	public int getTotalFlightCost() {
		return totalSeatPrice;
	}
	public void resetCustomerPrice() {
		totalCustomerPrice=0;
		
	}
			
	public String bookFlightAndSeats(int flightIndex, int passangerClassIndex, int numberOfTickets) {
		Flight flight = flights.get(flightIndex);
		
		System.out.println("Flight: "+flightIndex+" Class: "+passangerClassIndex+" Tickets: "+numberOfTickets);
		
		int customerPrice=0;
				
/*
		if(freeFirstClassSeats == 0 && freeSecondClassSeats == 0) {			
			flightIsInTheAir=true;
			th =  new Thread(runable);
			//runable.flightNumber = flightIndex;
			if(runable.getThreadCounter()>=5) {
				System.out.println(runable.getThreadCounter());
				flightIsInTheAir=false;
			//	flights.get(flightIndex).setFirstClassSeats(5);				//?
			//	flights.get(flightIndex).setSecondClassSeats(5);
			}
			else
				th.start();
		}
*/
	/*	
		if(checkIfFlightIsAvailable())
		{
			return "This flight is not on the ground"; // Up gift 2 med flights in the air
		
		}
		*/

		int availableSeatsFirstClass = flight.getNumberOfSeatsFirstClass();
		int availableSeatsEconomyClass = flight.getNumberOfSeatsEconomyClass();		
		System.out.println("F: "+availableSeatsFirstClass+" E: "+availableSeatsEconomyClass);
		
		if(passangerClassIndex==0) {   //Economy Class passengers
			
			if(availableSeatsEconomyClass >= numberOfTickets ) {	
				
				flight.bookEconomyClassSeats(numberOfTickets);
				availableSeatsEconomyClass = flight.getNumberOfSeatsEconomyClassAvailable();
				
				customerPrice=numberOfTickets*pricelist.getSecoundClassTicketPrice(); // Change to = if only 1 booking per customer
				totalSeatPrice+=customerPrice;
				totalCustomerPrice+=customerPrice;
				
				return "Boking Flight : "+ flight.getName()+"\nEconomy Class Seats Booked: "
						+numberOfTickets+"\nFlight Cost: "+customerPrice+"\nTotal Price : "+totalCustomerPrice;
			}
			else {
				return "There are only "+ availableSeatsEconomyClass +" Economy Class Tickets Available";
			}
		}
		else if (passangerClassIndex==1){    // First class passengers
			if (availableSeatsFirstClass >= numberOfTickets ){
				
				flight.bookFirstClassSeats(numberOfTickets);
				availableSeatsFirstClass = flight.getNumberOfSeatsFirstClassAvailable(); 
				
				customerPrice=numberOfTickets*pricelist.getFirstClassTicketPrice();
				totalSeatPrice+=customerPrice;
				totalCustomerPrice+=customerPrice;
				return "Boking Flight : "+ flight.getName()+"\nFirst Class Seats Booked: "
						+numberOfTickets+"\nFlight Cost: "+customerPrice+"\nTotal Price : "+totalCustomerPrice;
			}
			else {
				return "There are only "+availableSeatsFirstClass+" First Class Tickets Available";
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
