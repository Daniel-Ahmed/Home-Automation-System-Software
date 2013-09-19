package shopping;
import java.util.ArrayList;


public class Shopping {

	// Create a new ArrayList called item which contains objects
	private ArrayList<Item> item = new ArrayList<Item>();

	// Add Item object i to the ArrayList
	public void addItem(Item i) {
		item.add(i);
	}

	// Remove Item object i from the ArrayList
	public void removeItem(Item i) {
		item.remove(i);
	}

	/*
	 * Loop through ArrayList Object items is now the object in current loop
	 * Display details
	 */
	public void viewAll() {
		for (int i = 0; i < item.size(); i++) {
			Item items = item.get(i);
			System.out.println("Name: " + items.getName());
			System.out.println("Price: £" + items.getPrice());
			System.out.println();
		}
	}

	/*
	 * Loop through ArrayList Set items to current Object in list Set cost to
	 * the objects current price (adding)
	 */
	public double total() {
		double cost = 0.0;

		for (int i = 0; i < item.size(); i++) {
			Item items = item.get(i);
			cost = cost + items.getPrice();
		}

		return cost;
	}

	/*
	 * If ArrayList is not empty display message and clear items else display
	 * message.
	 */
	public void order() {
		if (!item.isEmpty()) {
			System.out.println("Items have been ordered.");
			item.clear();
		} else {
			System.out.println("Basket is empty.");
		}
	}
}
