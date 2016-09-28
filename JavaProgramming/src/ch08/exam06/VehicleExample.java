package ch08.exam06;

public class VehicleExample {
	public static void main(String[] args) {
		Vehicle vehicle = new Bus();
		
		vehicle.run();
		//vehicle.checkFare(); (x)
		
		Bus bus = (Bus) vehicle;
		bus.checkFare();
	}
}
