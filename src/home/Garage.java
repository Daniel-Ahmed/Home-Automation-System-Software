package home;

public class Garage extends Door {

	public Garage() {
		super("Garage");
	}

	@Override
	public void lock() {
		super.setOpen(false);
		super.setLocked(true);
	}

	@Override
	public void unlock() {
		super.setLocked(false);
		super.setOpen(true);
	}
}