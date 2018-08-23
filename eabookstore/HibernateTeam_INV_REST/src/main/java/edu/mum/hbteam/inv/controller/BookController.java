package edu.mum.hbteam.inv.controller;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import edu.mum.hbteam.inv.domain.Book;
import edu.mum.hbteam.inv.domain.BookStatus;
import edu.mum.hbteam.inv.domain.Status;
import edu.mum.hbteam.inv.service.BookService;
import edu.mum.hbteam.inv.service.StatusService;

@RestController
@RequestMapping("/books")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private StatusService statusService;
 
 	@GetMapping({"","/"})
	public List<Book> list() {
 		Status currentStatus = statusService.findOne(BookStatus.IN_STOCK);
		return bookService.getByStatus(currentStatus);
	}
	
 	@GetMapping("/{id}")
	public Book getBookById(@PathVariable("id") Long id) {

		return bookService.findOne(id);
	}
 	
 	@PutMapping(value = "/{id}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void updateBook(@PathVariable("id") Long id, @RequestBody Book book) {
		bookService.update(book);
	}
 	
 	@PostMapping(value = "/{id}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void updateBook2(@PathVariable("id") Long id, @RequestBody Book book) {
		bookService.update(book);
	}
	
	@PostMapping(value = {"","/"})
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void addBook(@RequestBody Book book) {
		
		if (book.getId() != null && book.getId() != 0) {
			bookService.update(book);
		} else {
			bookService.addWithStatus(book, BookStatus.IN_STOCK);
		}
	}
	
	@GetMapping(value= "/quantity/{id}")
	public Map<String, Integer> getQuantity(@PathVariable("id") Long id) {
		return Collections.singletonMap("quantity", bookService.findOne(id).getQuantity());
	}
	
}
