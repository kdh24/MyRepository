package ch09.exam06;

public class A {
	int field = 10;
	
	public void method() {
		int local = 10;
		class B {
			void method() {
				field = 5;
				//local = 5;
				int result = local + field;
			}
		}
		B b = new B();
	}
	
}
