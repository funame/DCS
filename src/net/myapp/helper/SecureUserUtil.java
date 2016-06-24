package net.myapp.helper;

import net.myapp.common.web.holders.WebAuthHelper;
import net.myapp.dao.model.SecureUserEnum;

public class SecureUserUtil {

	public static boolean isAdmin(){
		if ( WebAuthHelper.isUserAuthenticated() && WebAuthHelper.getAuthenticatedSecureUser().getType().equals(SecureUserEnum.ADMIN.name())) {
		 return true;	
		}
		return false;
	}
	public static boolean isSeller(){
		if ( WebAuthHelper.isUserAuthenticated() && WebAuthHelper.getAuthenticatedSecureUser().getType().equals(SecureUserEnum.SELLER.name())) {
		 return true;	
		}
		return false;
	}
}
