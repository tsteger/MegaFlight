package booking;

import java.util.ArrayList;
import java.util.List;

public class AirCompany {
	private List<AirPlane> airPlanes = new ArrayList<AirPlane>(); 	
	private BookingDesk bookingDesk = new BookingDesk();
	
	double totalIncome = 0.0;
	
public double getTotalIncome(){
		double totalIncomeTickets = bookingDesk.getTotalIncomeTickets();				
		double totalIncomeFood = bookingDesk.getMenu().getTotalIncomeFood();
		
		return totalIncomeTickets+totalIncomeFood;
	}
	
public double getTotalProfit(){	
	return getTotalIncome() * 0.3 ;
}
		
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
	StringBuilder logReport = new StringBuilder();
	
	for(AirPlane plane : airPlanes){
		logReport.append(plane.getLogReport()) ;
		logReport.append("\n");
	} 
	
	return logReport.toString();	
}

}
