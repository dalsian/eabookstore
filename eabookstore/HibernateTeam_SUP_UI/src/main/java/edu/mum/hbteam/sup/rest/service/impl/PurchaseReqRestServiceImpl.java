package edu.mum.hbteam.sup.rest.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import edu.mum.hbteam.sup.domain.PurchaseRequest;
import edu.mum.hbteam.sup.rest.RestHttpHeader;
import edu.mum.hbteam.sup.rest.service.PurchaseReqRestService;


@Component("MVC_Purchase")
public class PurchaseReqRestServiceImpl  implements PurchaseReqRestService {

	@Autowired
	RestHttpHeader restHelper;
	
	String baseUrl = "http://localhost:8080/HibernateTeam_SUP_REST/purchases";
	String baseUrlExtended = baseUrl + "/";

	public List<PurchaseRequest> findAll() {
		
		RestTemplate restTemplate = restHelper.getRestTemplate();
		HttpEntity httpEntity = new HttpEntity(restHelper.getHttpHeaders());
		ResponseEntity<PurchaseRequest[]> responseEntity = restTemplate.exchange(baseUrl, HttpMethod.GET, httpEntity,
				PurchaseRequest[].class);
		List<PurchaseRequest> purchaseList = Arrays.asList(responseEntity.getBody());
		return purchaseList;
	}

	@Override
	public PurchaseRequest findOne(Long index) {
		RestTemplate restTemplate = restHelper.getRestTemplate();
 		return (restTemplate.exchange(baseUrlExtended + index, HttpMethod.GET, restHelper.getHttpEntity(), PurchaseRequest.class).getBody());
	}

	@Override
	public PurchaseRequest save(PurchaseRequest purchase) {
		RestTemplate restTemplate = restHelper.getRestTemplate();
		HttpEntity<PurchaseRequest> httpEntity = new HttpEntity<PurchaseRequest>(purchase, restHelper.getHttpHeaders());
		restTemplate.postForObject(baseUrlExtended, httpEntity, PurchaseRequest.class);
		return null;
	}

	@Override
	public void update(Long req) {
		// TODO Auto-generated method stub
		RestTemplate restTemplate = restHelper.getRestTemplate();
		restTemplate.exchange(baseUrlExtended + req, HttpMethod.POST, restHelper.getHttpEntity(), PurchaseRequest.class).getBody();
		
	}

	

}
