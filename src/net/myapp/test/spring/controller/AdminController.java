package net.myapp.test.spring.controller;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import net.myapp.common.logging.impl.Log;
import net.myapp.common.web.holders.RequestHelper;
import net.myapp.common.web.holders.WebAuthHelper;
import net.myapp.common.web.holders.WebSessionHelper;
import net.myapp.dao.SecureUserDAO;
import net.myapp.dao.model.SecureUser;
import net.myapp.dao.model.SecureUserEnum;
import net.myapp.exception.user.UserNotFoundException;
import net.myapp.helper.CommonUtil;
import net.myapp.helper.SecureUserUtil;
import net.myapp.helper.secure.Utils;

@Controller

public class AdminController {
	@Autowired
	private MessageSource messageSource;

	@Autowired(required = true)
	@Qualifier(value = "secureUserDAO")
	// private SecureUserDAOImpl secureUserDAOImpl;
	private SecureUserDAO secureUserDAO;

	//// normal page passing to default/jsp folder page inside of main.jsp
	@RequestMapping(value = "/login1", method = RequestMethod.GET)
	public String printHello(@RequestParam(defaultValue = "null") String login,
			@RequestParam(defaultValue = "null") String pass) {
		
		  
System.out.println(login);
		if (!CommonUtil.isNullOrEmpty(login)) {
			Log.debug("login : " + login);
			SecureUser secureUser;
			try {
				secureUser = secureUserDAO.getSecureUser(login);

				

				System.out.println(Utils.getMD5(pass));
				if (secureUser.getPass().equals(Utils.getMD5(pass))) {
					Log.debug("succesfully logined ");
					WebAuthHelper.setAuthenticatedSecureUser(secureUser);

				}
			} catch (UserNotFoundException e1) {
				// TODO Auto-generated catch block
				RequestHelper.setAttribute("ErrorKey", e1.getI18nErrorMessageKey());
				RequestHelper.setAttribute("ErrorArg", e1.getI18nErrorMessageArg());
				System.out.println(e1.getI18nErrorMessageArg());
				e1.printStackTrace();
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
 
		
		if (SecureUserUtil.isAdmin())                              return "redirect:/admin/first";
		else 	if (SecureUserUtil.isSeller())					   return "redirect:/seller/first";
		return "login";
	}
	
	@RequestMapping(value = "/logout1", method = RequestMethod.GET)
	public String printHello1(@RequestParam(defaultValue = "null") String login,
			@RequestParam(defaultValue = "null") String pass) {
		SecureUser secureUser=WebAuthHelper.getAuthenticatedSecureUser();
System.out.println("web session "+secureUser.getLogin()+"  "+secureUser.getPass());
		return "login";
	}
	
	@RequestMapping(value = "/admin/first1", method = RequestMethod.GET)
	public String printHello2(@RequestParam(defaultValue = "null") String login,
			@RequestParam(defaultValue = "null") String pass) {
		return "test";
	}
	
	@RequestMapping(value = "/seller/first1", method = RequestMethod.GET)
	public String printHello3(@RequestParam(defaultValue = "null") String login,
			@RequestParam(defaultValue = "null") String pass) {
		return "test";
	}


}
