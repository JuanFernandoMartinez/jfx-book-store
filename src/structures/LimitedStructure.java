package structures;

public interface LimitedStructure<T> {
	public boolean add(T t);
	public boolean remove();
	public T top();
	public boolean push(T t);
	public boolean pop();
	public T element();
	public int size();
}
