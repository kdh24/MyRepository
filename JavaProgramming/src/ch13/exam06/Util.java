package ch13.exam06;

public class Util {
	public static <K, V> boolean compare(Pair<K, V> p1, Pair<K, V> p2) {
		boolean keyCompare = p1.getKey().equals(p2.getKey());
		boolean valueComapre = p1.getValue().equals(p2.getValue());
		return keyCompare && valueComapre;
	}
	
	public static <K, V> Pair<K, V> max(Pair<K, V> p1, Pair<K, V> p2){
		return p2;
	}
}
