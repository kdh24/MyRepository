package ch06.exam12;

public class Example {

	public static void main(String[] args) {
		//Instance Member 사용
		InstanceMember im = new InstanceMember();
//		im.field = "자바";
		System.out.println(im.field);
		im.method();
		
		//Static Member 사용
		StaticMember.field = "자바";
//		System.out.println(StaticMember.field);
//		StaticMember.method();
//		StaticMember sm = new StaticMember();
		
	}
}
