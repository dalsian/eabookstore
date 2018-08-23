package edu.mum.hbteam.inv.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import edu.mum.hbteam.inv.domain.Book;
import edu.mum.hbteam.inv.rest.service.BookRestService;
import edu.mum.hbteam.inv.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	@Qualifier("MVC")
	private BookRestService bookRestService;

	@Override
	public List<Book> getAllBooks() {
		return bookRestService.findAll();
	}

	@Override
	public void save(Book book) {
		// TODO Auto-generated method stub

	}

	@Override
	public Book findOne(long id) {
		// TODO Auto-generated method stub
		return bookRestService.findOne(id);
	}

	@Override
	public void add(Book book) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(long id,Book book) {
		// TODO Auto-generated method stub
		bookRestService.update(id, book);
	}

	@Override
	public void sendRequest(String isbn, int quantity) {
		// TODO Auto-generated method stub
		bookRestService.sendRequest(isbn,quantity);
	}

}
