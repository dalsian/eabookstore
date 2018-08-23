package edu.mum.hbteam.inv.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.hbteam.inv.dao.StatusDao;
import edu.mum.hbteam.inv.domain.Status;
import edu.mum.hbteam.inv.service.StatusService;

@Service
@Transactional 
public class StatusServiceImpl implements StatusService{
	
 	@Autowired
	private StatusDao statusDao;

	public List<Status> getAllStatuss() {
		return statusDao.findAll();
	}

 
    @PreAuthorize("hasRole('ROLE_ADMIN')")
	public void save(Status status) {
		   statusDao.save(status);
	}
	
	public Status findOne(long statusID) {
		return statusDao.findOne(statusID);
	}

	@Override
	public void add(Status status) {
		statusDao.save(status);
	}

	@Override
	public void update(Status status) {
		statusDao.update(status);
	}

}
