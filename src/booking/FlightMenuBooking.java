package booking;

import java.util.Iterator;
import java.util.Map;

public class FlightMenuBooking {

	FlightMenu fmenu = new FlightMenu(SeatClass.FIRST);
	FlightMenu smenu = new FlightMenu(SeatClass.ECONOMY);
	
	int totalCompanyRevenue= 0 ;
	int totalCustomerPrice = 0;
	
	
	public int getTotalCompanyEarnedAmount() {
		return totalCompanyRevenue;
	}
	public int GettotalCustomerPrice() {
		return totalCustomerPrice;
	}
	
	
	
	
	public String foodMenuOrderItems(int customerid, String foodkey, int amount, int passangerClass) {
		
		FlightMenu thisMenu = getCorrectMenu(passangerClass);
		getTotalPrice(foodkey, passangerClass, amount); // was a line in return like:  + "Total Cost: " + getTotalPrice(foodkey, passangerClass, amount) + "kr."
		return "\nOrdered: " + amount + " " + foodkey + "\nCost: "
			+ thisMenu.getMenu().get(foodkey).intValue()*amount	+ " SEK.";
	
	}
	
	public String foodMenuUnOrderItems(int customerid, String foodkey, int amount, int passangerClass) {
		 
		FlightMenu thisMenu = getCorrectMenu(passangerClass);
		getTotalMinusPrice(foodkey, passangerClass, amount);// was a line in return like: +  "Total Cost: " + getTotalMinusPrice(foodkey, passangerClass, amount) + " kr."
		return "\nRemoved: " + amount + " " + foodkey + "\nRemoved Cost: "
		+  thisMenu.getMenu().get(foodkey).intValue()*amount	+ " SEK." ;
	
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

		int menuPrice =  0; // important that this stay here.


		if (passangerClass == 1) {
			Iterator it1 = fmenu.getMenu().entrySet().iterator();
			while (it1.hasNext()) {
				Map.Entry pair = (Map.Entry) it1.next();
				if (pair.getKey().equals(foodkey)) {
					menuPrice += (Integer) pair.getValue();
					// it1.remove(); // avoids a ConcurrentModificationException
				}

			}
		}

		else {
			if (passangerClass == 0) {
				Iterator<Map.Entry<String, Integer>> it1 = smenu.getMenu().entrySet().iterator();
				while (it1.hasNext()) {
					Map.Entry<String, Integer> pair = (Map.Entry) it1.next();
					if (pair.getKey().equals(foodkey)) {
						menuPrice += (Integer) pair.getValue();
						//it1.remove(); // avoids a ConcurrentModificationException
					}
				}

			}

		}
		totalCustomerPrice += (menuPrice*amount);
		totalCompanyRevenue+= (menuPrice*amount); // need fix
		return totalCustomerPrice;

		
		
		
	}
	
	
	private int getTotalMinusPrice(String foodkey, int passangerClass, int amount) {
		
		int menuPrice = 0;
		
		if (passangerClass == 1) {
			Iterator it1 = fmenu.getMenu().entrySet().iterator();
			while (it1.hasNext()) {
				Map.Entry pair = (Map.Entry) it1.next();
				if (pair.getKey().equals(foodkey)) {
					menuPrice += (Integer) pair.getValue();
				}
				
			}
			
		}
		
		else {
			if (passangerClass == 0) {
				Iterator<Map.Entry<String, Integer>> it1 = smenu.getMenu().entrySet().iterator();
				while (it1.hasNext()) {
					Map.Entry<String, Integer> pair = (Map.Entry) it1.next();
					if (pair.getKey().equals(foodkey)) {
						menuPrice += (Integer) pair.getValue();
		
						
					}
				}	
			}		
					}
		totalCustomerPrice -= (menuPrice*amount);
		totalCompanyRevenue-= (menuPrice*amount); 
		return totalCustomerPrice;
	}
	
}
