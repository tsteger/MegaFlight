package booking;

import java.util.Iterator;
import java.util.Map;

public class FlightMenyBooking {

	FlightMenu fmenu = new FlightMenu(SeatClass.FIRST);
	FlightMenu smenu = new FlightMenu(SeatClass.ECONOMY);

	public String foodMenuOrderItems(int customerid, String foodkey, int amount, int passangerClass) {
		return "Customer id " + customerid + " has ordered " + amount + " of " + foodkey + ", your current total price is "
				+ getTotalPrice(foodkey, passangerClass, amount)+ " kr.\n";
	}

	public String foodMenuUnOrderItems(int customerid, String foodkey, int amount, int passangerClass) {
		
		return "Customer id " + customerid + " has removed " + amount + " of " + foodkey + ", your current total price is "
				+ getTotalPrice(foodkey, passangerClass, amount) + " kr.\n";
	}

	public String newCustomer(int customerid, String fname, String sname) {

		return "Hello new customer " + fname + " " + sname + ", " + " your ID is " + customerid + ".";
	}
		int totalPrice = 0;
		int menuPrice =  0;
	  
	public int getTotalPrice(String foodkey, int passangerClass, int amount) {

		

		if (passangerClass == 1) {
			Iterator it1 = fmenu.getMenu().entrySet().iterator();
			while (it1.hasNext()) {
				Map.Entry pair = (Map.Entry) it1.next();
				if (pair.getKey().equals(foodkey)) {
					menuPrice += (Integer) pair.getValue();
					it1.remove(); // avoids a ConcurrentModificationException
				}

			}
		}

		else {
			if (passangerClass == 0) {
				Iterator it1 = fmenu.getMenu().entrySet().iterator();
				while (it1.hasNext()) {
					Map.Entry pair = (Map.Entry) it1.next();
					if (pair.getKey().equals(foodkey)) {
						menuPrice += (Integer) pair.getValue();
						it1.remove(); // avoids a ConcurrentModificationException
					}
				}

			}

		}
		totalPrice += (menuPrice*amount);
		return totalPrice;

	}
}
