package booking;

import java.util.TimerTask;

public class FlySimulator extends TimerTask {
	StringBuilder log = new StringBuilder(); 
	
	@Override
    public void run() { 
		log.append("/nFlying:");
		for(int i=1; i<=6;i++) { // 1 minutes
        toFly(10);
        log.append(" ... ");
        }
    }

    private void toFly(int time) {
        try {
            //assuming it takes 10 secs to complete the task
            Thread.sleep(time * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

	public String getLog() {
		return log.toString();
	}  
}
