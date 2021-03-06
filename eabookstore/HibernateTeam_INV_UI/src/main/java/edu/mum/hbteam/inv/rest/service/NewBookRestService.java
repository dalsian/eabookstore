package edu.mum.hbteam.inv.rest.service;

import java.util.List;

import org.springframework.stereotype.Component;

import edu.mum.hbteam.inv.domain.Book;

@Component
public interface NewBookRestService {

 	public List<Book> findAll();

	public Book findOne(Long index);

	public Book save(Book book);
	
	public Book update(long id,Book book);


}
