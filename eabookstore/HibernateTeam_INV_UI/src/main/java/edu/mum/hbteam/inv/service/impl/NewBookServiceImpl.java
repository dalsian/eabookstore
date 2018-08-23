package edu.mum.hbteam.inv.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import edu.mum.hbteam.inv.domain.Book;
import edu.mum.hbteam.inv.rest.service.NewBookRestService;
import edu.mum.hbteam.inv.service.BookService;
import edu.mum.hbteam.inv.service.NewBookService;

@Service
public class NewBookServiceImpl implements NewBookService {

	@Autowired
	@Qualifier("MVC_NewBook")
	private NewBookRestService newBookRestService;

	@Override
	public List<Book> getAllBooks() {
		return newBookRestService.findAll();
	}

	@Override
	public void save(Book book) {
		// TODO Auto-generated method stub

	}

	@Override
	public Book findOne(long id) {
		// TODO Auto-generated method stub
		return newBookRestService.findOne(id);
	}

	@Override
	public void add(Book book) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(long id,Book book) {
		// TODO Auto-generated method stub
		newBookRestService.update(id, book);
	}

}
