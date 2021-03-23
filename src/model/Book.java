package model;



public class Book implements Comparable<Book> {
	
	private String ISBNCode;
	private double price;
	private int quantity;
	private String stand;
	
	public Book(String code, int quantity,double price,String stand) {
		ISBNCode = code;
		this.quantity = quantity;
		this.price = price;
		this.stand = stand;
	}
	
	public void removeOne()
	{
		quantity--;
	}

	public String getISBNCode() {
		return ISBNCode;
	}

	public void setISBNCode(String iSBNCode) {
		ISBNCode = iSBNCode;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public int compareTo(Book arg0) {
		int s = stand.compareTo(arg0.stand);
		return s;
	}

	
	
	
	
	

	

	
	
	
	
	

}
