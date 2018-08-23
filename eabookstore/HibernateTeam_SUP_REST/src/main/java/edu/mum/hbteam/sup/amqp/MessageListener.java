package edu.mum.hbteam.sup.amqp;

import edu.mum.hbteam.sup.domain.PurchaseRequest;

public interface MessageListener {
	public void listenPurchaseRequest(PurchaseRequest stockRequest);
}
