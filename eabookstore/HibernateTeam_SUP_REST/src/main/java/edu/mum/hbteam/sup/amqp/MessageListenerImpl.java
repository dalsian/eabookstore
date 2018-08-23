package edu.mum.hbteam.sup.amqp;

import org.springframework.beans.factory.annotation.Autowired;

import edu.mum.hbteam.sup.domain.PurchaseRequest;
import edu.mum.hbteam.sup.service.PurchaseReqService;

public class MessageListenerImpl implements MessageListener {

	@Autowired
	PurchaseReqService purchaseReqService;

	@Override
	public void listenPurchaseRequest(PurchaseRequest stockRequest) {
		// TODO Auto-generated method stub

		System.out.println("################################");
		System.out.println("### Purchase request arrived ###");
		System.out.println("ISBN: " + stockRequest.getBook().getIsbn());
		System.out.println("QTY: " + stockRequest.getQuantity());
		System.out.println("Status: " + stockRequest.getStatus().getName());
		System.out.println("################################");
		purchaseReqService.save(stockRequest);
	}

}
