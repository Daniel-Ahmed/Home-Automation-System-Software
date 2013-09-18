public interface Sensor {

	public void addSensorObserver(SensorObserver s);

	public void removeSensorObserver();

	public void isTriggered();

}
