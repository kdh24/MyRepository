package ch07.exam06.pack1;

public class B {
	//Filed
	A a = new A();
	
	//Constructor
	B() {
		A a;
		a = new A();
		a.field = 10;
		a.method();
	}
	
	//Method
	void method() {
		A a = new A();
	}
}
