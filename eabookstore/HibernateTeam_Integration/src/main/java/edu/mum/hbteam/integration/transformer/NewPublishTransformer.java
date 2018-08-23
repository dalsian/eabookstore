package edu.mum.hbteam.integration.transformer;

import edu.mum.hbteam.inv.domain.Book;

public interface NewPublishTransformer {
	Book transform(edu.mum.hbteam.sup.domain.Book book);
}
