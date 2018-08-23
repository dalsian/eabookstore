package edu.mum.hbteam.sup.domain;

import java.io.Serializable;

public class PurchaseRequest implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 4436437541312807828L;

	private Long id = null;

	private Book book;

	private Integer quantity;

	private Status status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}
