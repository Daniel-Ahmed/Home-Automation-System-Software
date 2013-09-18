import java.util.ArrayList;
import java.util.List;

public class House {

	// Create Objects
	Door front = new Door("Front Door");
	Door back = new Door("Back Door");
	Door bedroom = new Door("Bedroom");
	Door bathroom = new Door("Bathroom");

	Garage garage = new Garage();

	Light lightFront = new Light("Front room");
	Light lightBack = new Light("Back room");
	Light lightBedroom = new Light("Bedroom");
	Light lightBathroom = new Light("Bathroom");

	// Creating List to store created objects
	private List<Door> door = new ArrayList<Door>();
	private List<Garage> garageDoor = new ArrayList<Garage>();
	private List<Light> light = new ArrayList<Light>();

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		Interface GUI = new Interface();
	}

	public House() {
		door.add(front);
		door.add(back);
		door.add(bedroom);
		door.add(bathroom);

		garageDoor.add(garage);

		light.add(lightFront);
		light.add(lightBack);
		light.add(lightBedroom);
		light.add(lightBathroom);
	}

	public List<Door> getDoor() {
		return door;
	}

	public List<Light> getLight() {
		return light;
	}

	public List<Garage> getGarage() {
		return garageDoor;
	}
}