package booking;

import java.time.LocalDateTime;

public class AirPlane {
private int id;	

private static int numberOfPlanes = 0;

private String name; 	
private int numberOfSeats;
private Boolean isInTheAirport = true;

public AirPlane(String name, int numberOfSeats) {	
	++numberOfPlanes;
	id = numberOfPlanes;
	
	this.name = name;
	this.numberOfSeats = numberOfSeats;	
}

@Override
public String toString() {
	return "AirPlane [id=" + id + ", name=" + name + "]";
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

public String sendOff(){
	StringBuilder log = new StringBuilder(); 
	
	setIsInTheAirport(false);
	log.append("/n" + this.toString());
	log.append(String.format("/nTake-Off: %s", LocalDateTime.now().toString()));
	
	FlySimulator flySimulator = new FlySimulator();
	flySimulator.run();
	log.append(flySimulator.getLog());
	
	log.append(String.format("/nLanding: %s", LocalDateTime.now().toString()));
	log.append(String.format("/nRefueled: %s", LocalDateTime.now().plusMinutes(3).toString()));
	
	return log.toString();
}

}
