package structures;

public class Node<K,V> {
	private K key;
	private V value;
	private Node<K, V> next;
	
	
	public Node(K k, V v) {
		key = k;
		value = v;
		next = null;
	}
	
	
	public boolean isTheKey(K a)
	{
		if (((Comparable<K>) key).compareTo(a)==0)
		{
			return true;
		}
		return false;
	}
	
	
	public int compareTo(K k)
	{
		return ((Comparable<K>) key).compareTo(k);
	}

	public K getKey() {
		return key;
	}


	public void setKey(K key) {
		this.key = key;
	}


	public V getValue() {
		return value;
	}


	public void setValue(V value) {
		this.value = value;
	}


	public Node<K, V> getNext() {
		return next;
	}


	public void setNext(Node<K, V> next) {
		this.next = next;
	}
	
	
}
