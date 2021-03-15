package structures;

public class HashTable<K,V> implements HashTableInterface<K, V>{
	
	private LinkedList<K, V>[] grid;
	private int size = 0;
	
	public HashTable(int s ) {
		grid = (LinkedList<K, V>[])new LinkedList[s];
		size = 0;
	}

	@Override
	public boolean insert(K k, V v) {
		int pos = hashFunction(k);
		if (grid[pos] == null)
		{
			grid[pos] = new LinkedList<K,V>();
		}
		boolean status = grid[pos].add(k, v);
		if (status) size++;
		return status;
	}

	@Override
	public boolean remove(K k) {
		int pos = hashFunction(k);
		
		boolean status = false;
		
		if (grid[pos] != null)
		{
			status = grid[pos].remove(k);
		}
		
		if (status) size--;
		return status;
	}

	@Override
	public int size() {
		return size;
		
	}

	@Override
	public boolean modify(K k, V v) {
		boolean status = false;
		
		int pos = hashFunction(k);
		
		if (grid[pos] != null)
		{
			status = grid[pos].modify(k, v);
		}
		return status;
	}

	@Override
	public V search(K k) {
		
		V v = null;
		int pos = hashFunction(k);
		
		if (grid[pos] != null)
		{
			v = grid[pos].search(k);
		}
		return v;
	}

	@Override
	public boolean contains(K k) {
		if (search(k) != null)
		{
			return true;
		}
		return false;
	}
	
	
	private int hashFunction(K k)
	{
		String in = k.toString();
		
		int total = 0;
		
		for (int i = 0; i < in.length(); i++)
		{
			total += in.charAt(i);
		}
		
		int finalValue = total%grid.length;
		
		return finalValue;
		
		
	}
	
}
