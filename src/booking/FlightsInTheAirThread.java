package booking;

public class FlightsInTheAirThread implements Runnable {
	
	private int counter=0; 
	
	@Override
	public void run() {
		System.out.println("Thread start");
		while(true) {
			
			try {
				Thread.sleep(5000);
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(counter>=5) {
					
				break;
			}
			counter++;
			
		}
		System.out.println("Thread end");

	}
	public int getThreadCounter(){
		return counter;
	}
	

}
