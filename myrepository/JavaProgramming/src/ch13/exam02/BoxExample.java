package ch13.exam02;

import java.util.Date;

public class BoxExample {
	public static void main(String[] args){
		Box<String> box1 = new Box<String>();
		box1.setItem("홍길동");
		String name = box1.getItem();
		
		Box<Integer> box2 = new Box<Integer>();
		box2.setItem(10);
		int value = box2.getItem();
				
		Box<Date> box3 = new Box<Date>();
		box3.setItem(new Date());
		Date now = box3.getItem();
	}
}
