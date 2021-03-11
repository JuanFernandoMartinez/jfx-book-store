package structures;

public class Stack<T> implements LimitedStructure<T> {
	
	private T value;
	private Stack<T> a;
	private int size;
	
	public Stack() {
		value = null;
		a = null;
		size = 0;
	}

	@Override
	public boolean add(T t) {
		if (value == null)
		{
			value = t;
			size++;
			return true;
		}else
		{
			Stack<T> b = new Stack<>();
			b.setA(a);
			b.setValue(value);
			value = t;
			a = b;
			size++;
			return true;
		}
		
	}

	@Override
	public boolean remove() {
		if (a == null)
		{
			value = null;
			size--;
			return true;
		}else
		{
			value = a.getValue();
			a = a.getA();
			size--;
			return true;
		}
		
	}

	@Override
	public T top() {
		
		return value;
	}

	@Override
	public boolean push(T t) {
		
		return add(t);
	}

	@Override
	public boolean pop() {
		
		return remove();
	}

	@Override
	public T element() {
		
		return value;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public Stack<T> getA() {
		return a;
	}

	public void setA(Stack<T> a) {
		this.a = a;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	

}
