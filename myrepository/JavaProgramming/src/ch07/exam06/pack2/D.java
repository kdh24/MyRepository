package ch07.exam06.pack2;

import ch07.exam06.pack1.A;

public class D extends A {
	//Field
	//A a = new A();
	
	//Constructor
	D() {
		/*A a = new A();
		a.field = 10;
		a.method();*/
		
		super();
		field = 5;
		method();
	}
	
	//Method
	void method2() {
		field = 5;
		method();
	}
}
