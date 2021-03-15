package structures;

public interface HashTableInterface<K,V> {

	public boolean insert(K k ,V v);
	public boolean remove(K k);
	public int size();
	public boolean modify(K k, V v);
	public V search(K k);
	public boolean contains(K k);
}
