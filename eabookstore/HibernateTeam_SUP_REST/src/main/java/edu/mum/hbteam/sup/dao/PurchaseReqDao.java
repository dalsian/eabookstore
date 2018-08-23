package edu.mum.hbteam.sup.dao;

import edu.mum.hbteam.sup.domain.PurchaseRequest;
import edu.mum.hbteam.sup.domain.Status;



public interface PurchaseReqDao extends GenericDao<PurchaseRequest> {
      public Status getStatusById(Long id);
}
