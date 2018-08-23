package edu.mum.hbteam.sup.domain;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import edu.mum.hbteam.sup.validation.EmptyOrSize;
import edu.mum.hbteam.sup.validation.NullMinNumber;

import java.io.Serializable;

@Entity
public class Book implements Serializable {

	private static final long serialVersionUID = 0L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NotEmpty(message = "{NotEmpty}")
	@Size(min = 3, max = 500, message = "{Size.name}")
	@Column(length = 500)
	private String name;
	@Size(min = 3, max = 40, message = "{Size.autor}")
	private String author;
	// ISBN: 333-333-333
	@NotEmpty(message = "{NotEmpty}")
	@Pattern(regexp = "^\\d{3}(-\\d{3})?(-\\d{3})?$", message = "{Pattern.isbn}")
	private String isbn;
	@Column(length = 2000)
	@EmptyOrSize(min = 5, max = 2000, message = "{EmptyOrSize}")
	private String description;

	@NullMinNumber(value = 1, message = "{NullMinNumber.price}")
	private float price;

	@ManyToOne(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "category_id")
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
