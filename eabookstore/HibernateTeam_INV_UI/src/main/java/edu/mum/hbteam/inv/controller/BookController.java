package edu.mum.hbteam.inv.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.mum.hbteam.inv.domain.Book;
import edu.mum.hbteam.inv.service.BookService;

@Controller
@RequestMapping({ "/books", "" })
public class BookController {

	@Autowired
	BookService bookService;

	@RequestMapping
	public String listBooks(Model model) {
		model.addAttribute("books", bookService.getAllBooks());
		return "books";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String getBookById(Model model, @PathVariable("id") Long id, @ModelAttribute("newBook") Book bookToBeAdded) {
		model.addAttribute("book", bookService.findOne(id));
		return "book";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public String processUpdateBookForm(@PathVariable("id") Long id,
			@Valid @ModelAttribute("newBook") Book bookToBeAdded, BindingResult result) {
		if (result.hasErrors()) {
			return "book";
		}
		bookService.update(id, bookToBeAdded);
		return "redirect:/books";
	}

	@RequestMapping(value = "/{id}/request", method = RequestMethod.POST)
	public String processRequestBookForm(@PathVariable("id") Long id, @ModelAttribute("newBook") Book bookToBeRequested,
			BindingResult result) {
		if (result.hasErrors()) {
			return "book";
		}
		int quantity = bookToBeRequested.getQuantity();
		String isbn = bookToBeRequested.getIsbn();
		bookService.sendRequest(isbn, quantity);
		return "redirect:/books";
	}

}
