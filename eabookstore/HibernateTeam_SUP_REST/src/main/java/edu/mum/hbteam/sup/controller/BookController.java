package edu.mum.hbteam.sup.controller;

import java.util.List;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpStatus;

import edu.mum.hbteam.sup.amqp.MessagePublisher;
import edu.mum.hbteam.sup.amqp.MessagePublisherImpl;
import edu.mum.hbteam.sup.domain.Book;
import edu.mum.hbteam.sup.domain.Category;
import edu.mum.hbteam.sup.service.BookService;
import edu.mum.hbteam.sup.service.CategoryService;

@RestController
@RequestMapping({ "/books", "", "/" })
public class BookController {

	@Autowired
	private BookService bookService;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private ApplicationContext appContext;;

	@RequestMapping({ "", "/" })
	public @ResponseBody List<Book> list() {
		return bookService.findAll();
	}

	@RequestMapping({ "/categories" })
	public @ResponseBody List<Category> listCategories() {
		return categoryService.findAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody Book getBookById(@RequestParam("id") Long id) {

		return bookService.findOne(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void updateBook(@PathVariable("id") Long id, @RequestBody Book book) {
		bookService.update(book);
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void addBook(@RequestBody Book bookToBeAdded) {

		try {
			bookService.save(bookToBeAdded);
		} catch (Exception up) {
			System.out.println(up.getMessage());
			System.out.println("Transaction Failed in Rest!!!");

		}
		// call publish method
		RabbitTemplate rbtTemplate = appContext.getBean("newPublishTemplate", RabbitTemplate.class);
		MessagePublisher messagePublisher = new MessagePublisherImpl();
		messagePublisher.publishNewPublishBook(rbtTemplate, bookToBeAdded);
	}

}
