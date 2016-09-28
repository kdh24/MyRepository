package ch06.exam12;

public class StaticMember {
	//Static Field
	static String field;
	
	//Static Block
	static {
		System.out.println("Static Block 실행");
		field = "자바";
	}
	
	//Static Method
	static void method() {
	}
}
