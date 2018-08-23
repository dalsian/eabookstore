package edu.mum.hbteam.inv.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.hbteam.inv.dao.GenericDao;
import edu.mum.hbteam.inv.dao.UserCredentialsDao;
import edu.mum.hbteam.inv.domain.UserCredentials;

@Service
@Transactional 
public class UserCredentialsServiceImpl implements edu.mum.hbteam.inv.service.UserCredentialsService {
	
 	@Autowired
	private UserCredentialsDao userCredentialsDao;

 	
    public void save( UserCredentials userCredentials) {  		
 		userCredentialsDao.save(userCredentials);
	}
 	
    public void update( UserCredentials userCredentials) {  		
 		userCredentialsDao.update(userCredentials);
	}
 	
  	
	public List<UserCredentials> findAll() {
		return (List<UserCredentials>)userCredentialsDao.findAll();
	}
	
	public UserCredentials findOne(Long id){
		return userCredentialsDao.findOne(id);
	}


	public UserCredentials findByUserName(String userName) {
		return userCredentialsDao.findByUserName(userName);
	}

}
