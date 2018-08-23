package edu.mum.hbteam.inv.amqp;

import org.springframework.amqp.rabbit.core.RabbitTemplate;

import edu.mum.hbteam.inv.domain.Book;
import edu.mum.hbteam.inv.dto.BookQuantity;

public class MessagePublisherImpl implements MessagePublisher {
	
	@Override
	public void publishStockRequest(RabbitTemplate rabbitTemplate, String isbn, Integer qty) {
		
		BookQuantity request = new BookQuantity(isbn, qty);
		System.out.println("========================================");
		System.out.println("=========       MESSAGING      =========");
		System.out.println("========================================");
		System.out.println("Sending Stock Request from INV_REST >>> ");
		rabbitTemplate.convertAndSend(request);
	}

	@Override
	public void publishNewPublishBook(RabbitTemplate rabbitTemplate, Book book) {
		System.out.println("========================================");
		System.out.println("=========       MESSAGING      =========");
		System.out.println("========================================");
		System.out.println("Sending New Publish from INV_REST >>> ");
		rabbitTemplate.convertAndSend(book);
	}

	@Override
	public void publishStockResponse(RabbitTemplate rabbitTemplate, String isbn, Integer qty) {
		BookQuantity response = new BookQuantity(isbn, qty);
		System.out.println("========================================");
		System.out.println("=========       MESSAGING      =========");
		System.out.println("========================================");
		System.out.println("Sending Stock Response from INV_REST >>> ");
		rabbitTemplate.convertAndSend(response);
	}


}
