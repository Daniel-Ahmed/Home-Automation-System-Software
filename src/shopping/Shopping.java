package shopping;
import java.util.ArrayList;


public class Shopping {

	// Create a new ArrayList called item which contains objects
	private ArrayList<Item> items = new ArrayList<Item>();

	// Add Item object i to the ArrayList
	public void addItem(Item item) {
		items.add(item);
	}

	// Remove Item object i from the ArrayList
	public void removeItem(Item item) {
		items.remove(item);
	}

	/*
	 * Loop through ArrayList Object items is now the object in current loop
	 * Display details
	 */
	public void viewAll() {
		for (int i = 0; i < items.size(); i++) {
			Item item = items.get(i);
			System.out.println("Name: " + item.getName());
			System.out.println("Price: £" + item.getPrice());
			System.out.println();
		}
	}

	/*
	 * Loop through ArrayList Set items to current Object in list Set cost to
	 * the objects current price (adding)
	 */
	public double total() {
		double cost = 0.0;

		for (int i = 0; i < items.size(); i++) {
			Item item = items.get(i);
			cost = cost + item.getPrice();
		}

		return cost;
	}

	/*
	 * If ArrayList is not empty display message and clear items else display
	 * message.
	 */
	public void order() {
		if (!items.isEmpty()) {
			System.out.println("Items have been ordered.");
			items.clear();
		} else {
			System.out.println("Basket is empty.");
		}
	}
}
