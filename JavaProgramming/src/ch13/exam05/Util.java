package ch13.exam05;

public class Util {
	public static <T> Box<T> boxing(T t) {
		Box<T> box = new Box<T>();
		box.setItem(t);
		return box;
	}
	
}

