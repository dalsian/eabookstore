package edu.mum.hbteam.sup.service;

import java.util.List;

import edu.mum.hbteam.sup.domain.Book;
 
public interface BookService {

	public void save(Book book);
	public Book update(Book book);
	public List<Book> findAll();
	public Book findOne(Long id);

}
