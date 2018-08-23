package edu.mum.hbteam.inv.domain;
import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Entity
public class Book implements Serializable {
    private static final long serialVersionUID = 0L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
	@Column(length=500)
	private String name;
	private String author;
	private String isbn;
	@Column(length=2000)
    private String description;
    private float price;
    private int quantity;
    @ManyToOne(fetch = FetchType.EAGER, cascade= {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name="category_id")
    private Category category;
    @ManyToOne(fetch = FetchType.EAGER, cascade= {CascadeType.MERGE})
    @JoinColumn(name="status_id")
    private Status status;
    
    public Book() {
    	super();
    }
    
	public Book(String name, String author, String isbn, String description, float price, int quantity, Category category) {
		super();
		this.name = name;
		this.author = author;
		this.isbn = isbn;
		this.description = description;
		this.price = price;
		this.category = category;
		this.quantity = quantity;
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
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", author=" + author + ", isbn=" + isbn + ", description="
				+ description + ", price=" + price + ", quantity=" + quantity + ", category=" + category + ", status="
				+ status + "]";
	}
 }