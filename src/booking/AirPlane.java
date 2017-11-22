package booking;

public class AirPlane {
private int id;	

private static int numberOfPlanes = 0;

private String name; 	
private int numberOfSeats;
private Boolean isInTheAirport = true;

private StringBuilder logReport = new StringBuilder();

public String getLogReport() {
	return logReport.toString();
}

public AirPlane(String name, int numberOfSeats) {	
	++numberOfPlanes;
	id = numberOfPlanes;
	
	this.name = name;
	this.numberOfSeats = numberOfSeats;	
	
	addLog("\n" + this.toString());
	addLog("\n=======================");
}

@Override
public String toString() {
	return "AirPlane: " + name + " [id= " + id + " ]";
}

public int getNumberOfSeats() {
	return numberOfSeats;
}

public Boolean getIsInTheAirport() {
	return isInTheAirport;
}

public void setIsInTheAirport(Boolean isInTheAirport) {
	 this.isInTheAirport = isInTheAirport;
}

public void addLog(String logPiece) {
	logReport.append(logPiece) ;
}

}
