package edu.mum.hbteam.sup.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.hbteam.sup.domain.Book;
import edu.mum.hbteam.sup.domain.Category;
import edu.mum.hbteam.sup.rest.service.BookRestService;
import edu.mum.hbteam.sup.service.BookService;



@Service
@Transactional 
public class BookServiceImpl implements BookService {
	
 	@Autowired
 	@Qualifier("MVC")
	private BookRestService bookRestService;

	@Override
	public void save(Book book) {
		// TODO Auto-generated method stub
		bookRestService.save(book);
	}

	@Override
	public List<Book> findAll() {
		// TODO Auto-generated method stub
		return bookRestService.findAll();
	}

	@Override
	public Book findOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Category> findCategories() {
		// TODO Auto-generated method stub
		return bookRestService.findCategories();
	}

    
}
