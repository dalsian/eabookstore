package edu.mum.hbteam.integration.transformer;

import org.springframework.integration.annotation.Transformer;

import edu.mum.hbteam.inv.dto.BookQuantity;
import edu.mum.hbteam.sup.domain.PurchaseRequest;

public class StockResponseTransformerImpl implements StockResponseTransformer {

	@Override
	@Transformer(inputChannel="stockResponseInboundChannel", outputChannel="stockResponseOutboundChannel")
	public BookQuantity transform(PurchaseRequest purchaseRequest) {
		System.out.println("StockResponseTransformerImpl in Integration >>> ");
		BookQuantity bookQuantity = new BookQuantity(purchaseRequest.getBook().getIsbn(), purchaseRequest.getQuantity());
		return bookQuantity;
	}

}
