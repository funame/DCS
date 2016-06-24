package net.myapp.dao;

import net.myapp.dao.model.SecureUser;
import net.myapp.exception.user.UserNotFoundException;

public interface SecureUserDAO {

	
	public SecureUser getSecureUser(String login) throws UserNotFoundException;
	
	
	
}
