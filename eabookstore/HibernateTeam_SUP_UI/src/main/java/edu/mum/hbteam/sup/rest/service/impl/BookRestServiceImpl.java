package edu.mum.hbteam.sup.rest.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import edu.mum.hbteam.sup.domain.Book;
import edu.mum.hbteam.sup.domain.Category;
import edu.mum.hbteam.sup.rest.RestHttpHeader;
import edu.mum.hbteam.sup.rest.service.BookRestService;


@Component("MVC")
public class BookRestServiceImpl  implements BookRestService {

	@Autowired
	RestHttpHeader restHelper;
	
	String baseUrl = "http://localhost:8080/HibernateTeam_SUP_REST/books";
	String baseUrlExtended = baseUrl + "/";

	public List<Book> findAll() {
		
		RestTemplate restTemplate = restHelper.getRestTemplate();
		HttpEntity httpEntity = new HttpEntity(restHelper.getHttpHeaders());
		ResponseEntity<Book[]> responseEntity = restTemplate.exchange(baseUrl, HttpMethod.GET, httpEntity, Book[].class);
		List<Book> bookList = Arrays.asList(responseEntity.getBody());
		return bookList;
	}

	@Override
	public Book findOne(Long index) {
		RestTemplate restTemplate = restHelper.getRestTemplate();
 		return (restTemplate.exchange(baseUrlExtended + index, HttpMethod.GET, restHelper.getHttpEntity(), Book.class).getBody());
	}

	@Override
	public Book save(Book book) {
		RestTemplate restTemplate = restHelper.getRestTemplate();
		HttpEntity<Book> httpEntity = new HttpEntity<Book>(book, restHelper.getHttpHeaders());
		restTemplate.postForObject(baseUrlExtended, httpEntity, Book.class);
		return null;
	}

	@Override
	public List<Category> findCategories() {
		RestTemplate restTemplate = restHelper.getRestTemplate();
		HttpEntity httpEntity = new HttpEntity(restHelper.getHttpHeaders());
		ResponseEntity<Category[]> responseEntity = restTemplate.exchange(baseUrlExtended+"categories", HttpMethod.GET, httpEntity, Category[].class);
		List<Category> categories = Arrays.asList(responseEntity.getBody());
		return categories;
	}

}
