package edu.mum.hbteam.inv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.hbteam.inv.domain.Book;
import edu.mum.hbteam.inv.service.BookService;
import edu.mum.hbteam.inv.service.NewBookService;


@Controller
@RequestMapping("/newbooks")
public class NewBookController {
	
	@Autowired
	NewBookService newBookService;
	
	@Autowired
	BookService bookService;
	
	@RequestMapping
	public String listBooks(Model model,@ModelAttribute("newBook") Book bookToBeAdded) {
		model.addAttribute("books", newBookService.getAllBooks());
 		return "newbooks";
	}
	
	@RequestMapping(value = "/{id}/request", method = RequestMethod.POST)
	public String processRequestBookForm(@PathVariable("id") Long id, @ModelAttribute("newBook") Book bookToBeRequested,BindingResult result) {
		if(result.hasErrors()) {
			return "newbooks";
		}
		int quantity = bookToBeRequested.getQuantity();
		String isbn = bookToBeRequested.getIsbn();
		bookService.sendRequest(isbn,quantity);
		return "redirect:/newbooks";
	}
}
