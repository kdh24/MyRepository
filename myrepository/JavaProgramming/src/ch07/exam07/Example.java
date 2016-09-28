package ch07.exam07;

public class Example {
	public static void main(String[] args) {
		A a;
		a = new B();
		a = new C();
		
		B b;
		b = new B();
		//b = new C();   C는 B와 아무관계가 아니다
	}
}
