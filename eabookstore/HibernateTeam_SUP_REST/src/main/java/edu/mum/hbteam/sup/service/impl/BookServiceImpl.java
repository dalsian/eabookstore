package edu.mum.hbteam.sup.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.hbteam.sup.dao.BookDao;
import edu.mum.hbteam.sup.dao.CategoryDao;
import edu.mum.hbteam.sup.dao.GenericDao;
import edu.mum.hbteam.sup.domain.Book;
import edu.mum.hbteam.sup.domain.Category;
import edu.mum.hbteam.sup.service.BookService;

@Service
@Transactional 
public class BookServiceImpl implements BookService {
	
	
 	@Autowired
 	private BookDao bookDao;
 	
 	@Autowired
 	private CategoryDao categoryDao;

    public void save( Book book) {  	
    		Category cat = categoryDao.findOne(book.getCategory().getId());
    		book.setCategory(cat);
		bookDao.save(book);
	}
	
	
    public Book update( Book book) {  		
		return bookDao.update(book);
	}
	
	
	public List<Book> findAll() {
		return (List<Book>)bookDao.findAll();
	}

 	public Book findOne(Long id) {
		return bookDao.findOne(id);
	}

}
