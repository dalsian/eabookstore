package edu.mum.hbteam.sup.amqp;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import edu.mum.hbteam.sup.domain.Book;
import edu.mum.hbteam.sup.domain.PurchaseRequest;
import edu.mum.hbteam.sup.service.BookService;

public class MessagePublisherImpl implements MessagePublisher {

	@Autowired
	BookService bookService;
	
	@Override
	public void publishNewPublishBook(RabbitTemplate rabbitTemplate, Book book) {
		System.out.println("========================================");
		System.out.println("=========       MESSAGING      =========");
		System.out.println("========================================");
		System.out.println("Sent new published book to Messagin service >>> ");
		rabbitTemplate.convertAndSend(book);

	}

	@Override
	public void publishStockResponse(RabbitTemplate rabbitTemplate, PurchaseRequest req) {
		
		
		System.out.println("========================================");
		System.out.println("=========       MESSAGING      =========");
		System.out.println("========================================");
		System.out.println("Sent purchase response to Messaging service >>> ");
		rabbitTemplate.convertAndSend(req);
	}

}
