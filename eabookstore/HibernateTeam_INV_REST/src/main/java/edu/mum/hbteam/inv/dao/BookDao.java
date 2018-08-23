package edu.mum.hbteam.inv.dao;


import java.util.List;

import edu.mum.hbteam.inv.domain.Book;
import edu.mum.hbteam.inv.domain.Status;


public interface BookDao extends GenericDao<Book>  
{
	List<Book> findAllByStatus(Status status);
	
	void increaseStock(String isbn, int qty);
	
	Book findByIsbn(String isbn);
}

