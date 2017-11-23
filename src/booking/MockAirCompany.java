package booking;

import java.util.Iterator;
import java.util.List;

public class MockAirCompany {

	private AirCompany airCompany =  new AirCompany();
	
	public MockAirCompany(){  	
		airCompany.AddPlane(new AirPlane("Boeing 747", 10)); 
		airCompany.AddPlane(new AirPlane("Boeing 777", 10)); 
		airCompany.AddPlane(new AirPlane("Boeing 800", 10)); 
		
		List<AirPlane> planes = airCompany.getAirPlanes();
		
		BookingDesk bookingDesk = airCompany.getBookingDesk();

		//Flights
		bookingDesk.AddFlight(new Flight("ARN - GOT MegaFlight 1440", planes.get(0), 5));
		bookingDesk.AddFlight(new Flight("ARN - GOT MegaFlight 1450", planes.get(1), 5)); 
		bookingDesk.AddFlight(new Flight("ARN - GOT MegaFlight 1460", planes.get(2), 5)); 
		
		//Prices		
		bookingDesk.setPrices(20000, 5000); 
		
		//Simulator
		PlanesDispatcherSimulator(planes);
	}
	
	public AirCompany Get(){ 
		return airCompany;
     }
	
	public void PlanesDispatcherSimulator(List<AirPlane> planes) {			
		for (int i = 0; i<planes.size(); i++) {
		sendOff(planes.get(i), i);
		}
	}
	
	public static void sendOff(AirPlane plane, int delay){			
		if(!plane.getIsInTheAirport()) {	
			return;	
		}
		
		AirPlaneFlyingSimulator flySimulator = new AirPlaneFlyingSimulator(plane, delay);
		Thread thr = new Thread(flySimulator);
		thr.start();
	}
}
