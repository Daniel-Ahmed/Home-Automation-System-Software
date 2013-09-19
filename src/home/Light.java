package home;
public class Light {

	private boolean lightOn = false;
	private int dimValue = 0;

	public int getDimValue() {
		return dimValue;
	}

	private String name;

	public Light(String name) {
		this.name = name;
	}

	public void turnOn() {
		lightOn = true;
	}

	public void turnOff() {
		lightOn = false;
	}

	public boolean isOn() {
		return lightOn;
	}

	public String toString() {
		return name + ":";
	}

	public String status() {
		if (lightOn) {
			return "On";
		} else {
			return "Off";
		}
	}

	public void setDimValue(int dimValue) {
		this.dimValue = dimValue;
	}
}