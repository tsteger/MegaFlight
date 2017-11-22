package booking;

public class AirPlane {
int NumberOfSeats;
// private Boolean isInTheAirport = true;
private Boolean isInTheAirport = false;

public AirPlane(int numberOfSeats) {	
	NumberOfSeats = numberOfSeats;	
}

public int getNumberOfSeats() {
	return NumberOfSeats;
}

public Boolean getIsInTheAirport() {
	return isInTheAirport;
}

public void setIsInTheAirport(Boolean isInTheAirport) {
	this.isInTheAirport = isInTheAirport;
}

}
