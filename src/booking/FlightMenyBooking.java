package booking;

import java.util.Iterator;
import java.util.Map;

public class FlightMenyBooking {

	FlightMenu fmenu = new FlightMenu(FoodClass.FIRST);
	FlightMenu smenu = new FlightMenu(FoodClass.SECOND);

	public String foodMenuOrderItems(int customerid, String foodkey, int amount, int passangerClass) {
		return "Customer id " + customerid + " has ordered " + amount + " of " + foodkey + "for a total price of"
				+ getTotalPrice(foodkey, passangerClass, amount);
	}

	public String foodMenuUnOrderItems(int customerid, String foodkey, int amount, int passangerClass) {
		
		return "Customer id " + customerid + " has removed " + amount + " of " + foodkey + "for a total price of"
				+ getTotalPrice(foodkey, passangerClass, amount);
	}

	public String newCustomer(int customerid, String fname, String sname) {

		return "Hello new customer " + fname + " " + sname + "," + " your ID is " + customerid + ".";
	}

	public int getTotalPrice(String foodkey, int passangerClass, int amount) {

		int totalPrice = 0;

		if (passangerClass == 1) {
			Iterator it1 = fmenu.getMenu().entrySet().iterator();
			while (it1.hasNext()) {
				Map.Entry pair = (Map.Entry) it1.next();
				if (pair.getKey().equals(foodkey)) {
					totalPrice += (Integer) pair.getValue();
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
						totalPrice += (Integer) pair.getValue();
						it1.remove(); // avoids a ConcurrentModificationException
					}
				}

			}

		}

		return totalPrice*amount;

	}
}
