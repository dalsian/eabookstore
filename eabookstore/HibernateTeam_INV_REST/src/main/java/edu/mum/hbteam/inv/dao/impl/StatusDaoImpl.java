package edu.mum.hbteam.inv.dao.impl;


import org.springframework.stereotype.Repository;

import edu.mum.hbteam.inv.dao.StatusDao;
import edu.mum.hbteam.inv.domain.Status;

@Repository
public class StatusDaoImpl extends GenericDaoImpl<Status> implements StatusDao
{	
	public StatusDaoImpl() {
		super.setDaoType(Status.class );
	}  
}

