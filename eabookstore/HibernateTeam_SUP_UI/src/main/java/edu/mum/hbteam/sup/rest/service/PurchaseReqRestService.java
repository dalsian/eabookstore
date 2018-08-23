package edu.mum.hbteam.sup.rest.service;

import java.util.List;

import org.springframework.stereotype.Component;

import edu.mum.hbteam.sup.domain.PurchaseRequest;


@Component
public interface PurchaseReqRestService {

 	public List<PurchaseRequest> findAll();

	public PurchaseRequest findOne(Long index);

	public PurchaseRequest save(PurchaseRequest purchase);

	public void update(Long req);

}
