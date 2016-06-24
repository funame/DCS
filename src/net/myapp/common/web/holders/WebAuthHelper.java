package net.myapp.common.web.holders;

import net.myapp.dao.model.SecureUser;

public class WebAuthHelper {
	
	public static void setAuthenticatedSecureUser(SecureUser secureUser){
		
		WebSessionHelper.set(SecureUser.class.getSimpleName() ,secureUser);
		
		
	}
	public static SecureUser getAuthenticatedSecureUser(){
		
		return (SecureUser) WebSessionHelper.get(SecureUser.class.getSimpleName());
	}

	 public static boolean isUserAuthenticated()
	  {
	   /* User user = getAuthenticatedUser();
	    if (user != null) {
	      return true;
	    }*/
	    SecureUser secureUser = getAuthenticatedSecureUser();
	    if (secureUser != null) {
	      return true;
	    }
	    return false;
	  }
	 
	 
	  
}
