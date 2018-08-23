package edu.mum.hbteam.inv.service;

import java.util.List;

import edu.mum.hbteam.inv.domain.Book;

public interface BookService {
	List<Book> getAllBooks();

  	void save(Book book);

	Book findOne(long id);
 
	void add(Book book);
	
	void update(long id,Book book);

	void sendRequest(String isbn, int quantity);
}
