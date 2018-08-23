package edu.mum.hbteam.integration.transformer;

import org.springframework.integration.annotation.Transformer;

import edu.mum.hbteam.inv.domain.Book;
import edu.mum.hbteam.inv.domain.Category;

public class NewPublishTransformerImpl implements NewPublishTransformer {

	@Override
	@Transformer(inputChannel="newPublishInboundChannel", outputChannel="newPublishOutboundChannel")
	public Book transform(edu.mum.hbteam.sup.domain.Book newBook) {
		System.out.println("NewPublishTransformerImpl in Integration >>> ");
		
		Category category = null;
		if (newBook.getCategory() != null) {
			category = new Category();
			category.setId(newBook.getCategory().getId());
			category.setName(newBook.getCategory().getName());
		}
		 
		Book book = new Book(newBook.getName(), newBook.getAuthor(), newBook.getIsbn(), newBook.getDescription(), 
							newBook.getPrice(), 0, category);
		return book;
	}
}
