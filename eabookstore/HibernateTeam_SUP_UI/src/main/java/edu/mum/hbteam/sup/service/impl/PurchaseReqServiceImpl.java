package edu.mum.hbteam.sup.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.hbteam.sup.domain.PurchaseRequest;
import edu.mum.hbteam.sup.rest.service.PurchaseReqRestService;
import edu.mum.hbteam.sup.service.PurchaseReqService;


@Service
@Transactional 
public class PurchaseReqServiceImpl implements PurchaseReqService {
	
	
 	@Autowired
 	@Qualifier("MVC_Purchase")
	private PurchaseReqRestService purchaseReqRestService;

	@Override
	public void save(PurchaseRequest purchase) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<PurchaseRequest> findAll() {
		// TODO Auto-generated method stub
		return purchaseReqRestService.findAll();
	}

	@Override
	public PurchaseRequest findOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Long req) {
		purchaseReqRestService.update(req);
		
	}

    
}
