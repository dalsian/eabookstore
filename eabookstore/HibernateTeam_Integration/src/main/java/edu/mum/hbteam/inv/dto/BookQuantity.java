package edu.mum.hbteam.inv.dto;

import java.io.Serializable;

public class BookQuantity implements Serializable {
	
	private static final long serialVersionUID = 2429885194747805015L;
	private String isbn;
	private int quantity;
	
	public BookQuantity() {
		
	}
	public BookQuantity(String isbn, int quantity) {
		super();
		this.isbn = isbn;
		this.quantity = quantity;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "StockRequest [isbn=" + isbn + ", quantity=" + quantity + "]";
	}
	
}
