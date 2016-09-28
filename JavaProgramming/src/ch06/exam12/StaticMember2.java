package ch06.exam12;

public class StaticMember2 {
	//Static Field
	static String field;
	String field2;
	
	//Static Block
	static {
		System.out.println("Static Block 실행");
		field = "자바";
		//field2 = "자바";
	}
	
	//Static Method
	static void method() {
		field = "자바";
		//field2 = "자바";
	}
	void method2() {
		field = "자바";
		field2 = "자바";
	}
	
	public static void main(String[] args){
		field = "자바";
		//field2 = "자바";
		
		method();
		//method2();
		
		StaticMember2 sm = new StaticMember2();
		sm.field2 = "자바";
		sm.method2();
	}
}
