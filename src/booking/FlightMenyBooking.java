package booking;

import java.util.Iterator;
import java.util.Map;

public class FlightMenyBooking {

	FlightMenu fmenu = new FlightMenu(SeatClass.FIRST);
	FlightMenu smenu = new FlightMenu(SeatClass.ECONOMY);
	int totalCompanyRevenue= 0 ;
	int totalCustomerPrice = 0;
	int menuPrice =  0;
	
	public int getTotalCompanyEarnedAmount() {
		return totalCompanyRevenue;
	}
	public int GettotalCustomerPrice() {
		return totalCustomerPrice;
	}
	public String foodMenuOrderItems(int customerid, String foodkey, int amount, int passangerClass) {
		return "Customer id " + customerid + " has ordered\n " + amount + " of " + foodkey + ", your current total price is "
				+ getTotalPrice(foodkey, passangerClass, amount)+ " kr.\n";
	}

	public String foodMenuUnOrderItems(int customerid, String foodkey, int amount, int passangerClass) {

		return "Customer id " + customerid + " has removed " + amount + " of " + foodkey + ", your current total price is "
				+ getTotalPrice(foodkey, passangerClass, amount) + " kr.\n";
	}

	public void newCustomer() {		
		totalCustomerPrice = 0;	
	}
	

	private int getTotalPrice(String foodkey, int passangerClass, int amount) {



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
		totalCustomerPrice += (menuPrice*amount);
		totalCompanyRevenue+= (menuPrice*amount); // need fix
		return totalCustomerPrice;

	}
}
