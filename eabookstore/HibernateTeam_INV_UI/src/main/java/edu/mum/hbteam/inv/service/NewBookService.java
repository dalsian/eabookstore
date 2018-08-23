package edu.mum.hbteam.inv.service;

import java.util.List;

import edu.mum.hbteam.inv.domain.Book;

public interface NewBookService {
	List<Book> getAllBooks();

  	void save(Book book);

	Book findOne(long id);
 
	void add(Book book);
	
	void update(long id,Book book);

}
