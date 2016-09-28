package ch06.exam13;

public class School {
	//Field
	private static School singleton = new School();
	
	//Consturctor
	private School() {
	}
	
	//Method
	static School getInstance() {
		return singleton;
	}
}
