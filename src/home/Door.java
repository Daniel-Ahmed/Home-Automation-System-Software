package home;
public class Door {

	protected boolean locked = true;
	protected boolean open = false;
	private String name;

	public Door(String name) {
		this.name = name;
	}

	public void open() {
		open = true;
	}

	public void close() {
		open = false;
	}

	public void lock() {
		locked = true;
	}

	public void unlock() {
		locked = false;
	}

	public boolean isOpen() {
		return open;
	}

	public boolean isLocked() {
		return locked;
	}

	public String toString() {
		return name + ":";
	}

	public String status() {
		if (locked) {
			return "Locked";
		} else if (open) {
			return "Open";
		} else {
			return "Shut";
		}
	}
}