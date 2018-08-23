package edu.mum.hbteam.sup.controller;

import java.util.List;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import edu.mum.hbteam.sup.amqp.MessagePublisher;
import edu.mum.hbteam.sup.amqp.MessagePublisherImpl;
import edu.mum.hbteam.sup.domain.PurchaseRequest;
import edu.mum.hbteam.sup.domain.Status;
import edu.mum.hbteam.sup.service.PurchaseReqService;

@RestController
@RequestMapping("/purchases")
public class PurchaseReqController {
	
	@Autowired
	private PurchaseReqService purchaseReqService;
 
	@Autowired
	private ApplicationContext appContext;
	
 	@RequestMapping({"","/"})
	public @ResponseBody List<PurchaseRequest> list() {
		return purchaseReqService.findAll();
	}
	
 	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody PurchaseRequest getItemById( @RequestParam("id") Long id) {
		return purchaseReqService.findOne(id);
	}
 	
 	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
 	@ResponseStatus(value = HttpStatus.NO_CONTENT)
 	public void updateItem(@PathVariable("id") Long id) {
		PurchaseRequest req = purchaseReqService.findOne(id);
		Status status  = new Status();
		status.setId(1L);
		status.setName("CONFIRMED");
		req.setStatus(status);
		
		// call publish method
		RabbitTemplate rbtTemplate = appContext.getBean("stockResponseTemplate", RabbitTemplate.class);
		MessagePublisher messagePublisher = new MessagePublisherImpl();
		messagePublisher.publishStockResponse(rbtTemplate, req);
		
 		purchaseReqService.update(req);
 	}
	   
	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void addItem(@RequestBody PurchaseRequest PurchaseToBeAdded) {
		
 		try {
			purchaseReqService.save(PurchaseToBeAdded);
		} catch (Exception up) {
	      System.out.println("Transaction Failed!!!");
 
		}
	}
   
}
