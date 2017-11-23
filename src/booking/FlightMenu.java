package booking;
import java.util.HashMap;
import java.util.Map;

public class FlightMenu {

	Map<String, Integer> menu = new HashMap<String, Integer>();

	public FlightMenu(SeatClass foo) {
		menu = init(foo);
	}

	
	public Map<String, Integer> init(SeatClass foo) {
		
		if (foo.name().equals(SeatClass.ECONOMY.toString())) {
			
			menu.put("Homemade Italian Lasagna", 120);
			menu.put("Italian Spaghetti Bolognese", 120);
			menu.put("Swedish Meatballs", 120);
			menu.put("Sparkling Water", 20);
			menu.put("Dry Whiskey", 120);
			menu.put("Carlsberg Export", 60);
			menu.put("Coca cola", 20);
			menu.put("Fanta", 20);
			menu.put("Sprite", 20);
			menu.put("Orange juice", 25);
			menu.put("Snickers, 150g", 20);
			menu.put("Cheetos, 250g", 30);
			menu.put("Chips, 250g", 25);
			menu.put("Marabou, 200g", 30);
			menu.put("Fresh Bun right from the oven", 15);
			
		}

		else if (foo.name().equals(SeatClass.FIRST.toString())) {
			
			
			menu.put("Cooked Clams with spicy cream sauce", 180);
			menu.put("Fresh Lobster with fried tomatoes", 230);
			menu.put("Seafood Soup", 140);
			menu.put("Italian Spaghetti Carbonara", 90);
			menu.put("Grilled Entrecote with Bearnaise sauce", 160);
			menu.put("Sparkling Water", 25);
			menu.put("Dry Whiskey", 120);
			menu.put("Carlsberg Export", 60);
			menu.put("Coca cola", 25);
			menu.put("Fanta", 25);
			menu.put("Sprite", 25);
			menu.put("Orange juice", 30);
			menu.put("Snickers, 150g", 20);
			menu.put("Cheetos, 250g", 30);
			menu.put("Chips, 250g", 25);
			menu.put("Marabou, 200g", 30);
			menu.put("Fresh Bun right from the oven", 15);
			
		}
		return menu;
	}
	
	
	public Map<String, Integer> getMenu() {
		return menu;
	}


	public void setMenu(Map<String, Integer> menu) {
		this.menu = menu;
	}


}
