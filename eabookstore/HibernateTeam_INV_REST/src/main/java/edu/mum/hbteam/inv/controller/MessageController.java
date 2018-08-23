package edu.mum.hbteam.inv.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.mum.hbteam.inv.amqp.MessagePublisher;
import edu.mum.hbteam.inv.amqp.MessagePublisherImpl;
import edu.mum.hbteam.inv.domain.Book;
import edu.mum.hbteam.inv.service.BookService;

@RestController
@RequestMapping("/msg")
public class MessageController {
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private ApplicationContext appContext;
 
 	@GetMapping("/stockrequest/{isbn}/{qty}")
	public void stockreq(@PathVariable("isbn") String isbn, @PathVariable("qty") Integer qty) {
 		//Publish item
        RabbitTemplate stockRequestTemplate = appContext.getBean("stockRequestTemplate", RabbitTemplate.class);
        MessagePublisher msgService = new MessagePublisherImpl();
        msgService.publishStockRequest(stockRequestTemplate, isbn, qty);
	}
 	
 	@GetMapping("/stockresponse/{isbn}/{qty}")
	public void stockres(@PathVariable("isbn") String isbn, @PathVariable("qty") Integer qty) {
 		//Publish item
        RabbitTemplate stockResponseTemplate = appContext.getBean("stockResponseTemplate", RabbitTemplate.class);
        MessagePublisher msgService = new MessagePublisherImpl();
        msgService.publishStockResponse(stockResponseTemplate, isbn, qty);
	}
	
 	@PostMapping("/newpublish")
 	public void publish(@RequestBody Book book) {
 		//Publish item
 		RabbitTemplate newPublishTemplate = appContext.getBean("newPublishTemplate", RabbitTemplate.class);
        MessagePublisher msgService = new MessagePublisherImpl();
        msgService.publishNewPublishBook(newPublishTemplate, book);
	}
	
}
