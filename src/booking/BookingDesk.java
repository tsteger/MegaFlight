package booking;

import java.util.ArrayList;
import java.util.List;

public class BookingDesk {
	//---- Flights thread ---------------------------------------
	FlightsInTheAirThread runable = new FlightsInTheAirThread();
	Thread th;// = new Thread(runable);
	
	//-----------------------------------------------------------
	private List<Flight> flights = new ArrayList<>();	
	private SeatPrices pricelist = new SeatPrices();
	
	int totalFlightCost;
	int totalCustomerCost;
	
	public BookingDesk() {		
		totalFlightCost=0;
		totalCustomerCost=0;
	}
		
	public List<Flight> getFlights() {
		return flights;
	}
	
	public void AddFlight (Flight flight) {
		flights.add(flight) ;
	}
	
	public void setPrices (int firstClassPrice, int economyClassPrice) {
		pricelist.setFirstClassTicketPrice(firstClassPrice);
		pricelist.setEconomyClassTicketPrice(economyClassPrice);
	}
		
	public int getTotalFlightCost() {
		return totalFlightCost;
	}
	public void resetTotalCustomerCost() {
		totalCustomerCost=0;		
	}

	public int getTotalCustomerCost() {
		return totalCustomerCost;
	}

	public String bookFlightAndSeats(int flightIndex, int seatClassIndex, int numberOfSeats) {

		String returnString = "";
		
		Flight flight = flights.get(flightIndex);		
		String  className = seatClassIndex==0 ? SeatClass.ECONOMY.toString() : SeatClass.FIRST.toString();

		
		Boolean isPlaneInAirport = isPlaneInAirportByFlight(flight) ;
		if(!isPlaneInAirport) {
			return "The plane is not in the airport. \nPlease try another flight.";	
		}
				
		Boolean isPossibleToBook = SeatsBooking.book(flight, seatClassIndex, numberOfSeats);				
		if(isPossibleToBook) {		
		int price = seatClassIndex==0 ? pricelist.getEconomyClassTicketPrice() : pricelist.getFirstClassTicketPrice();
		int total=numberOfSeats*price;
		totalFlightCost+=total;
		totalCustomerCost+=total;
		
		returnString = String.format(
				"\nBOOKED: "+ "\nFlight: "+ flight.getName()+"\nSeat(s): " + numberOfSeats +", %s" +"\nCost: "+ total +"\nTotal: " + totalCustomerCost,
			                      	className);	
		} else {
			int availableSeatsOfTheClass = seatClassIndex==0 ? flight.getNumberOfSeatsEconomyClassAvailable() : flight.getNumberOfSeatsFirstClassAvailable();
			returnString = String.format(
					       "There are only %d %s Class Seat(s) Available. \nYou are welcome to check available seat(s) in another class.",
					       availableSeatsOfTheClass, className);
		}
		
		return returnString;	
		}
	
	private Boolean isPlaneInAirportByFlight(Flight flight) {
	return flight.getAirplane().getIsInTheAirport();	
	}
		
	public String bookFoodMeny() {
		// TODO Auto-generated method stub
		
		return null;
	}

}