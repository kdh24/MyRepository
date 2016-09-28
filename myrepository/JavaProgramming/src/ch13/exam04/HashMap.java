package ch13.exam04;

public class HashMap<K, V> implements Map<K, V> {
	private K k;
	private V v;

	@Override
	public void add(K k, V v) {
		this.k = k;
		this.v = v;
	}

	@Override
	public V get(K k) {
		return v;
	}

}
