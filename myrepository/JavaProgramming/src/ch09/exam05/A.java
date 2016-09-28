package ch09.exam05;

public class A {
	B b = new B();
	static B b2 = new B();
	
	public A() {
		B b = new B();
	}
	
	void method() {
		B b = new B();
	}
	
	static void method2() {
		B b = new B();
	}
	
	public static class B{
		int field1;
		static int field2;
		void method1() {}
		static void method2() {}
	}
}
