package ch08.exam05;

import ch08.exam05.Tire;

public class Car {
	Tire[] tires = {
		new HankookTire(),
		new HankookTire(),
		new HankookTire(),
		new HankookTire()
	};
	
	void run() {
		for(Tire tire : tires){
			tire.roll();
		}
	}
}
