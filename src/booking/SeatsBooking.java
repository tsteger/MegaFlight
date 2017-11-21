package booking;

public class SeatsBooking {
	
	public static Boolean book(Flight flight, int flightClassIndex, int numberOfSeats) {
	Boolean isDone = false; 	
	int availableSeats = flightClassIndex==0 ? flight.getNumberOfSeatsEconomyClassAvailable() : flight.getNumberOfSeatsFirstClassAvailable();		
	if(availableSeats >= numberOfSeats) {			
		bookSeatsOfTheClass(flight, flightClassIndex, numberOfSeats);
		isDone = true; 
	}		
		return isDone;
	}
	
	private static void bookSeatsOfTheClass(Flight flight, int flightClassIndex, int numberOfSeats){
		if (flightClassIndex==0) {
			flight.bookEconomyClassSeats(numberOfSeats);
		} else {
			flight.bookFirstClassSeats(numberOfSeats);
		} 
	}
}
