package edu.mum.hbteam.inv.amqp;

import edu.mum.hbteam.inv.domain.Book;
import edu.mum.hbteam.inv.dto.BookQuantity;

public interface MessageListener {
//	public void listenStockRequest(BookQuantity stockRequest);
	public void listenNewPublish(Book book);
	public void listenStockResponse(BookQuantity stockResponse);
}
