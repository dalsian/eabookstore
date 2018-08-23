package edu.mum.hbteam.inv.dao.impl;


import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import edu.mum.hbteam.inv.dao.BookDao;
import edu.mum.hbteam.inv.domain.Book;
import edu.mum.hbteam.inv.domain.Status;

@Repository
public class BookDaoImpl extends GenericDaoImpl<Book> implements BookDao
{	
	public BookDaoImpl() {
		super.setDaoType(Book.class );
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Book> findAllByStatus(Status status) {
		
		Query query =  entityManager.createQuery("select b from Book b join b.status s where s = :status");
		query.setParameter("status", status);
		
		return query.getResultList();
	}

	@Override
	public void increaseStock(String isbn, int qty) {
		
		Query query =  entityManager.createQuery("update Book b set b.quantity = b.quantity + :qty where b.isbn = :isbn");
		query.setParameter("isbn", isbn);
		query.setParameter("qty", qty);
		
		query.executeUpdate();
	}

	@Override
	public Book findByIsbn(String isbn) {
		Query query =  entityManager.createQuery("select b from Book b where b.isbn = :isbn");
		query.setParameter("isbn", isbn);
		return (Book) query.getSingleResult();
	}  
}

