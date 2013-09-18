public class Garage extends Door {

	public Garage() {
		super("Garage");
	}

	@Override
	public void lock() {
		open = false;
		locked = true;
	}

	@Override
	public void unlock() {
		locked = false;
		open = true;
	}
}