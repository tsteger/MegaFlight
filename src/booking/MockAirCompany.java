package booking;

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
		PlaneDispatcherSimulator(planes);
	}
	
	public AirCompany Get(){ 
		return airCompany;
     }
	
	public void PlaneDispatcherSimulator(List<AirPlane> planes) {	
		sendOff(planes.get(0));
		sendOff(planes.get(0));
	}
	
	public static void sendOff(AirPlane plane){			
		if(!plane.getIsInTheAirport()) {	
			return;	
		}
		
		FlySimulator flySimulator = new FlySimulator(plane);
		Thread thr = new Thread(flySimulator);
		thr.start();
	}
}
