package shopping;
import java.text.DecimalFormat;

public class Item {

	private String name;
	private double price = 0.00;
	private static final DecimalFormat DF = new DecimalFormat("0.00");

	public Item(String n, double p) {
		setName(n);
		setPrice(p);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String toString() {
		return name + "   £" + DF.format(price);
	}
}