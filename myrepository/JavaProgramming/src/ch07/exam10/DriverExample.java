package ch07.exam10;

public class DriverExample {
	public static void main(String[] args) {
			Driver driver = new Driver();
			
			driver.driver(new Vehicle());
			driver.driver(new Bus());
			driver.driver(new Taxi());
	}
}
