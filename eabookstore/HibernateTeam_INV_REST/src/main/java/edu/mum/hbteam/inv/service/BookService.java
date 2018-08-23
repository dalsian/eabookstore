package edu.mum.hbteam.inv.service;

import java.util.List;

import edu.mum.hbteam.inv.domain.Book;
import edu.mum.hbteam.inv.domain.Status;

public interface BookService {

	List<Book> getAllBooks();
	
	List<Book> getByStatus(Status status);

  	void save(Book book);

	Book findOne(long id);
 
	void add(Book book);
	
	void addWithStatus(Book book, Long statusId);
	
	void increaseStock(String isbn, int qty);
	
	void update(Book book);

	Book findByIsbn(String isbn);
}
