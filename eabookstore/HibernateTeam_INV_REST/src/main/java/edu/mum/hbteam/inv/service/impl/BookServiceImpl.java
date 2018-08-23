package edu.mum.hbteam.inv.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.hbteam.inv.dao.BookDao;
import edu.mum.hbteam.inv.dao.CategoryDao;
import edu.mum.hbteam.inv.dao.StatusDao;
import edu.mum.hbteam.inv.domain.Book;
import edu.mum.hbteam.inv.domain.Category;
import edu.mum.hbteam.inv.domain.Status;
import edu.mum.hbteam.inv.service.BookService;

@Service
@Transactional 
public class BookServiceImpl implements BookService{
	
 	@Autowired
	private BookDao bookDao;
 	
 	@Autowired
 	private StatusDao statusDao;
 	
 	@Autowired
 	private CategoryDao categoryDao;

	public List<Book> getAllBooks() {
		return bookDao.findAll();
	}

 
    @PreAuthorize("hasRole('ROLE_ADMIN')")
	public void save(Book book) {
		   bookDao.save(book);
	}
	
	public Book findOne(long bookID) {
		return bookDao.findOne(bookID);
	}

	@Override
	public void add(Book book) {
		bookDao.save(book);
	}

	@Override
	public void update(Book book) {
		Status status = statusDao.findOne(book.getStatus().getId());
		Category category = book.getCategory();
		if(category != null) {
			book.setCategory(categoryDao.findOne(category.getId()));
		}
		book.setStatus(status);
		bookDao.update(book);
	}


	@Override
	public List<Book> getByStatus(Status status) {
		return bookDao.findAllByStatus(status);
	}

	@Override
	public void addWithStatus(Book book, Long statusId) {
		Status status = statusDao.findOne(statusId);
		book.setStatus(status);
		Category category = book.getCategory();
		if(category != null) {
			book.setCategory(categoryDao.findOne(category.getId()));
		}
		bookDao.save(book);
	}

	@Override
	public void increaseStock(String isbn, int qty) {
		bookDao.increaseStock(isbn, qty);
	}


	@Override
	public Book findByIsbn(String isbn) {
		return bookDao.findByIsbn(isbn);
	}

}
