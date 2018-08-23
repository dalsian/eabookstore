package edu.mum.hbteam.inv.service;

import java.util.List;

import edu.mum.hbteam.inv.domain.Status;

public interface StatusService {

	List<Status> getAllStatuss();

  	void save(Status status);

	Status findOne(long id);
 
	void add(Status status);
	
	void update(Status status);

}
