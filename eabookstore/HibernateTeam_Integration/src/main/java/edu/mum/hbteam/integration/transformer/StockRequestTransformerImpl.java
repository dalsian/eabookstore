package edu.mum.hbteam.integration.transformer;

import org.springframework.integration.annotation.Transformer;

import edu.mum.hbteam.inv.dto.BookQuantity;
import edu.mum.hbteam.sup.domain.Book;
import edu.mum.hbteam.sup.domain.PurchaseRequest;
import edu.mum.hbteam.sup.domain.Status;

public class StockRequestTransformerImpl implements StockRequestTransformer {

	@Override
	@Transformer(inputChannel="stockRequestInboundChannel", outputChannel="stockRequestOutboundChannel")
	public PurchaseRequest transform(BookQuantity bq) {
		System.out.println("StockRequestTransformerImpl in Integration >>> ");
		PurchaseRequest req = new PurchaseRequest();
		Book book = new Book();
		book.setIsbn(bq.getIsbn());
		req.setBook(book);
		req.setQuantity(bq.getQuantity());
		Status status = new Status();
		status.setId(2L);
		status.setName("PENDING");
		req.setStatus(status);
		return req;
	}

}
