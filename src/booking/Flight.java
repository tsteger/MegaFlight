package booking;

public class Flight {
     private String name; 
     private AirPlane airplane;
     private int numberOfSeatsFirstClass;     
     private int numberOfSeatsEconomyClass;
     
     private int numberOfSeatsFirstClassAvailable;     
     private int numberOfSeatsEconomyClassAvailable;
		
	public Flight(String name, AirPlane airplane, int numberOfSeatsFirstClass) {
		this.name = name;
		this.airplane = airplane;
		this.numberOfSeatsFirstClass = numberOfSeatsFirstClass;
		
		this.numberOfSeatsEconomyClass = airplane.getNumberOfSeats() - numberOfSeatsFirstClass;
		
	    numberOfSeatsFirstClassAvailable = numberOfSeatsFirstClass;     
	    numberOfSeatsEconomyClassAvailable = numberOfSeatsEconomyClass;
	}
	
	public String getName() {
		return name;
	}

	public AirPlane getAirplane() {
		return airplane;
	}

	public int getNumberOfSeatsFirstClass() {
		return numberOfSeatsFirstClass;
	}
	
	public int getNumberOfSeatsEconomyClass() {
		return numberOfSeatsEconomyClass;
	}
	
	public int getNumberOfSeatsFirstClassAvailable() {
		return numberOfSeatsFirstClassAvailable;
	}
	
	public int getNumberOfSeatsEconomyClassAvailable() {
		return numberOfSeatsEconomyClassAvailable;
	}
	
	public void bookFirstClassSeats(int numberOfSeats) {
		numberOfSeatsFirstClassAvailable = 
				numberOfSeatsFirstClassAvailable > numberOfSeats ? 
						numberOfSeatsFirstClassAvailable - numberOfSeats :
						0;	
	}

	public void bookEconomyClassSeats(int numberOfSeats) {	
		numberOfSeatsEconomyClassAvailable = 
				numberOfSeatsEconomyClassAvailable > numberOfSeats ? 
						numberOfSeatsEconomyClassAvailable - numberOfSeats :
						0;	
	}
	
}
