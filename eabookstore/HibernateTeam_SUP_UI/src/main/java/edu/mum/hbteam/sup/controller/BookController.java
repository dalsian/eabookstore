package edu.mum.hbteam.sup.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.hbteam.sup.domain.Book;
import edu.mum.hbteam.sup.service.BookService;

@Controller
@RequestMapping({ "/books", "" })
public class BookController {

	@Autowired
	private BookService bookService;

	@RequestMapping
	public String list(Model model, @ModelAttribute("newBook") Book newBook) {
		model.addAttribute("books", bookService.findAll());
		model.addAttribute("categories", bookService.findCategories());
		return "books";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String getBookById(Model model, @PathVariable("id") Long id) {

		Book book = bookService.findOne(id);
		model.addAttribute("book", book);
		return "book";
	}

	// @RequestMapping(value = "/add", method = RequestMethod.GET)
	// public String getAddNewBookForm(@ModelAttribute("newBook") Book newBook) {
	// return "addBook";
	// }

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String processAddNewBookForm(@Valid @ModelAttribute("newBook") Book bookToBeAdded, BindingResult result) {
		if (result.hasErrors()) {
			return "books";
		}

		try {
			bookService.save(bookToBeAdded);
		} catch (Exception up) {
			System.out.println("Transaction Failed!!!");

		}

		return "redirect:/books";
	}

}
