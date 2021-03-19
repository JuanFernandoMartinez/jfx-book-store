package model;

public class Book {
	
	private String ISBNCode;
	private double price;
	private int quantity;
	
	public Book(String code, int quantity,double price) {
		ISBNCode = code;
		this.quantity = quantity;
		this.price = price;
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
	
	
	
	

}
