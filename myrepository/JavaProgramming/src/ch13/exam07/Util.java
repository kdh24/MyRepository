package ch13.exam07;

public class Util {
	public static <T extends Number> int compare(T t1, T t2) {
		double v1 = t1.doubleValue();
		double v2 = t2.doubleValue();
		
		/*if(v1 < v2) return -1;
		else if(v1 == v2) return 0;
		else return 1;*/
		
		return Double.compare(v1, v2);
	}
}

