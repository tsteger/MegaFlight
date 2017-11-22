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
		FlightMenu thisMenu = getCorrectMenu(passangerClass);
		
		
		return "Customer ID: " + customerid + "\nOrdered: " + amount + " " + foodkey + "\nCost: "
			+ thisMenu.getMenu().get(foodkey).intValue()	+ " kr.\n" + "Total Cost: " + getTotalPrice(foodkey, passangerClass, amount) + "kr.\n";
	}
	
	public String foodMenuUnOrderItems(int customerid, String foodkey, int amount, int passangerClass) {
		FlightMenu thisMenu = getCorrectMenu(passangerClass);
		
		return "Customer ID: " + customerid + "\nRemoved: " + amount + " " + foodkey + "\nCost: "
		+  thisMenu.getMenu().get(foodkey).intValue()	+ " kr.\n" +  "Total Cost: " + getTotalPrice(foodkey, passangerClass, amount) + " kr.\n";
	}

	public void newCustomer() {		
		totalCustomerPrice = 0;	
	}
	
	
	private FlightMenu getCorrectMenu(int passangerClass) {
		
		if(passangerClass == 0) {
			return smenu;
		}else {
			
			return fmenu;
			
		}
			
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
				Iterator it1 = smenu.getMenu().entrySet().iterator();
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
		totalCompanyRevenue+=totalCustomerPrice; // need fix
		return totalCustomerPrice;

	}
}
