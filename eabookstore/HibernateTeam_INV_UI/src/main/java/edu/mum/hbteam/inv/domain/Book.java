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
import javax.validation.constraints.*;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import edu.mum.hbteam.inv.validation.EmptyOrSize;
import edu.mum.hbteam.inv.validation.NullMinNumber;

//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Entity
public class Book implements Serializable {

	private static final long serialVersionUID = 0L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(length=500)
	@NotEmpty(message= "{NotEmpty}")
	@Size(min=3, max=500, message="{Size.name}")
	private String name;
	
	@NotEmpty(message= "{NotEmpty}")
	@Size(min=3, max=40, message="{Size.autor}")
	private String author;
	
	//ISBN: 333-333-333
	@NotEmpty(message= "{NotEmpty}")
	@Pattern(regexp="^\\d{3}(-\\d{3})?(-\\d{3})?$",message="{Pattern.isbn}")
	private String isbn;
	
	@Column(length=2000)
	@EmptyOrSize(min=5, max = 2000, message= "{EmptyOrSize}")
	private String description;
	
	@NullMinNumber(value=1, message = "{NullMinNumber.price}")
	private float price;
	
	@NotNull
	@Range(min=1, max=1000, message = "{Range.quantity}")
	private Integer quantity;

	@ManyToOne(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "category_id")
	private Category category;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade= {CascadeType.MERGE})
    @JoinColumn(name="status_id")
    private Status status;

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

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
}
