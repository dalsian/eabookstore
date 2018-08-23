package edu.mum.hbteam.inv.amqp;

import org.springframework.amqp.rabbit.core.RabbitTemplate;

import edu.mum.hbteam.inv.domain.Book;

public interface MessagePublisher {
	public void publishStockRequest(RabbitTemplate rabbitTemplate, String isbn, Integer qty);
	public void publishNewPublishBook(RabbitTemplate rabbitTemplate, Book book);
	public void publishStockResponse(RabbitTemplate rabbitTemplate, String isbn, Integer qty);
}
