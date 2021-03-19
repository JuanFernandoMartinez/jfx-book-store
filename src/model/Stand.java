package model;

import structures.HashTable;

public class Stand {
	
	private String id;
	private int books;
	private HashTable<String, Book> bookList;
	
	public Stand(String id, int size ) {
		this.id = id;
		this.books = size;
		bookList = new HashTable<>(31);
		
	}

	public boolean add(Book b)
	{
		return bookList.insert(b.getISBNCode(), b);
	}
	
	
	public boolean remove(String isbn)
	{
		boolean status = false;
		Book aux = bookList.search(isbn);
		if (aux.getQuantity() > 0)
		{
			aux.removeOne();
			status = true;
		}
		return status;
	}
	
	public boolean contains(String isbn)
	{
		if (bookList.contains(isbn) && bookList.search(isbn).getQuantity()>0) return true;
		else return false;
	}
	
	
	
	public int size()
	{
		return books;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getBooks() {
		return books;
	}

	public void setBooks(int books) {
		this.books = books;
	}

	public HashTable<String, Book> getBookList() {
		return bookList;
	}

	public void setBookList(HashTable<String, Book> bookList) {
		this.bookList = bookList;
	}
	
	
	
}
