package structures;

public class Queue<T> implements LimitedStructure<T>  {
	
	private Wrapper<T> header;
	private Wrapper<T> end;
	private int size;
	
	public Queue() {
		header = null;
		end = null;
		size = 0;
	}

	@Override
	public boolean add(T t) {
		Wrapper<T> a = new Wrapper<T>();
		a.setElement(t);
		
		if (header == null)
		{
			header = a;
			end = a;
			size ++;
			return true;
		}else
		{
			end.setNext(a);
			end = end.getNext();
			size ++;
			return true;
		}
		
	}

	@Override
	public boolean remove()  {
		if (header == null)
		{
			return false;
		}else
		{
			header = header.getNext();
			size --;
			return true;
		}
		
	}

	@Override
	public T top() {
		
		return header.getElement();
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
		
		return header.getElement();
	}

	public Wrapper<T> getHeader() {
		return header;
	}

	public void setHeader(Wrapper<T> header) {
		this.header = header;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}
	
	

}
