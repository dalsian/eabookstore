package edu.mum.hbteam.sup.dao.impl;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import edu.mum.hbteam.sup.dao.PurchaseReqDao;
import edu.mum.hbteam.sup.domain.PurchaseRequest;
import edu.mum.hbteam.sup.domain.Status;

@SuppressWarnings("unchecked")
@Repository
public class PurchaseReqDaoImpl extends GenericDaoImpl<PurchaseRequest> implements PurchaseReqDao {

	public PurchaseReqDaoImpl() {
		super.setDaoType(PurchaseRequest.class);
	}

	@Override
	public Status getStatusById(Long id) {
		Query query =  entityManager.createQuery("select s from Status s where s.id = :id");
		query.setParameter("id", id);
		
		return (Status) query.getSingleResult();
	}

}