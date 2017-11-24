package booking;

import java.util.Iterator;
import java.util.Map;

public class FlightMenuBooking {

	FlightMenu fmenu = new FlightMenu(SeatClass.FIRST);
	FlightMenu emenu = new FlightMenu(SeatClass.ECONOMY);	
	
	private int totalIncomeFood = 0;
	private int totalCustomerCostFood = 0;
	
	public int getTotalIncomeFood() {
		return totalIncomeFood;
	}
	
	public int GetTotalCustomerCostFood() {
		return totalCustomerCostFood;
	}
	
	private void resetTotalCustomerCostFood() {
		totalCustomerCostFood=0;		
	}
		
	public String foodMenuOrderItems(int customerid, String foodkey, int amount, int passangerClass) {		
		FlightMenu thisMenu = getCorrectMenu(passangerClass);
		getTotalPrice(foodkey, passangerClass, amount); 
		return "\nOrdered: " + amount + " " + foodkey + "\nCost: "
			+ thisMenu.getMenu().get(foodkey).intValue()*amount	+ " SEK.";	
	}
	
	public String foodMenuUnOrderItems(int customerid, String foodkey, int amount, int passangerClass) {
		 
		FlightMenu thisMenu = getCorrectMenu(passangerClass);
		getTotalMinusPrice(foodkey, passangerClass, amount);
		return "\nRemoved: " + amount + " " + foodkey + "\nRemoved Cost: "
		+  thisMenu.getMenu().get(foodkey).intValue()*amount	+ " SEK." ;
	
	}

	public void newCustomer() {
		resetTotalCustomerCostFood();	
	}
		
	private FlightMenu getCorrectMenu(int passangerClass) {		
		if(passangerClass == 0) {
			return emenu;
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
				Iterator<Map.Entry<String, Integer>> it1 = emenu.getMenu().entrySet().iterator();
				while (it1.hasNext()) {
					Map.Entry<String, Integer> pair = (Map.Entry) it1.next();
					if (pair.getKey().equals(foodkey)) {
						menuPrice += (Integer) pair.getValue();
						//it1.remove(); // avoids a ConcurrentModificationException
					}
				}
			}
		}
		totalCustomerCostFood += (menuPrice*amount);
		totalIncomeFood+= (menuPrice*amount); // need fix
		return totalCustomerCostFood;		
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
				Iterator<Map.Entry<String, Integer>> it1 = emenu.getMenu().entrySet().iterator();
				while (it1.hasNext()) {
					Map.Entry<String, Integer> pair = (Map.Entry) it1.next();
					if (pair.getKey().equals(foodkey)) {
						menuPrice += (Integer) pair.getValue();						
					}
				}	
			}		
					}
		totalCustomerCostFood -= (menuPrice*amount);
		totalIncomeFood-= (menuPrice*amount); 
		return totalCustomerCostFood;
	}
	
}
