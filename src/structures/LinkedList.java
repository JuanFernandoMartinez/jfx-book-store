package structures;

public class LinkedList<K,V> implements List<K,V> {
	
	private Node<K, V> root; 
	private int size;
	
	public LinkedList() {
		root = null;
		size = 0;
	}

	@Override
	public boolean add(K k, V v) {
		boolean status = false;
		if (root == null)
		{
			root = new Node<>(k,v);
			status = true;
			size++;
		}else
		{
			Node<K, V> current = root;
			
			if (current.compareTo(k) ==0)
			{
				root = new Node<K,V>(k,v);
				root.setNext(current);
				size++;
				status = true;
			}else
			{
				while (current.getNext()!= null && !status )
				{
					if (current.getNext().compareTo(k) > 0)
					{
						Node<K,V> n = new Node<K,V>(k,v);
						n.setNext(current.getNext());
						current.setNext(n);
						size++;
						status = true;
					}else
					{
						current = current.getNext();
					}
				}
				
				if (!status)
				{
					current.setNext(new Node<K,V>(k, v));
					size++;
					status = true;
				}
			}
			
		}
		return status;
	}
	
	
	

	@Override
	public boolean remove(K k) {
		boolean status = false;
		
		if (root == null)
		{
			return false;
		}else
		{
			if (root.isTheKey(k))
			{
				if (root.getNext() == null)
				{
					root = null;
					
				}else
				{
					root = root.getNext();
				}
				size--;
				status = true;
			}else
			{
				Node<K, V> current = root;
				
				while (current.getNext() != null)
				{
					if (current.getNext().isTheKey(k))
					{
						current.setNext(current.getNext().getNext());
						size--;
						status = true;
					}else
					{
						current = current.getNext();
					}
				}
			}
		}
		
		return status;
	}

	@Override
	public boolean isEmpty() {
		boolean status = false;
		if (size == 0)
		{
			status = true;
		}
		return status;
	}

	@Override
	public int size() {
		
		return size;
	}

	@Override
	public V search(K k) {
		V element = null;
		if (root == null)
		{
			return null;
		}else
		{
			Node<K, V> current = root;
			
			while (current != null && element == null)
			{
				if (current.isTheKey(k))
				{
					element = current.getValue();
				}else
				{
					if (current.getNext() == null) current = null;
					else current = current.getNext();
				}
			}
		}
		return element;
	}

	public Node<K, V> getRoot() {
		return root;
	}

	public void setRoot(Node<K, V> root) {
		this.root = root;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public boolean modify(K k,V v) {
		boolean status = false;
		if (root == null)
		{
			return false;
		}else
		{
			Node<K, V> current = root;
			
			while (root != null && !status)
			{
				if (current.isTheKey(k))
				{
					current.setValue(v);
					status = true;
				}else
				{
					if (current.getNext() == null)
					{
						return false;
					}else
					{
						current = current.getNext();
						
					}
				}
			}
		}
		return status;
	}
	
	
	
	
	

}


