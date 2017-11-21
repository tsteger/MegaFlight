package booking;
import java.util.HashMap;
import java.util.Map;

public class FlightMenu {

	HashMap<String, Integer> menu = new HashMap<String, Integer>();

	public FlightMenu(FoodClass foo) {

		init(foo);

	}

	
	public Map<String, Integer> init(FoodClass foo) {
		
		if (foo.name().equals(FoodClass.FIRST.toString())) {
			
			menu.put("Clams", 180);
			menu.put("Lobster", 230);
			menu.put("Seafood Soup", 140);
			menu.put("Spaghetti Carbonara", 90);
			menu.put("Entrecote", 160);
			menu.put("Sparkling Water", 25);
			menu.put("Whiskey", 120);
			menu.put("Carlsberg", 60);
			menu.put("Coca cola", 25);
			menu.put("Fanta", 25);
			menu.put("Sprite", 25);
			menu.put("Orange juice", 30);
			menu.put("Snickers", 20);
			menu.put("Cheetos", 30);
			menu.put("Chips", 25);
			menu.put("Marabou", 25);
			menu.put("Bun", 15);
			

		}

		else {
			
			menu.put("Lasagna", 120);
			menu.put("Spaghetti Bolognese", 120);
			menu.put("Meatballs", 120);
			menu.put("Sparkling Water", 20);
			menu.put("Whiskey", 120);
			menu.put("Carlsberg", 60);
			menu.put("Coca cola", 20);
			menu.put("Fanta", 20);
			menu.put("Sprite", 20);
			menu.put("Orange juice", 25);
			menu.put("Snickers", 20);
			menu.put("Cheetos", 30);
			menu.put("Chips", 25);
			menu.put("Marabou", 25);
			menu.put("Bun", 15);
			
		}
		return menu;
	}
	
	
	public HashMap<String, Integer> getMenu() {
		return menu;
	}


	public void setMenu(HashMap<String, Integer> menu) {
		this.menu = menu;
	}


}
