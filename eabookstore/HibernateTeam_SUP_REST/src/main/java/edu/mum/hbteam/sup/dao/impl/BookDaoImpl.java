package edu.mum.hbteam.sup.dao.impl;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import edu.mum.hbteam.sup.dao.BookDao;
import edu.mum.hbteam.sup.domain.Book;

@Repository
public class BookDaoImpl extends GenericDaoImpl<Book> implements BookDao {

	public BookDaoImpl() {
		super.setDaoType(Book.class);
	}

	@Override
	public Book findBookByIsbn(String isbn) {
		
		Query query =  entityManager.createQuery("select b from Book b where b.isbn = :isbn");
		query.setParameter("isbn", isbn);
		return (Book) query.getSingleResult();
	}

}