package structures;

public class Wrapper<T> {
	private T element;
	private Wrapper<T> next;
	
	
	public Wrapper() {
		element = null;
		next = null;
	}
	
	
	
	


	public T getElement() {
		return element;
	}



	public void setElement(T element) {
		this.element = element;
	}



	public Wrapper<T> getNext() {
		return next;
	}



	public void setNext(Wrapper<T> next) {
		this.next = next;
	}
	
	
}


