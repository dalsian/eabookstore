package edu.mum.hbteam.inv.dao;

import edu.mum.hbteam.inv.domain.UserCredentials;

public interface UserCredentialsDao extends GenericDao<UserCredentials> {
  
	public UserCredentials findByUserName(String userName);
}
