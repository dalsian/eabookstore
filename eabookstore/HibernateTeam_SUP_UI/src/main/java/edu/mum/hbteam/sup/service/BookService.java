package edu.mum.hbteam.sup.service;

import java.util.List;

import edu.mum.hbteam.sup.domain.Book;
import edu.mum.hbteam.sup.domain.Category;


 
public interface BookService {

	public void save(Book book);
	public List<Book> findAll();
	public Book findOne(Long id);
	public List<Category> findCategories();

}
