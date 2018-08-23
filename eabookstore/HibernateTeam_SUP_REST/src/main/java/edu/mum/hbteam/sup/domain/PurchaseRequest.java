package edu.mum.hbteam.sup.domain;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import edu.mum.hbteam.sup.domain.Book;
import edu.mum.hbteam.sup.domain.Status;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.*;

@Entity
public class PurchaseRequest implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 4436437541312807828L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id = null;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "book_id")
	private Book book;

	@Column
	private Integer quantity;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "status_id")
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
