package edu.mum.hbteam.integration.transformer;

import edu.mum.hbteam.inv.dto.BookQuantity;
import edu.mum.hbteam.sup.domain.PurchaseRequest;

public interface StockRequestTransformer {
	PurchaseRequest transform(BookQuantity bq);
}
