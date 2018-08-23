package edu.mum.hbteam.sup.domain;

import java.io.Serializable;

public class Book implements Serializable {

	private static final long serialVersionUID = 0L;

	private Long id;
	private String name;
	private String author;
	private String isbn;
	private String description;
	private float price;

	private Category category;

	public Book() {
		super();
	}

	public Book(String name, String author, String isbn, String description, float price, Category category) {
		super();
		this.name = name;
		this.author = author;
		this.isbn = isbn;
		this.description = description;
		this.price = price;
		this.category = category;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
}
