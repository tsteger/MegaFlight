package booking;

public class TravelTickets {
	private String flightType;
	private int firstClassSeats;
	private int secondClassSeats;
	
	public TravelTickets(String flightType, int firstClassSeats, int secondClassSeats) {
		super();
		this.flightType = flightType;
		this.firstClassSeats = firstClassSeats;
		this.secondClassSeats = secondClassSeats;
	}
	public String getFlightType() {
		return flightType;
	}
	public void setFlightType(String flightType) {
		this.flightType = flightType;
	}
	public int getFirstClassSeats() {
		return firstClassSeats;
	}
	public void setFirstClassSeats(int firstClassSeats) {
		this.firstClassSeats = firstClassSeats;
	}
	public int getSecondClassSeats() {
		return secondClassSeats;
	}
	public void setSecondClassSeats(int secondClassSeats) {
		this.secondClassSeats = secondClassSeats;
	}
	
	
	
}
