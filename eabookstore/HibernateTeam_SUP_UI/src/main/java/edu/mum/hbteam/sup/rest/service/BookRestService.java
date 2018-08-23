package edu.mum.hbteam.sup.rest.service;

import java.util.List;

import org.springframework.stereotype.Component;

import edu.mum.hbteam.sup.domain.Book;
import edu.mum.hbteam.sup.domain.Category;


@Component
public interface BookRestService {

 	public List<Book> findAll();

	public Book findOne(Long index);

	public Book save(Book book);

	public List<Category> findCategories();

}
