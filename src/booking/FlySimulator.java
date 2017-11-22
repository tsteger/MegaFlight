package booking;

import java.time.LocalDateTime;
import java.util.TimerTask;

public class FlySimulator extends TimerTask {
	private AirPlane plane;
		
	public FlySimulator(AirPlane plane) {
		this.plane = plane;
	}

	@Override
    public void run() { 
		synchronized(plane) {
		plane.setIsInTheAirport(false);			
		plane.addLog(String.format("\nTake-Off: %s", LocalDateTime.now().toString()));
				
		plane.addLog("\nFlying:");
		for(int i=1; i<=6;i++) { // 1 minute
			plane.addLog(" ... ");
			toFly(10);        
		}
		
		plane.addLog(String.format("\nLanding: %s", LocalDateTime.now().toString()));
		plane.addLog(String.format("\nRefueled: %s", LocalDateTime.now().plusMinutes(3).toString()));
		plane.setIsInTheAirport(true);	
		}
    }

    private void toFly(int time) {
        try {
        	Thread.sleep(time * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
