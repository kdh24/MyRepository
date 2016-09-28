package ch06.exam03;

public class Car {
	//Field
	String company = "현대자동차";
	String model = "그랜저";
	String color = "검정";
	int maxSpeed = 350;
	int speed;
	
	//Constructor
	Car(){
		System.out.println("Car() 실행됨");
//		Integer.parseInt("a");
	}
	
	//Method
	void run() {
		System.out.println("run() 실행됨");
	}


}