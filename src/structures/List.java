package structures;

public interface List<K,V> {
	public boolean add(K k,V v);
	public boolean remove(K k);
	public V search(K k);
	public boolean isEmpty();
	public int size();
	public boolean modify(K k,V v);
	
}