package edu.mum.hbteam.sup.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.hbteam.sup.dao.BookDao;
import edu.mum.hbteam.sup.dao.GenericDao;
import edu.mum.hbteam.sup.dao.PurchaseReqDao;
import edu.mum.hbteam.sup.dao.impl.GenericDaoImpl;
import edu.mum.hbteam.sup.domain.Book;
import edu.mum.hbteam.sup.domain.PurchaseRequest;
import edu.mum.hbteam.sup.domain.Status;
import edu.mum.hbteam.sup.service.PurchaseReqService;

@Service
@Transactional
public class PurchaseReqServiceImpl implements PurchaseReqService {

	@Autowired
	private PurchaseReqDao purchaseReqDao;
	
	@Autowired
	private BookDao bookDao;

	public void save(PurchaseRequest purchase) {
		Book book = bookDao.findBookByIsbn(purchase.getBook().getIsbn());
		purchase.setBook(book);
		Status status = purchaseReqDao.getStatusById(purchase.getStatus().getId());
		purchase.setStatus(status);
		if (book != null) {
			purchaseReqDao.save(purchase);
		}
	}

	public PurchaseRequest update(PurchaseRequest purchase) {
		return purchaseReqDao.update(purchase);
	}

	public List<PurchaseRequest> findAll() {
		return (List<PurchaseRequest>) purchaseReqDao.findAll();
	}

	public PurchaseRequest findOne(Long id) {
		return purchaseReqDao.findOne(id);
	}
}
