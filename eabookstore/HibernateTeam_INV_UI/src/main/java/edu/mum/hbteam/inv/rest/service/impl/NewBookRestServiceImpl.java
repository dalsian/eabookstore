package edu.mum.hbteam.inv.rest.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import edu.mum.hbteam.inv.domain.Book;
import edu.mum.hbteam.inv.rest.RestHttpHeader;
import edu.mum.hbteam.inv.rest.service.BookRestService;
import edu.mum.hbteam.inv.rest.service.NewBookRestService;

@Component("MVC_NewBook")
public class NewBookRestServiceImpl implements NewBookRestService {

	@Autowired
	RestHttpHeader restHelper;

	String baseUrl = "http://localhost:8080/HibernateTeam_INV_REST/newbooks";
	String baseUrlExtended = baseUrl + "/";

	public List<Book> findAll() {

		RestTemplate restTemplate = restHelper.getRestTemplate();
		HttpEntity httpEntity = new HttpEntity(restHelper.getHttpHeaders());
		ResponseEntity<Book[]> responseEntity = restTemplate.exchange(baseUrl, HttpMethod.GET, httpEntity,
				Book[].class);
		List<Book> bookList = Arrays.asList(responseEntity.getBody());
		return bookList;
	}

	@Override
	public Book findOne(Long index) {
		RestTemplate restTemplate = restHelper.getRestTemplate();
		HttpEntity httpEntity = new HttpEntity(restHelper.getHttpHeaders());
		ResponseEntity<Book> responseEntity = restTemplate.exchange(baseUrlExtended + index, HttpMethod.GET, httpEntity,
				Book.class);
		Book book = responseEntity.getBody();
		return book;
	}

	@Override
	public Book save(Book book) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book update(long id, Book book) {
		RestTemplate restTemplate = restHelper.getRestTemplate();
		HttpEntity<Book> httpEntity = new HttpEntity<Book>(book, restHelper.getHttpHeaders());
		book = restTemplate.postForObject(baseUrlExtended + id, httpEntity, Book.class);
		return null;
	}

}
