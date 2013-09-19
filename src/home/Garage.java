package home;

public class Garage extends Door {

	public Garage() {
		super("Garage");
	}

	public void lock() {
		super.setOpen(false);
		super.setLocked(true);
	}

	public void unlock() {
		super.setLocked(false);
		super.setOpen(true);
	}
}