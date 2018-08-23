package edu.mum.hbteam.sup.amqp;

import org.springframework.amqp.rabbit.core.RabbitTemplate;

import edu.mum.hbteam.sup.domain.Book;
import edu.mum.hbteam.sup.domain.PurchaseRequest;

public interface MessagePublisher {
	public void publishNewPublishBook(RabbitTemplate rabbitTemplate, Book book);
	public void publishStockResponse(RabbitTemplate rabbitTemplate, PurchaseRequest req);
}
