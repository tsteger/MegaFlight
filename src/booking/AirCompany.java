package booking;

import java.util.ArrayList;
import java.util.List;

public class AirCompany {
	private List<AirPlane> airPlanes = new ArrayList<AirPlane>(); 	
	private BookingDesk bookingDesk = new BookingDesk();
	private StringBuilder logReport = new StringBuilder();
		
public BookingDesk getBookingDesk() {
	return bookingDesk;
}

public void AddPlane (AirPlane airPlane) {
	airPlanes.add(airPlane) ;
}

public List<AirPlane> getAirPlanes() {
	return airPlanes;
}
	
public String getLogReport() {
	return logReport.toString();
}

public void AddLog(String logPiece) {
	logReport.append(logPiece) ;
}

}
