package edu.mum.hbteam.sup.service;

import java.util.List;

import edu.mum.hbteam.sup.domain.PurchaseRequest;

 
public interface PurchaseReqService {

	public void save(PurchaseRequest purchase);
	public List<PurchaseRequest> findAll();
	public PurchaseRequest findOne(Long id);
	public void update(Long req);

}
