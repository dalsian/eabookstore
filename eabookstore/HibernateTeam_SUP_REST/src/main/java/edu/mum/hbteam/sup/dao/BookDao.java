package edu.mum.hbteam.sup.dao;

import edu.mum.hbteam.sup.domain.Book;

public interface BookDao extends GenericDao<Book> {
      public Book findBookByIsbn(String isbn);
}
