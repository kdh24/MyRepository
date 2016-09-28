package ch08.exam07;

public class DriverExample {
	public static void main(String[] args) {
		Driver driver = new Driver();
		driver.driver(new Taxi());
		driver.driver(new Bus());
		
	}
}
