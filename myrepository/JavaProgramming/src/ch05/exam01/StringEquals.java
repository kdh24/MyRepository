package ch05.exam01;

public class StringEquals {

	public static void main(String[] args) {
		String name1 = "자바";
		String name2 = "자바";
		String name3 = new String("자바");
		
		System.out.println(name1 == name2);
		System.out.println(name1 == name3);
		
		System.out.println(name1.equals(name2));
		System.out.println(name1.equals(name3));
	}

}
