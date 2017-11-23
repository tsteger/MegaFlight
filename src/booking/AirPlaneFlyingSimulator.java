package booking;

import java.time.LocalDateTime;
import java.util.TimerTask;

import UI.BookingUI;

public class AirPlaneFlyingSimulator extends TimerTask {
	private AirPlane plane;
	private int delay;
	private int counter;	
	public AirPlaneFlyingSimulator(AirPlane plane, int delay) {
		this.plane = plane;
		this.delay = delay;
	}

	@Override
	public void run() { 
		synchronized(plane) {
			
			while(MockAirCompany.flightSimulaterOnOff) {
				while(counter<=20) {			
					if(!MockAirCompany.flightSimulaterOnOff) {
						plane.addLog(String.format("\nTake-Off Aborted: %s", LocalDateTime.now().toString()));
						BookingUI.textArea_FlightSimulator.setText(plane.getLogReport());
						return;
					}
					toWait(delay);
					counter++;
				}
				//toWait(delay * 20);
				
				plane.setIsInTheAirport(false);			
				plane.addLog(String.format("\nTake-Off: %s", LocalDateTime.now().toString()));
				plane.addLog("\nFlying:");
				for(int i=1; i<=6;i++) { // 1 minute
					plane.addLog(" ... ");
					if(BookingUI.autologgerOnOff)
						BookingUI.textArea_FlightSimulator.setText(plane.getLogReport());
					toWait(10);        
				}

				plane.addLog(String.format("\nLanding: %s", LocalDateTime.now().toString()));
				plane.addLog(String.format("\nRefueled: %s", LocalDateTime.now().plusMinutes(3).toString()));
				if(BookingUI.autologgerOnOff)
					BookingUI.textArea_FlightSimulator.setText(plane.getLogReport());
				plane.setIsInTheAirport(true);
				toWait(20);
				plane.addLog(String.format("\nReturnd to gate: %s", LocalDateTime.now().plusMinutes(3).toString()));
				if(BookingUI.autologgerOnOff)
					BookingUI.textArea_FlightSimulator.setText(plane.getLogReport());
			}
		}
	}

	private void toWait(int time) {
		try {
			Thread.sleep(time * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
