package home;
public class Door {

	private boolean locked = true;
	private boolean open = false;
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
	
	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	public void setOpen(boolean open) {
		this.open = open;
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