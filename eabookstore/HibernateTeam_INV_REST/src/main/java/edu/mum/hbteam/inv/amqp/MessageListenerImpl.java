package edu.mum.hbteam.inv.amqp;

import org.springframework.beans.factory.annotation.Autowired;

import edu.mum.hbteam.inv.domain.Book;
import edu.mum.hbteam.inv.domain.BookStatus;
import edu.mum.hbteam.inv.dto.BookQuantity;
import edu.mum.hbteam.inv.service.BookService;
import edu.mum.hbteam.inv.service.StatusService;

public class MessageListenerImpl implements MessageListener {
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private StatusService statusService;
	
//	@Override
//	public void listenStockRequest(BookQuantity stockRequest) {
//		System.out.println("Stock request received in INV_REST>>> ");
//		System.out.println(stockRequest);
//	}

	@Override
	public void listenNewPublish(Book book) {
		System.out.println("New published book received in INV_REST >>> ");
		System.out.println(book);
		bookService.addWithStatus(book, BookStatus.NEW_PUBLISHED);
	}

	@Override
	public void listenStockResponse(BookQuantity stockResponse) {
		System.out.println("Stock response received in INV_REST>>> ");
		System.out.println(stockResponse);
		Book book = bookService.findByIsbn(stockResponse.getIsbn());
		book.setStatus(statusService.findOne(BookStatus.IN_STOCK));
		bookService.update(book);
		bookService.increaseStock(stockResponse.getIsbn(), stockResponse.getQuantity());
	}
	
}
