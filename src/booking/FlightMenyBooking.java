package booking;

import java.util.Iterator;
import java.util.Map;


public class FlightMenyBooking {

	private int fPrice;
	private FlightMenu fmenu = new FlightMenu(FoodClass.FIRST);
	private FlightMenu smenu = new FlightMenu(FoodClass.SECOND);

	public String foodMenuOrderItems(int customerid, String foodkey, int amount) {

		int totalPrice = 0;

		Iterator it1 = fmenu.getMenu().entrySet().iterator();
		while (it1.hasNext()) {
			Map.Entry pair = (Map.Entry) it1.next();
			if (pair.getKey().equals(foodkey)) {
				totalPrice += (Integer) pair.getKey();
				it1.remove(); // avoids a ConcurrentModificationException
			}
		}


		return "Customer " + customerid + " have ordered " + amount + " " + foodkey + " " + "TotalPrice is " + totalPrice;

	}

	public String foodMenuUnOrderItems(int customerid, String foodkey, int amount) {

		return "Customer " + customerid + " have removed " + amount + " " + foodkey + "from the order.";
	}

	public String newCustomer(int customerid, String fname, String sname) {

		return "Hello new customer " + fname + " " + sname + "," + " your ID is " + customerid + ".";
	}

}
