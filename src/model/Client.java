package model;

import structures.Queue;
import structures.Stack;

public class Client implements Comparable<Client>{
	
	private String id;
	private String[] wished;
	private int time;
	private Queue<Book> list;
	private Stack<Book> deck;
	
	public Client(String id,String[] wished, int time ) {
		this.id = id;
		this.wished = wished;
		this.time = time;
		list = new Queue<>();
		deck = new Stack<>();
	}
	
	
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String[] getWished() {
		return wished;
	}

	public void setWished(String[] wished) {
		this.wished = wished;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public Queue<Book> getList() {
		return list;
	}

	public void setList(Queue<Book> list) {
		this.list = list;
	}

	public Stack<Book> getDeck() {
		return deck;
	}

	public void setDeck(Stack<Book> deck) {
		this.deck = deck;
	}




	@Override
	public int compareTo(Client o) {
		int status = 0;
		if (time > o.time)
		{
			status = 1;
		}else if (time < o.time)
		{
			status = -1;
		}else
		{
			status = 0;
		}
		return status;
	}
	
	
	
	

}
